package com.example.touk;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class ScreeningRoom {
    @Id @GeneratedValue int id;
    int number;
    int numberOfSeats;
    @OneToMany(mappedBy = "screeningRoom")
    List<Seat> seats;
    @OneToMany(mappedBy = "screeningRoom")
    List<Screening> screenings;


    public ScreeningRoom(int number, int numberOfSeats) {
        this.number = number;
        this.numberOfSeats = numberOfSeats;
    }

    public ScreeningRoom(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Screening> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<Screening> screenings) {
        this.screenings = screenings;
    }

}
