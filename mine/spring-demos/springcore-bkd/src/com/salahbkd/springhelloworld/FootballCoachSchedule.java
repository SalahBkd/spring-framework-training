package com.salahbkd.springhelloworld;

import org.springframework.stereotype.Component;

@Component("footballCoachService")
public class FootballCoachSchedule implements APIService {
    @Override
    public String getGamesSchedule() {
        return "Games schedule...";
    }
}
