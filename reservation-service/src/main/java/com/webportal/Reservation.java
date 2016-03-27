package com.webportal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by amarendra on 27/03/16.
 */
@Entity
class Reservation {  // RESERVATIONS

	@Id // unique key index
	@GeneratedValue // auto incrementing
	private Long id; // ID

	private String reservationName; // RESERVATION_NAME

	public Long getId() {
		return id;
	}

	public String getReservationName() {
		return reservationName;
	}

	@Override
	public String toString() {
		return "Reservation{" +
				"id=" + id +
				", reservationName='" + reservationName + '\'' +
				'}';
	}

	Reservation() {// pourquoi JPA pourquoi???
	}

	public Reservation(String reservationName) {

		this.reservationName = reservationName;
	}
}
