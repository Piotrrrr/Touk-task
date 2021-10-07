package com.example.touk;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScreeningSeatController {
    private final ScreeningRepository screeningRepository;

    public ScreeningSeatController(ScreeningRepository screeningRepository){
        this.screeningRepository=screeningRepository;
    }

    @GetMapping("/seat")
    public ScreeningSeat get(@RequestParam int screeningId){
        return new ScreeningSeat(screeningRepository.getById(screeningId));
    }
}
