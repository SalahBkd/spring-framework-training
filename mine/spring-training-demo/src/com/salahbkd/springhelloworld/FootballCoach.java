package com.salahbkd.springhelloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("footCoach")
@Scope("singleton")
public class FootballCoach implements Coach {
    private APIService getGamesSchedule;

    @Autowired
    public FootballCoach(@Qualifier("footballCoachService") APIService schedule) {
        this.getGamesSchedule = schedule;
    }

    @Override
    public String getDailyWorkout() {
        return "football coach daily workout";
    }

    @Override
    public String getGamesSchedule() {
        return getGamesSchedule.getGamesSchedule();
    }

}
