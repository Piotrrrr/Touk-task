package com.example.touk;

import javax.persistence.*;
import java.util.List;

@Entity
public class Seat {
    @Id
    @GeneratedValue int id;
    int rowNumber;
    int seatNumber;
    @ManyToOne @JoinColumn(name="screening_room_id")
    ScreeningRoom screeningRoom;
    @OneToMany (mappedBy = "seat")
    List<ReservedSeat> reservedSeats;

    public Seat(int rowNumber, int seatNumber, ScreeningRoom screeningRoom) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.screeningRoom = screeningRoom;
    }

    public Seat(int rowNumber, int seatNumber) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
    }

    public Seat(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public ScreeningRoom getScreeningRoomId() {
        return screeningRoom;
    }

    public void setScreeningRoomId(ScreeningRoom screeningRoom) {
        this.screeningRoom = screeningRoom;
    }
}
