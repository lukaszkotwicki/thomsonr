package task5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Weekdays {

    public static List<LocalDate> generateWeekdays (LocalDate start, LocalDate end)
    {
        List<LocalDate> weekdays = new ArrayList<> ();
        for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1))
        {
            if (!(date.getDayOfWeek().equals(DayOfWeek.SATURDAY) ||
                    date.getDayOfWeek().equals(DayOfWeek.SUNDAY)))
            {
                weekdays.add(date);
            }
        }
        return weekdays;
    }
}