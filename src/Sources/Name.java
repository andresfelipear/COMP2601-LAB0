/**
 * Name of Bank
 *
 * @author Andres Arevalo & Dustin & Shamin
 * @version 1.0
 */
public class Name
{
    private static final int    INITIAL = 0;
    private static final int    MAX_NAME_LENGTH =  45;
    private static final String INVALID_NAME = "admin";
    private static final char   CHARACTER_TO_CAPITALIZE_NEXT = ' ';
    private static final int    LOOP_START_INDEX = 1;
    private static final int    FIRST_INITIAL = 0;

    private final String first;
    private final String last;

    /**
     * Initialize the name class. Check if is valid first and last name.
     * @param first first name.
     * @param last last name.
     */
    public Name(final String first,
                final String last)
    {
        if(isInValidFirstLastName(first))
        {
            throw new IllegalArgumentException("bad first name!");
        }

        if(isInValidFirstLastName(last))
        {
            throw new IllegalArgumentException("bad last name!");
        }

        this.first = first;
        this.last = last;
    }

    /**
     * Checks if the given string is invalid. A string is invalid if:
     * It's null, it's empty, it's equals or bigger than 45 characters or contain the word "admin"
     * @param name string to be validated.
     * @return true if is invalid name false if not.
     */
    private boolean isInValidFirstLastName(final String name)
    {
        return name == null || name.isBlank() || name.length() >= MAX_NAME_LENGTH ||
                name.contains(INVALID_NAME);
    }

    /**
     *
     * @return initials concatenated (e.g. name of "tigER wooDS" would return "T.W.").
     */
    public String getInitials()
    {
        return Character.toUpperCase(first.charAt(INITIAL)) + "." + Character.toUpperCase(last.charAt(INITIAL)) + ".";
    }

    /**
     *
     * @return full name capitalized (e.g. name of "tigER wooDS" would return "Tiger Woods").
     */
    public String getFullName()
    {
        return getStringCapitalized(first + " " + last);
    }

    /**
     *
     * @return first name
     */
    public String getFirst()
    {
        return first;
    }

    /**
     *
     * @return last name
     */
    public String getLast()
    {
        return last;
    }

    /**
     * Capitalize the given string.
     * @param str the string to be capitalized.
     * @return String capitalized.
     */
    public static String getStringCapitalized(final String str)
    {
        final char[] strArrayOfChars;
        final String strCapitalized;
        boolean      capitalize;

        capitalize = false;

        strArrayOfChars = str.trim().toLowerCase().toCharArray();
        strArrayOfChars[FIRST_INITIAL] = Character.toUpperCase(strArrayOfChars[FIRST_INITIAL]);

        for(int i = LOOP_START_INDEX; i < strArrayOfChars.length ; i++)
        {
            if(capitalize)
            {
                strArrayOfChars[i] = Character.toUpperCase(strArrayOfChars[i]);
                capitalize = false;
            }
            if(strArrayOfChars[i] == CHARACTER_TO_CAPITALIZE_NEXT)
            {
                capitalize = true;
            }
        }

        strCapitalized = new String(strArrayOfChars);

        return strCapitalized;
    }
}
