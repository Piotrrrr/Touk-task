package com.example.touk;

import java.util.ArrayList;
import java.util.List;

public class ScreeningSeat {
    int screeningRoomNumber;
    int totalSeats;
    List<ReservedSeatDTO> seatList = new ArrayList<>();

    ScreeningSeat(Screening screening){
        screeningRoomNumber = screening.getScreeningRoom().number;
        totalSeats = screening.getScreeningRoom().numberOfSeats;
        for (ReservedSeat reservedSeat : screening.getReservedSeats()) {
            seatList.add(new ReservedSeatDTO(reservedSeat));
        }
    }

    public int getScreeningRoomNumber() {
        return screeningRoomNumber;
    }

    public void setScreeningRoomNumber(int screeningRoomNumber) {
        this.screeningRoomNumber = screeningRoomNumber;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public List<ReservedSeatDTO> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<ReservedSeatDTO> seatList) {
        this.seatList = seatList;
    }
}
