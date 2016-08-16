package com.webportal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by amarendra on 27/03/16.
 */
@Entity
class Person {  // PERSONS

	@Id // unique key index
	@GeneratedValue // auto incrementing
	private Long id; // ID

	private String personName; // PERSON_NAME

	public Long getId() {
		return id;
	}

	public String getPersonName() {
		return personName;
	}

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", personName='" + personName + '\'' +
				'}';
	}

	Person() { // Crap JPA ..
	}

	public Person(String personName) {

		this.personName = personName;
	}
}
