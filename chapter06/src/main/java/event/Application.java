package event;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Application {

    public static void main(String[] args) {
        test1();
        test2();

    }

    private static void test1() {
        RecurringSchedule schedule = new RecurringSchedule("회의", DayOfWeek.WEDNESDAY, LocalTime.of(10, 30), Duration.ofMinutes(30));
        Event meeting = new Event("회의", LocalDateTime.of(2019, 5, 8, 10, 30), Duration.ofMinutes(30));

        System.out.println("meeting.isSatisfied(schedule) = " + meeting.isSatisfied(schedule));
    }

    private static void test2() {
        RecurringSchedule schedule = new RecurringSchedule("회의", DayOfWeek.WEDNESDAY, LocalTime.of(10, 30), Duration.ofMinutes(30));
        Event meeting = new Event("회의", LocalDateTime.of(2019, 5, 9, 10, 30), Duration.ofMinutes(30));

        System.out.println("!meeting.isSatisfied(schedule) = " + !meeting.isSatisfied(schedule));
        System.out.println("meeting.isSatisfied(schedule) = " + meeting.isSatisfied(schedule));
    }


}
