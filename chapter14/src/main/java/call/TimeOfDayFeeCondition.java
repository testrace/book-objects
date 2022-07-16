package call;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class TimeOfDayFeeCondition implements FeeCondition {

    private LocalTime from;
    private LocalTime to;

    public TimeOfDayFeeCondition(LocalTime from, LocalTime to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return call.getInterval().splitByDay().stream()
            .filter(it -> from(it).isBefore(to(it)))
            .map(it -> DateTimeInterval.of(
                LocalDateTime.of(it.getFrom().toLocalDate(), from(it)),
                LocalDateTime.of(it.getTo().toLocalDate(), to(it))))
            .collect(Collectors.toUnmodifiableList());
    }

    private LocalTime from(DateTimeInterval interval) {
        return interval.getFrom().toLocalTime().isBefore(from) ?
            from : interval.getFrom().toLocalTime();
    }

    private LocalTime to(DateTimeInterval interval) {
        return interval.getTo().toLocalTime().isAfter(to) ?
            to : interval.getTo().toLocalTime();
    }


}
