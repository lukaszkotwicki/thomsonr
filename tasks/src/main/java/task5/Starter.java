package task5;

import java.time.LocalDate;
import java.util.List;

public class Starter {
    public static void main (String args[]) {
        List<LocalDate> weekdays = Weekdays.generateWeekdays(LocalDate.of(2017, 7, 1), LocalDate.of(2017, 7, 30));
        System.out.println(weekdays);
    }
}
