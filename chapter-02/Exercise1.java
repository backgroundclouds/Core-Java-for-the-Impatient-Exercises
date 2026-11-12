//Exercise 1. Change the calendar printing program so it starts the week on Sunday. Also make it print a newline at the end (but only one).

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Exercise1 {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now().withDayOfMonth(1);
        int month;
        if (args.length >= 2) {
            month = Integer.parseInt(args[0]);
            int year = Integer.parseInt(args[1]);
            date = LocalDate.of(year, month, 1);
        } else {
            month = date.getMonthValue();
        }

        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        DayOfWeek weekday = date.getDayOfWeek();

        int blocks = weekday.plus(1).getValue();
        for (int i = 1; i < blocks; i++) // Write the first decimal line. Value tells us far from right margin first decimal "1" is placed. 0 blocks, 1 blocks, 2 blocks, 3....
            System.out.print("    ");
        //write the remainder decimal lines
        while (date.getMonthValue() == month) {
            System.out.printf("%4d", date.getDayOfMonth());
            date = date.plusDays(1); //increment date object x 1 day
        //reset the typewriter once we reach  (our first day of the week)
            if (date.getDayOfWeek().getValue() == 7)
                System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 1) 
            System.out.println();
 
        System.out.println(); //extra line
    }

}
