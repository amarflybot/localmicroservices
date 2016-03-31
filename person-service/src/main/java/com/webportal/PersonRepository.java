package com.webportal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Collection;

/**
 * Created by amarendra on 27/03/16.
 */
@RepositoryRestResource
interface PersonRepository extends JpaRepository<Person, Long> {

	// select * from persons where person_name = :rn
	@RestResource(path = "by-name")
	Collection<Person> findByPersonName(@Param("rn") String rn);
}
