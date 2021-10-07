package com.example.touk;

import java.sql.Timestamp;
import java.util.List;

public class ReservationOrder {
    Timestamp expiration;
    double price;
    int reservationId;

    public ReservationOrder() {
    }

    public ReservationOrder(Timestamp expiration, double price, int reservationId) {
        this.expiration = expiration;
        this.price = price;
        this.reservationId = reservationId;
    }

    public ReservationOrder(Reservation reservation){
        this.expiration = new Timestamp(reservation.getScreening().getScreeningTime().getTime() - (15*3600));
        this.reservationId = reservation.getId();
        double sum = 0.0;
        for (ReservedSeat reservedSeat : reservation.getReservedSeats()) {
            switch (reservedSeat.getTicketType().getId()) {
                case 2 : sum+=25.0; break;
                case 3 : sum+=18.0; break;
                case 4 : sum+=12.5; break;
            }
        }
        price=sum;
    }

    public Timestamp getExpiration() {
        return expiration;
    }

    public void setExpiration(Timestamp expiration) {
        this.expiration = expiration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
}
