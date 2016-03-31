package com.webportal;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by amarendra on 27/03/16.
 */
@FeignClient(name = "person-service")
interface PersonReader {

	@RequestMapping(method = RequestMethod.GET, value = "/persons")
	Resources<Person> readPersons();
}
