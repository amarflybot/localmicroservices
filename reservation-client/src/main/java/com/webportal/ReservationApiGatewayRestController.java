package com.webportal;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by amarendra on 02/03/16.
 */
@RestController
@RequestMapping ("/reservations")
public class ReservationApiGatewayRestController {

    @Autowired
    @Output (Source.OUTPUT)
    private MessageChannel messageChannel;


    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @HystrixCommand (fallbackMethod = "getReservationNamesFallBack")
    @RequestMapping ("/name")
    public Collection<String> getReservationNames(){
        ParameterizedTypeReference<Resources<ReservationDTO>> ptr =
                new ParameterizedTypeReference<Resources<ReservationDTO>>(){};
        ResponseEntity<Resources<ReservationDTO>> responseEntity = this.restTemplate.exchange("http://reservation-service/reservations",
                HttpMethod.GET, null, ptr);
        return responseEntity
                .getBody()
                .getContent()
                .stream()
                .map(ReservationDTO::getReservationName)
                .collect(Collectors.toList());
    }

    @RequestMapping (method = RequestMethod.POST)
    public void write (@RequestBody ReservationDTO reservationDTO){
        this.messageChannel.send(MessageBuilder.withPayload(reservationDTO.getReservationName()).build());
    }

    public Collection<String> getReservationNamesFallBack(){
        return Collections.emptyList();
    }
}
