package movie;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition {

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTIme;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTIme) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTIme = endTIme;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
            startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 &&
            endTIme.compareTo(screening.getStartTime().toLocalTime()) >= 0;
    }
}
