/**
 * Date of Bank
 *
 * @author Andres Arevalo & Dustin & Shamin
 * @version 1.0
 */
public class Date
{


    final int day;
    final int month;
    final int year;

    // CONSTANTS - DAYS OF THE WEEK
    private static final int SATURDAY = 0;
    private static final int SUNDAY = 1;
    private static final int MONDAY = 2;
    private static final int TUESDAY = 3;
    private static final int WEDNESDAY = 4;
    private static final int THURSDAY = 5;
    private static final int FRIDAY = 6;

    // CONSTANTS - MONTHS
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;
    private static final int DEFAULT_MONTH_CODE = -1;

    // CONSTANTS - YEARS
    private static final int INITIAL_YEAR = 1;
    public static final int CURRENT_YEAR = 2024;

    private static final int EXACT_DIVISION = 0;

    // CONSTANTS - MONTHS CODES
    private static final int MONTH_CODE_JAN_OCT = 1;
    private static final int MONTH_CODE_FEB_MARCH_NOV = 4;
    private static final int MONTH_CODE_APRIL_JULY = 0;
    private static final int MONTH_CODE_MAY = 2;
    private static final int MONTH_CODE_JUNE = 5;
    private static final int MONTH_CODE_AUGUST = 3;
    private static final int MONTH_CODE_SEP_DEC = 6;

    // CONSTANTS - CENTURIES
    private static final int START_SIXTEEN_CENTURY = 1600;
    private static final int END_SIXTEEN_CENTURY = 1699;
    private static final int START_SEVENTEEN_CENTURY = 1700;
    private static final int END_SEVENTEEN_CENTURY = 1799;
    private static final int START_EIGHTEEN_CENTURY = 1800;
    private static final int END_EIGHTEEN_CENTURY = 1899;
    private static final int START_TWENTIETH_CENTURY = 2000;
    private static final int END_TWENTIETH_CENTURY = 2099;
    private static final int START_TWENTY_ONE_CENTURY = 2100;
    private static final int END_TWENTY_ONE_CENTURY = 2199;

    public Date(final int day,
                final int month,
                final int year)
    {
        if(!isValidYear())
        {
            throw new IllegalArgumentException("bad year!");
        }

        if(!isValidMonth())
        {
            throw new IllegalArgumentException("bad month");
        }

        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     *
     * @return day of the year in format DD
     */
    public int getDay()
    {
        return day;
    }

    /**
     *
     * @return month of the year in format MM
     */
    public int getMonth()
    {
        return month;
    }

    /**
     *
     * @return year in format YYYY
     */
    public int getYear()
    {
        return year;
    }

    /**
     *
     * @return date in format YYYY-MM-DD
     */
     public String getYYYYMMDD()
     {
         return String.format("%s-%s-%s", year, month, day);
     }

    private boolean isValidMonth()
    {
        return month >= JANUARY && month <= DECEMBER;
    }

    private boolean isValidYear()
    {
        return year >= INITIAL_YEAR && year <= CURRENT_YEAR;
    }

    /**
     * Calculates and returns the name of the day of the week for a given date (month, day, year).
     * @return The name of the day of the week as a String.
     */
    public String getDayOfWeek()
    {
        final int lastTwoDigitsYear;
        final int step1;
        final int step2;
        final int step3;
        final int step4;
        int       step5;
        final int step6;

        lastTwoDigitsYear = year % 100;
        step1 = lastTwoDigitsYear / 12;
        step2 = lastTwoDigitsYear % 12;
        step3 = step2 / 4;
        step4 = day;
        step5 = getMonthCode(month);

        if((month == JANUARY || month == FEBRUARY) && isLeapYear(year))
        {
            step5 += 6;
        }

        step5 += specialOffsetCenturies(year);

        step6 = (step1 + step2 + step3 + step4 + step5) % 7;

        return dayOfWeek(step6);
    }

    /**
     * Checks if the given year is a leap year.
     * @param year The year to check.
     * @return True if it's a leap year, False otherwise.
     */
    public boolean isLeapYear(int year)
    {
        return (year % 4 == EXACT_DIVISION && year % 100 != EXACT_DIVISION) || year % 400 == EXACT_DIVISION;
    }

    /**
     * Retrieves the month code for the given month.
     * @param month The month for which to get the code.
     * @return The month code as an integer.
     */
    public static int getMonthCode(int month)
    {
        return switch(month)
        {
            case JANUARY, OCTOBER -> MONTH_CODE_JAN_OCT;
            case FEBRUARY, MARCH, NOVEMBER -> MONTH_CODE_FEB_MARCH_NOV;
            case APRIL, JULY -> MONTH_CODE_APRIL_JULY;
            case MAY -> MONTH_CODE_MAY;
            case JUNE -> MONTH_CODE_JUNE;
            case AUGUST -> MONTH_CODE_AUGUST;
            case SEPTEMBER, DECEMBER -> MONTH_CODE_SEP_DEC;
            default -> DEFAULT_MONTH_CODE; // Invalid month
        };
    }

    /**
     * Applies special offsets for centuries based on the given year.
     * @param year The year for which to calculate the offset.
     * @return The special offset as an integer.
     */
    public static int specialOffsetCenturies(int year) {
        if(year >= START_SIXTEEN_CENTURY && year <= END_SIXTEEN_CENTURY)
        {
            return 6;
        }
        else if(year >= START_SEVENTEEN_CENTURY && year <= END_SEVENTEEN_CENTURY)
        {
            return 4;
        }
        else if(year >= START_EIGHTEEN_CENTURY && year <= END_EIGHTEEN_CENTURY)
        {
            return 2;
        }
        else if(year >= START_TWENTIETH_CENTURY && year <= END_TWENTIETH_CENTURY)
        {
            return 6;
        }
        else if(year >= START_TWENTY_ONE_CENTURY && year <= END_TWENTY_ONE_CENTURY)
        {
            return 4;
        }
        else // any other century
        {
            return 0;
        }
    }

    /**
     * Converts the step number to the corresponding day of the week.
     * @param step6 The step number calculated in the day of the week algorithm.
     * @return The name of the day of the week as a String.
     */
    public static String dayOfWeek(int step6) {
        return switch(step6)
        {
            case SATURDAY -> "Saturday";
            case SUNDAY -> "Sunday";
            case MONDAY -> "Monday";
            case TUESDAY -> "Tuesday";
            case WEDNESDAY -> "Wednesday";
            case THURSDAY -> "Thursday";
            case FRIDAY -> "Friday";
            default -> "Invalid day";
        };
    }

    /**
     *
     * @return the full date in the format dayWeek, FullMonth dd, yyyy!
     * (e.g "friday, March 14, 1879")
     */
    public String getFullDate()
    {
        final String fullDate;

        fullDate = String.format("%s, %s %s, %s",
                                 getDayOfWeek(),
                                 getFullMonth(),
                                 getDay(),
                                 getYear());

        return fullDate;
    }

    /**
     * Get the month in format MM and return it as a String
     * @return Full month as a string (e.g. 01 -> January)
     */
    private String getFullMonth()
    {
        return switch(getMonth())
        {
            case JANUARY -> "January";
            case FEBRUARY -> "February";
            case MARCH -> "March";
            case APRIL -> "April";
            case MAY -> "May";
            case JUNE -> "June";
            case JULY -> "July";
            case AUGUST -> "August";
            case SEPTEMBER -> "September";
            case OCTOBER -> "October";
            case NOVEMBER -> "November";
            case DECEMBER -> "December";
            default -> "Invalid day";
        };
    }


    private boolean isValidDay()
    {
        return true;
    }
}
