package com.webportal;

/**
 * Created by amarendra on 02/03/16.
 */
public class ReservationDTO {

    private Long id;
    private String reservationName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }
}
