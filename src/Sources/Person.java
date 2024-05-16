/**
 * Person of Bank
 *
 * @author Andres Arevalo & Dustin & Shamin
 * @version 1.0
 */
public class Person
{
    final Name name;
    final Date   birthDate;
    Date         deathDate;

    /**
     * Constructs a Person object with the given name and birthdate.
     *
     * @param name      The name of the person.
     * @param birthDate The birthdate of the person.
     */
    public Person(final Name name,
                  final Date birthDate)
    {
        this.name = name;
        this.birthDate = birthDate;
    }

    /**
     * Constructs a Person object with the given name, birthdate, and death date.
     *
     * @param name      The name of the person.
     * @param birthDate The birthdate of the person.
     * @param deathDate The death date of the person.
     */
    public Person(final Name name,
                  final Date birthDate,
                  final Date deathDate)
    {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    /**
     * Checks if the person is alive based on the presence of a death date.
     *
     * @return True if the person is alive (death date is null), false otherwise.
     */
    public boolean isAlive()
    {
        return deathDate == null;
    }

    /**
     * Retrieves the alive status of the person for printing details.
     * If the person is alive, returns "(alive)". If the person is deceased, returns "died" followed by the death date.
     *
     * @return The alive status as a formatted string.
     */
    public String getAliveStatusForPrintDetails()
    {
        if(isAlive())
        {
            return "(alive)";
        }
        else
        {
            return String.format("died %s", deathDate.getFullDate());
        }
    }

    /**
     * Retrieves the full details of the person including name, alive status, and birthdate.
     *
     * @return The details of the person as a formatted string.
     */
    public String getDetails()
    {
        String personDetails;

        personDetails = String.format("%s %s was born on %s!",
                                      name.getFullName(),
                                      getAliveStatusForPrintDetails(),
                                      birthDate.getFullDate());

        return personDetails;
    }
}
