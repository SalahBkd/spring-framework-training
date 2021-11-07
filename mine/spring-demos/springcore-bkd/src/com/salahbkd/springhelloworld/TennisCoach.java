package com.salahbkd.springhelloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("tennisCoach")
@Scope("singleton")
public class TennisCoach implements Coach {
    private APIService getGamesSchedule;

    @Autowired
    public TennisCoach(@Qualifier("tennisCoachService")APIService schedule) {
            this.getGamesSchedule = schedule;
    }

    @Override
    public String getDailyWorkout() {
        return "tennis coach workout";
    }

    @Override
    public String getGamesSchedule() {
        return getGamesSchedule.getGamesSchedule();
    }

    @PostConstruct
    public void init() {
        System.out.println("initializing tennis coach");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroying tennis coach");
    }

}
