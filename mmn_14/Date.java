
/**
 * This class represents a Date object
 *
 * @author yehonatanke
 * @version 2023
 */
public class Date {
    private int _day;
    private int _month;
    private int _year;

    /**
     * Construct a date.
     * If one of the parameters is not valid, then it should be 1/1/2000.
     *
     * @param day   The day of the date
     * @param month The month of the date
     * @param year  The year of the date
     */
    public Date (int day, int month, int year) {
        _day = 1;
        _month = 1;
        _year = 2000;

        if (isValid(day, month, year)) {
            _day = day;
            _month = month;
            _year = year;
        }
    }

    /**
     * Copy constructor for Date.
     * construct a date with the same parameters as other date.
     *
     * @param other The date object from which to construct the new date.
     */
    public Date (Date other) {
        _day = other._day;
        _month = other._month;
        _year = other._year;
    }

    /**
     * Check if given year/month/day is valid
     *
     * @param year  The year of a given date
     * @param month The month of a given date
     * @param day   The day of a given date
     * @return true if it is a valid date
     */
    private static boolean isValid (int day, int month, int year) {
        if ((year < 0) || (year > 9999)) return false;
        if ((month < 1) || (month > 12)) return false;
        if ((day < 1) || (day > 31)) return false;
        switch (month) {
            case 1:
                return true;
            case 2:
                return day < 29;
            case 3:
                return true;
            case 4:
                return day < 31;
            case 5:
                return true;
            case 6:
                return day < 31;
            case 7:
                return true;
            case 8:
                return true;
            case 9:
                return day < 31;
            case 10:
                return true;
            case 11:
                return day < 31;
            default:
                return true;
        }
    }

    /**
     * Returns the day of the date.
     *
     * @return The day of the date.
     */
    public int getDay () {
        return _day;
    }

    /**
     * Returns the month of the date.
     *
     * @return The month of the date.
     */
    public int getMonth () {
        return _month;
    }

    /**
     * Returns the year of the date.
     *
     * @return The year of the date.
     */
    public int getYear () {
        return _year;
    }

    /**
     * Sets the day of the date.
     * If the date is not valid, then the day does not change.
     *
     * @param dayToSet The new day of the date.
     */
    public void setDay (int dayToSet) {
        if (isValid(dayToSet, _month, _year)) {
            _day = dayToSet;
        }
    }

    /**
     * Sets the month of the date.
     * If the date is not valid, then the month does not change.
     *
     * @param monthToSet The new month of the date.
     */
    public void setMonth (int monthToSet) {
        if (isValid(_day, monthToSet, _year)) {
            _month = monthToSet;
        }
    }

    /**
     * Sets the year of the date.
     * If the date is not valid, then the year does not change.
     *
     * @param yearToSet The new year of the date.
     */
    public void setYear (int yearToSet) {
        if (isValid(_day, _month, yearToSet)) {
            _year = yearToSet;
        }
    }

    /**
     * Check if this date equals other date.
     *
     * @param other The date to be compared with this date
     * @return true if this date equals other date
     */
    public boolean equals (Date other) {
        return (other._day == _day && other._month == _month && other._year == _year);
    }

    /**
     * Check if this date is befor other date.
     *
     * @param other The date to be compared with this date
     * @return true if this date is befor other date
     */
    public boolean before (Date other) {
        if (_year < other._year) return true;
        if (_month < other._month) return true;
        if (_day < other._day) return true;
        if (other.equals(this)) return false;
        return false;
    }

    /**
     * Check if this date is after other date.
     *
     * @param other The date to be compared with this date
     * @return true if this date is after other date
     */
    public boolean after (Date other) {
        return other.before(this);
    }

    /**
     * Computes the day number since the beginning of the Christian counting of years for a given date.
     *
     * @param day   The day of the date
     * @param month The month of the date
     * @param year  The year of the date
     * @return the number of days since the beginning of the Christian counting of years for the given date
     */
    private int calculateDate (int day, int month, int year) {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year / 4 - year / 100 + year / 400 + ((month + 1) * 306) / 10 + (day - 62);
    }

    /**
     * Calculates the difference in days between this date and other date.
     *
     * @param other The date to compare with this date
     * @return the difference in days between the dates
     */
    public int difference (Date other) {
        return Math.abs(calculateDate(_day, _month, _year) - calculateDate(other._day, other._month, other._year));
    }

    /**
     * Returns a string representation of this date in dd/mm/yyyy format.
     * If the day or month has one digit, 0 will be added to the left of the digit.
     *
     * @return String representation of this date.
     */
    public String toString () {
        String oneDigitDay = "";
        String oneDigitMonth = "";

        if (_day <= 9) oneDigitDay = "0";
        if (_month <= 9) oneDigitMonth = "0";

        return oneDigitDay + _day + "/" + oneDigitMonth + _month + "/" + _year;
    }

    /**
     * Calculate the date of tomorrow.
     *
     * @return the date of tomorrow
     */
    public Date tomorrow () {
        if (_month == 2) {      //check if February
            if (_day < 28) {
                return new Date(_day + 1, _month, _year);
            }
            return new Date(1, 3, _year);
        }

        if (((_month < 9) && (_month % 2 == 1)) || _month == 8 || _month == 10 || _month == 12) {   //check month type
            if (_day < 31) {
                return new Date(_day + 1, _month, _year);
            }
            if (_month == 12) {
                return new Date(1, 1, _year + 1);
            }
            return new Date(1, _month + 1, _year);
        }

        if (_day < 30) {
            return new Date(_day + 1, _month, _year);
        }
        return new Date(1, _month + 1, _year);

    }
}

