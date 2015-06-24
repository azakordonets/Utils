package com.azakordonets.enums;

public enum Day {

    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private final int dayOfTheWeek;

    Day(int dayOfTheWeek){
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public int getDayOfWeek() {
        return this.dayOfTheWeek;
    }
}
