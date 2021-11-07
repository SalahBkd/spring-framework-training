package com.salahbkd.springhelloworld;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

       // var footCoach1 = context.getBean("footCoach", Coach.class);
       // var footCoach2 = context.getBean("footCoach", Coach.class);


        var teenisCoach1 = context.getBean("tennisCoach", Coach.class);
        var teenisCoach2 = context.getBean("tennisCoach", Coach.class);

       // System.out.println(footCoach1.getDailyWorkout());
       // System.out.println(footCoach1.getGamesSchedule());

       // System.out.println(footCoach1 == footCoach2);
        System.out.println(teenisCoach1 == teenisCoach2);

        context.close();
    }

}
