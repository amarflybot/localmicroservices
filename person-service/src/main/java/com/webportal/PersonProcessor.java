package com.webportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * Created by amarendra on 27/03/16.
 */
@MessageEndpoint
class PersonProcessor {

	@Autowired
	private PersonRepository personRepository;

	@ServiceActivator(inputChannel = "input")
	public void acceptNewPersons(String personName) {
		this.personRepository.save(new Person(personName));
	}
}
