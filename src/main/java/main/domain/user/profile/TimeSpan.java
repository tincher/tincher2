package main.domain.user.profile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Joel on 29.06.2017.
 */
@Entity
public class TimeSpan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date startTime;
    private Date endTime;

    public TimeSpan() {
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
