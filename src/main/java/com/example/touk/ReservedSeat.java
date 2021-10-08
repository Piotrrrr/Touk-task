package com.example.touk;

import javax.persistence.*;

@Entity
public class ReservedSeat {
    @Id @GeneratedValue int id;
    TicketType ticketType;
    @ManyToOne @JoinColumn(name = "seat_id")
    Seat seat;
    @ManyToOne @JoinColumn(name = "reservation_id")
    Reservation reservation;
    @ManyToOne @JoinColumn(name = "screening_id")
    Screening screening;

    public ReservedSeat(TicketType ticketType, Seat seat, Screening screening) {
        this.ticketType = ticketType;
        this.seat = seat;
        this.screening = screening;
    }

    public ReservedSeat(TicketType ticketType, Seat seat, Reservation reservation, Screening screening) {
        this.ticketType = ticketType;
        this.seat = seat;
        this.reservation = reservation;
        this.screening = screening;
    }

    public ReservedSeat(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }
}
