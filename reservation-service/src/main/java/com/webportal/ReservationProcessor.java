package com.webportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * Created by amarendra on 27/03/16.
 */
@MessageEndpoint
class ReservationProcessor {

	@Autowired
	private ReservationRepository reservationRepository;

	@ServiceActivator(inputChannel = "input")
	public void acceptNewReservations(String reservationName) {
		this.reservationRepository.save(new Reservation(reservationName));
	}
}
