package movie;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Screening {

    private DayOfWeek dayOfWeek;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
