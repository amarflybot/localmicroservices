package com.webportal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by amarendra on 8/3/17.
 */
@RestController
@RequestMapping("/hello")
public class TestController {


    private final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private Tracer tracer;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity test1(){
        LOGGER.info("Test1",tracer.getCurrentSpan());
        String forObject = restTemplate.getForObject("http://localhost:9001/hello", String.class);
        return new ResponseEntity(forObject, HttpStatus.OK);
    }
}
