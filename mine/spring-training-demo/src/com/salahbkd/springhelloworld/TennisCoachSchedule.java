package com.salahbkd.springhelloworld;

import org.springframework.stereotype.Component;

@Component("tennisCoachService")
public class TennisCoachSchedule implements APIService {

    @Override
    public String getGamesSchedule() {
        return "tennis coach schedule";
    }
}
