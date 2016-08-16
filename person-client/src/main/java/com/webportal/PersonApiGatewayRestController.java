package com.webportal;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by amarendra on 27/03/16.
 */
@RestController
@RequestMapping("/persons")
class PersonApiGatewayRestController {

	@Autowired
	private PersonReader reader;

	@Autowired
	private PersonWriter writer;

	@RequestMapping(method = RequestMethod.POST)
	public void write(@RequestBody Person r) {
		this.writer.writePerson(r.getPersonName());
	}

	public Collection<String> fallback() {
		return new ArrayList<>();
	}

	@HystrixCommand(fallbackMethod = "fallback")
	@RequestMapping(method = RequestMethod.GET, value = "/names")
	public Collection<String> personNames() {
		Resources<Person> persons = this.reader.readPersons();
		return persons
				.getContent()
				.stream()
				.map(Person::getPersonName)
				.collect(Collectors.toList());
	}


}
