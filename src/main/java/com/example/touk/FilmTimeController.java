package com.example.touk;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class FilmTimeController {

    private final FilmRepository filmRepository;

    FilmTimeController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping("/film")
    public List<FilmTime> get(@RequestParam String after, @RequestParam String before) {
        Timestamp ts1 = Timestamp.valueOf(after);
        Timestamp ts2 = Timestamp.valueOf(before);
        List<Film> films = new ArrayList<>();
        List<FilmTime> result = new ArrayList<>();
        for (Film film : filmRepository.findAll(Sort.by("title"))) {
            if (!films.contains(film)) {
                films.add(film);
                FilmTime filmTime = new FilmTime(film);
                filmTime.screenings= new ArrayList<>();
                Comparator<Screening> byTime = Comparator.comparing(Screening::getScreeningTime);
                film.screenings.sort(byTime);
                for (Screening screening : film.screenings) {
                    if (!screening.getScreeningTime().equals(null) && screening.getScreeningTime().after(ts1) && screening.getScreeningTime().before(ts2)){
                        filmTime.addScreening(screening);
                    }
                }
                if(!filmTime.screenings.isEmpty()) result.add(filmTime);
            }
        }
        return result;
    }
}
