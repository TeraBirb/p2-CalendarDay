public enum Month {
    JANUARY(1), // DO ABBREVIATION, see if you can shorten constructor, if not, whatever
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    int abbreviation;
    int maxDays;
    int year;
    int day;

    Month(int a) {
        this.abbreviation = a;
    }

    public int getAbbreviation() {
        return this.abbreviation;
    }

    void verifyDays() {
        if (this.abbreviation == 1 || this.abbreviation == 3 || this.abbreviation == 5 ||
                this.abbreviation == 6 || this.abbreviation == 9 || this.abbreviation == 10 ||
                this.abbreviation == 12) {
            this.maxDays = 31;
        } else if (this.abbreviation == 2) {
            if (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0)) {
                this.maxDays = 29;
            } else {
                this.maxDays = 28;
            }
        } else {
            this.maxDays = 30;
        }

        if (day <= 0 || day > maxDays) {
            throw new java.lang.Error("Invalid day assignment to month.");
        }

    }

}


// READ UP ON ENUMS

// Create validate method to check if day is valid based on month and year

// Create minDay and maxDay