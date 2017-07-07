package main.domain.user.profile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;
import java.util.LinkedHashMap;

/**
 * Created by Joel on 07.07.2017.
 */
@Entity
public class TimeSpan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private LocalTime startTime;
    private LocalTime endTime;


    public TimeSpan() {
    }

    public LocalTime getStartTime() {
        return startTime;
    }

//    public TimeSpan setStartTime(LocalTime startTime) {
//        this.startTime = startTime;
//        return this;
//    }

    public TimeSpan setStartTime(LinkedHashMap startTime) {
        int hour = (int) startTime.get("hour");
        int minute = (int) startTime.get("minute");
        int second = (int) startTime.get("second");
        int nano = (int) startTime.get("nano");
        this.startTime = LocalTime.of(hour, minute, second, nano);
        return this;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public TimeSpan setEndTime(LinkedHashMap startTime) {
        int hour = (int) startTime.get("hour");
        int minute = (int) startTime.get("minute");
        int second = (int) startTime.get("second");
        int nano = (int) startTime.get("nano");
        this.endTime = LocalTime.of(hour, minute, second, nano);
        return this;
    }

//    public TimeSpan setEndTime(LocalTime endTime) {
//        this.endTime = endTime;
//        return this;
//    }

    public boolean contains(LocalTime localTime) {
        return localTime.isAfter(startTime) && localTime.isBefore(endTime);
    }
}
