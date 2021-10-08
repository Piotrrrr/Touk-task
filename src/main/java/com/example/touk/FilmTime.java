package com.example.touk;

import java.sql.Timestamp;
import java.util.List;

public class FilmTime {
    String title;
    int duration;
    List<IdTime> screenings;

     static class IdTime{
        Timestamp timestamp;
        int screeningId;

         public IdTime() {}

         IdTime(Screening screening){
            timestamp=screening.getScreeningTime();
            screeningId = screening.getId();
        }

         public Timestamp getTimestamp() {
             return timestamp;
         }

         public void setTimestamp(Timestamp timestamp) {
             this.timestamp = timestamp;
         }

         public int getScreeningId() {
             return screeningId;
         }

         public void setScreeningId(int screeningId) {
             this.screeningId = screeningId;
         }
     }
    FilmTime(Film film){
        title=film.title;
        duration=film.duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<IdTime> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<IdTime> screenings) {
        this.screenings = screenings;
    }

    public void addScreening(Screening screening){
        screenings.add(new IdTime(screening));
    }
}
