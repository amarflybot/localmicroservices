package com.webportal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@EnableBinding(Sink.class)
@EnableDiscoveryClient
@SpringBootApplication
public class PersonServiceApplication {

	@Bean
	HealthIndicator paris() {
		return () -> Health.status("je suis Paris!").build();
	}

	@Bean
	CommandLineRunner start(PersonRepository personRepository) {
		return args -> {
			Stream.of("Amar", "Sonia", "Nadeem", "Prakriti", "Ashwini")
					.forEach(name -> personRepository.save(new Person(name)));
			personRepository.findAll().forEach(System.out::println);
		};
	}

	/*@Bean
	CommandLineRunner mongoDataInsert(ComputerRepository computerRepository){
		return args -> {
			List<RAM> ramList = new ArrayList<>();
			ramList.add(new RAM(1L, "Corsair", RAMCLASS.CLASS1));
			ramList.add(new RAM(2L, "Transcendent", RAMCLASS.CLASS2));
			Computer computer = new Computer(1L, "Name", 123, "Brand",
					new MotherBoard(1L, "InteMotherBoard"),
					ramList);
			computerRepository.save(computer);
			computerRepository.findAll().forEach(System.out::println);
		};
	}*/

	public static void main(String[] args) {
		SpringApplication.run(PersonServiceApplication.class, args);
	}
}

