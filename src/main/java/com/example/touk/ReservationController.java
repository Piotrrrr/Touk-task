package com.example.touk;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    private final ReservationRepository reservationRepository;
    private final ReservedSeatRepository reservedSeatRepository;

    public ReservationController(ReservationRepository reservationRepository, ReservedSeatRepository reservedSeatRepository) {
        this.reservationRepository = reservationRepository;
        this.reservedSeatRepository = reservedSeatRepository;
    }

    // Map -> K is reservedSeatId; V is ticketType
    @PostMapping("/reservation")
    public ReservationOrder post(@RequestParam String name, @RequestParam String surname, @RequestParam List<Integer> seats, @RequestParam List<Integer> tickets) {
        if (!seats.isEmpty()) {
            List<ReservedSeat> reservedSeats = reservedSeatRepository.findAllById(seats);
            Reservation reservation = new Reservation(name, surname, reservedSeatRepository.getById(reservedSeats.get(0).getId()).getScreening());
            reservation.setReservedSeats(reservedSeats);
            TicketTypeConverter ticketTypeConverter = new TicketTypeConverter();
            for (int i =0 ; i < seats.size() ; i++) {
                reservedSeatRepository.getById(seats.get(i)).setTicketType(ticketTypeConverter.convertToEntityAttribute(tickets.get(i)));
            }
            reservationRepository.save(reservation);
            return new ReservationOrder(reservation);
        }
        return null;
    }

}
