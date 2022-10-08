public class CalendarDay implements Comparable<CalendarDay>{
    Month month;
    int day;
    int year;
//    int maxDays;
    Month[] monthArr = Month.values();

    // void initMaxDays() {
        // if (this.month == Month.JANUARY || this.month == Month.MARCH || this.month == Month.MAY ||
            // this.month == Month.JULY || this.month == Month.AUGUST || this.month == Month.OCTOBER ||
            // this.month == Month.DECEMBER) {
            // this.maxDays = 31;
            // } else if (this.month == Month.FEBRUARY) {
                // if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
                    // this.maxDays = 29;
            // } else {
                // this.maxDays = 28;
            // }
            // } else {
            //  this.maxDays = 30;
          // }
      // }

    public CalendarDay(String str){     // "MM/DD/YYYY"

        this.year = Integer.parseInt(str.substring(6));
        this.month = monthArr[Integer.parseInt(str.substring(0,2)) - 1];
        month.year = year;

        // initMaxDays();

        this.day = Integer.parseInt(str.substring(3,5));
        this.month.day = this.day;
        this.month.verifyDays();

        // int dayTemp = Integer.parseInt(str.substring(3,5));

        // if (dayTemp > 0 && dayTemp <= maxDays) {
        // this.day = dayTemp;
        // } else {
        // throw new java.lang.Error("Invalid day assignment to month.");
        // }

    }

    public CalendarDay(int m, int d, int y) {

        this.year = y;
        this.month = monthArr[m - 1];
        month.year = year;

        this.day = d;
        this.month.day = this.day;
        this.month.verifyDays();
        // initMaxDays();

        // if (d > 0 && d <= maxDays) {
        // this.day = d;
        // } else {
        // throw new java.lang.Error("Invalid day assignment to month.");
        // }
    }

    public CalendarDay(CalendarDay other) { // redundant to copy maxDays and monthArr

        this.setYear(other.getYear());
        this.setMonth(other.getMonth().abbreviation);
        this.setDay(other.getDay());

    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = monthArr[month - 1];
    }

    public void setDay(int day) {
        this.day = day;
        this.month.verifyDays();
    }

    public int getYear() {
        return this.year;
    }

    public Month getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public boolean equals(CalendarDay other) {
        return (this.day == other.day) && (this.month == other.month) && (this.year == other.year);
    }

    public int compareTo(CalendarDay other) {
        if (this.getYear() == other.getYear()) {
            if (this.getMonth().abbreviation == other.getMonth().abbreviation) {
                return this.getDay() - other.getDay();
            }
            return this.getMonth().abbreviation - other.getMonth().abbreviation;
        }
        return this.getYear() - other.getYear();
    }

    public String toString() {
        return this.month + " " + this.day + ", " + this.year;
    }


}

/*
9-16-22 revision after first submission

removed void initMaxDays() from CalendarDay class
removed associated instance variable maxDays from CalendarDay class
added void verifyDay() to Month enum
added instance variable maxDays to Month enum

all removals are commented out
 */