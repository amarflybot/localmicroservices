package com.webportal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@EnableBinding (Sink.class)
@EnableDiscoveryClient
@SpringBootApplication
public class ReservationServiceApplication {

    @Bean
    CommandLineRunner runner (ReservationRepository reservationRepository){
        return args -> {
            Arrays.asList("Amarendra, Sonia, Nadeem, Sanal".split(","))
                    .forEach( x -> reservationRepository.save(new Reservation(x)));
            reservationRepository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    AlwaysSampler alwaysSampler(){
        return new AlwaysSampler();
    }
	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
	}
}
