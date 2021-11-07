package io.salahboutainawarda.parkinglot.lot;

public class PaymentCounter {

    private long totalCash;
    private final int ONE_CURRENCY_UNIT = 1;
    private final int THREE_HOURS = 3;
    private final int DAY_HOURS = 24;

    public long getTotalCash() {
        return totalCash;
    }

    public void pay(int amount) {
        totalCash += amount;
    }

    public int calculateCost(int minutes) {
        int duration = minutes / 60;
        int chargeInMoreThanAday = 0;
        int chargeIn3h = 0;
        int chargeInDay = 0;

        if(duration <= THREE_HOURS) {
            for(int i = 0; i < minutes; i++)
                chargeIn3h += ONE_CURRENCY_UNIT * 2;

            pay(chargeIn3h);
            return chargeIn3h;

        }

        if(duration <= DAY_HOURS) {
            chargeInDay = ONE_CURRENCY_UNIT * minutes;
            pay(chargeInDay);
            return chargeInDay;
        }

        if(duration > DAY_HOURS) {
            for (int i = 1; i <= duration; i++) {
                if(i == 24) {
                    chargeInMoreThanAday += 500 * ONE_CURRENCY_UNIT;
                    duration -= i;
                    i = 0;
                }

                if(duration <= THREE_HOURS && duration != 0) {
                    chargeInMoreThanAday += 2 * ONE_CURRENCY_UNIT;
                }

            }
            pay(chargeInMoreThanAday);
            return chargeInMoreThanAday;
        }
        return 0;
    }

}
