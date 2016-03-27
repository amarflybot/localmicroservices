package com.webportal;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

/**
 * Created by amarendra on 27/03/16.
 */
@MessagingGateway
interface ReservationWriter {

	@Gateway(requestChannel = "output")
	void writeReservation(String reservationName);
}
