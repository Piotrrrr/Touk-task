package com.example.touk;

public class ReservedSeatDTO {
    private int id;
    private TicketType ticketType;
    private int rowNumber;
    private int seatNumber;

    public ReservedSeatDTO() {
    }

    public ReservedSeatDTO(ReservedSeat reservedSeat){
        id = reservedSeat.getId();
        ticketType = reservedSeat.getTicketType();
        rowNumber = reservedSeat.getSeat().getRowNumber();
        seatNumber = reservedSeat.getSeat().getSeatNumber();
    }

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
}
