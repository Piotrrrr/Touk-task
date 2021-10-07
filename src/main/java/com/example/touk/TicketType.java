package com.example.touk;


public enum TicketType {
    EMPTY(1), ADULT(2), STUDENT(3), CHILD(4);
    private final int id;

    TicketType(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }



}
