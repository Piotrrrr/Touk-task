package com.example.touk;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Screening {
    @Id @GeneratedValue private int id;
    @ManyToOne @JoinColumn(name = "screening_room_id")
    private ScreeningRoom screeningRoom;
    @ManyToOne @JoinColumn(name = "film_id")
    private Film film;
    private Timestamp screeningTime;
    @OneToMany (mappedBy = "screening")
    private List<Reservation> reservations;
    @OneToMany (mappedBy = "screening")
    private List<ReservedSeat> reservedSeats;

    public Screening(ScreeningRoom screeningRoom, Film film, Timestamp screeningTime) {
        this.screeningRoom = screeningRoom;
        this.film = film;
        this.screeningTime = screeningTime;
    }

    public Screening(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ScreeningRoom getScreeningRoom() {
        return screeningRoom;
    }

    public void setScreeningRoom(ScreeningRoom screeningRoom) {
        this.screeningRoom = screeningRoom;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Timestamp getScreeningTime() {
        return screeningTime;
    }

    public void setScreeningTime(Timestamp screeningTime) {
        this.screeningTime = screeningTime;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<ReservedSeat> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<ReservedSeat> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }
}
