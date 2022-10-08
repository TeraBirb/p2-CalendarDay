import java.util.Arrays;
import java.util.Random;

public class Tester {

    public static void main(String[] args) {
        CalendarDay test1 = new CalendarDay(9, 30, 2031);
        System.out.println(test1);

        CalendarDay test2 = new CalendarDay("02/29/2024");
        System.out.println(test2);

        CalendarDay test3 = new CalendarDay(test2);
        System.out.println(test3);

        System.out.println("test1 equals test2: " + test1.equals(test2));
        System.out.println("test2 equals test3: " + test2.equals(test3));

        // test1.setDay(32);        Exception in thread "main" java.lang.Error: Invalid day assignment to month.

        // test2.setMonth(13);      Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 12 out of bounds for length 12

        CalendarDay[] arr = new CalendarDay[10];
        Random rng = new Random();

        System.out.println("\nARRAY TESTING:\n");

        for (int i = 0; i < arr.length; i++) {
            int y = rng.nextInt(1970, 2030);
            int m = rng.nextInt(1, 13);
            int d = 1;              // initialization purposes only

            arr[i] = new CalendarDay(m, d, y);
            // arr[i].initMaxDays();
            // arr[i].setDay(rng.nextInt(1, arr[i].maxDays + 1));
            arr[i].setDay(rng.nextInt(1, arr[i].month.maxDays + 1));
        }

        for ( CalendarDay calDay : arr ) {
            System.out.println(calDay);
        }

        Arrays.sort(arr);
        System.out.println("\nSORT METHOD CALL....\n");

        for ( CalendarDay calDay : arr ) {
            System.out.println(calDay);
        }

    }

}

/* OUTPUT

/Users/user/Library/Java/JavaVirtualMachines/openjdk-17.0.2/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=62049:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/user/IdeaProjects/Project2CalendarDay/out/production/Project2CalendarDay Tester
SEPTEMBER 30, 2031
FEBRUARY 29, 2024
FEBRUARY 29, 2024
test1 equals test2: false
test2 equals test3: true

ARRAY TESTING:

FEBRUARY 9, 2022
FEBRUARY 24, 1994
JANUARY 3, 2017
SEPTEMBER 22, 1992
JUNE 30, 1976
FEBRUARY 23, 1977
SEPTEMBER 11, 1993
MARCH 14, 2011
OCTOBER 9, 2002
DECEMBER 24, 2011

SORT METHOD CALL....

JUNE 30, 1976
FEBRUARY 23, 1977
SEPTEMBER 22, 1992
SEPTEMBER 11, 1993
FEBRUARY 24, 1994
OCTOBER 9, 2002
MARCH 14, 2011
DECEMBER 24, 2011
JANUARY 3, 2017
FEBRUARY 9, 2022

Process finished with exit code 0


 */