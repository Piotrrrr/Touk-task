package com.example.touk;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.ZonedDateTime;

@Configuration
public class DBInit {

    @Bean
    CommandLineRunner init(FilmRepository filmRepository, ScreeningRoomRepository screeningRoomRepository, SeatRepository seatRepository, ReservedSeatRepository reservedSeatRepository, ScreeningRepository screeningRepository) {
        return args -> {
            Film theroom = new Film("The Room", "Tommy Wiseau", 91);
            Film shrek = new Film("Shrek", "Andrew Adamson, Vicky Jenson", 90);
            Film bee = new Film("Bee Movie", "Steve Hickner, Simon J. Smith", 90);
            filmRepository.save(theroom);
            filmRepository.save(shrek);
            filmRepository.save(bee);
            ScreeningRoom screeningRoom1 = new ScreeningRoom(1, 60);
            ScreeningRoom screeningRoom2 = new ScreeningRoom(2, 84);
            ScreeningRoom screeningRoom3 = new ScreeningRoom(3, 100);
            screeningRoomRepository.save(screeningRoom2);
            screeningRoomRepository.save(screeningRoom1);
            screeningRoomRepository.save(screeningRoom3);
            makeSeats(6, 10, screeningRoom1, seatRepository);
            makeSeats(9, 9, screeningRoom2, seatRepository); seatRepository.save(new Seat(9, 10, screeningRoom2));
            seatRepository.save(new Seat(9, 11, screeningRoom2)); seatRepository.save(new Seat(9, 12, screeningRoom2));
            makeSeats(10, 10, screeningRoom3, seatRepository);

            Screening screening1 = new Screening(screeningRoom1, theroom, new Timestamp(1633867200000L));
            Screening screening2 = new Screening(screeningRoom2, shrek, new Timestamp(1633867200000L));
            Screening screening3 = new Screening(screeningRoom3, bee, new Timestamp(1633867200000L));
            Screening screening4 = new Screening(screeningRoom1, shrek, new Timestamp(1633878000000L));
            Screening screening5 = new Screening(screeningRoom2, bee, new Timestamp(1633878000000L));
            Screening screening6 = new Screening(screeningRoom3, theroom, new Timestamp(1633878000000L));

            screeningRepository.save(screening1);   screeningRepository.save(screening2);   screeningRepository.save(screening3);
            screeningRepository.save(screening4);   screeningRepository.save(screening5);   screeningRepository.save(screening6);
            for (Screening screening : screeningRepository.findAll()) {
                for (Seat s : seatRepository.findAll()) {
                    if (s.screeningRoom.getId() == screening.getScreeningRoom().getId()) {
                        reservedSeatRepository.save(new ReservedSeat(TicketType.EMPTY, s, screening));
                    }
                }
            }
        };
    }

    private void makeSeats(int rows, int seats, ScreeningRoom screeningRoom, SeatRepository seatRepository){
        for(int i = 1; i <= rows ; i++){
            for(int j = 1 ; j <= seats ; j++){
                seatRepository.save(new Seat(i, j, screeningRoom));
            }
        }
    }


}
