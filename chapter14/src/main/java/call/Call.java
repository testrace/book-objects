package call;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Call {

    private DateTimeInterval interval;

    public Call(DateTimeInterval interval) {
        this.interval = interval;
    }

    public List<DateTimeInterval> splitByDay() {
        return interval.splitByDay();
    }

    public Duration getDuration() {
        return interval.duration();
    }

    public LocalDateTime getFrom() {
        return interval.getFrom();
    }

    public LocalDateTime getTo() {
        return interval.getTo();
    }

    public DateTimeInterval getInterval() {
        return interval;
    }
}
