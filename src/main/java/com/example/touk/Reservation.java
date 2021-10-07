package com.example.touk;

import javax.persistence.*;
import java.util.List;

@Entity
public class Reservation {
    @Id @GeneratedValue private int id;
    private String firstName;
    private String lastName;
    @ManyToOne @JoinColumn(name = "screening_id")
    private Screening screening;
    @OneToMany (mappedBy = "reservation")
    private List<ReservedSeat> reservedSeats;

    public Reservation(String firstName, String lastName, Screening screening) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.screening = screening;
    }

    public Reservation(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public List<ReservedSeat> getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(List<ReservedSeat> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

}
