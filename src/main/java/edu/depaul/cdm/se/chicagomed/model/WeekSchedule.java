package edu.depaul.cdm.se.chicagomed.model;

import lombok.Data;

@Data
public class WeekSchedule {
    public DaySchedule monday;
    public DaySchedule tuesday;
    public DaySchedule wednesday;
    public DaySchedule thursday;
    public DaySchedule friday;

    public static WeekSchedule getDefaultSchedule() {
        WeekSchedule weekSchedule = new WeekSchedule();
        DaySchedule monday = new DaySchedule();
        monday.setDay("Monday");
        monday.setStartTime("8am");
        monday.setEndTime("5pm");
        weekSchedule.setMonday(monday);

        DaySchedule tuesday = new DaySchedule();
        tuesday.setDay("Tuesday");
        tuesday.setStartTime("8am");
        tuesday.setEndTime("5pm");
        weekSchedule.setTuesday(tuesday);

        DaySchedule wednesday = new DaySchedule();
        wednesday.setDay("Wednesday");
        wednesday.setStartTime("8am");
        wednesday.setEndTime("5pm");
        weekSchedule.setWednesday(wednesday);

        DaySchedule thursday = new DaySchedule();
        thursday.setDay("Thursday");
        thursday.setStartTime("8am");
        thursday.setEndTime("5pm");
        weekSchedule.setThursday(thursday);

        DaySchedule friday = new DaySchedule();
        friday.setDay("Friday");
        friday.setStartTime("8am");
        friday.setEndTime("5pm");
        weekSchedule.setFriday(friday);

        return weekSchedule;
    }
}
