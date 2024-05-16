/**
 * BankClient class represents a client of a bank, extending the Person class.
 *
 * @author Andres Arevalo & Dustin & Shamin
 * @version 1.0
 */
public class BankClient extends Person
{
    final Date   dateJoinedBank;
    final String clientID;

    private static final int LENGTH_CLIENT_ID = 5;

    /**
     * Constructs a BankClient object with the given name, birthdate, date joined the bank, and client ID.
     * Throws an IllegalArgumentException if the client ID is not exactly 5 characters long.
     *
     * @param name           The name of the client.
     * @param birthDate      The birthdate of the client.
     * @param dateJoinedBank The date the client joined the bank.
     * @param clientID       The client ID (5 characters).
     */
    public BankClient(final Name name,
                      final Date birthDate,
                      final Date dateJoinedBank,
                      final String clientID)
    {
        super(name,
              birthDate);

        if(!isValidClientID())
        {
            throw new IllegalArgumentException("Bad ClientId! It should have exactly 5 characters.");
        }

        this.dateJoinedBank = dateJoinedBank;
        this.clientID = clientID;
    }

    /**
     * Checks if the client ID is valid (exactly 5 characters long).
     *
     * @return True if the client ID is valid, false otherwise.
     */
    private boolean isValidClientID()
    {
        return clientID.length() == LENGTH_CLIENT_ID;
    }

    public BankClient(final Name name,
                      final Date birthDate,
                      final Date deathDate,
                      final Date dateJoinedBank,
                      final String clientID)
    {
        super(name,
              birthDate,
              deathDate);

        if(!isValidClientID())
        {
            throw new IllegalArgumentException("Bad ClientId! It should have exactly 5 characters.");
        }

        this.dateJoinedBank = dateJoinedBank;
        this.clientID = clientID;
    }

    /**
     * Retrieves the details of the bank client including name, client ID, alive status, and date joined the bank.
     *
     * @return The details of the bank client as a formatted string.
     */
    @Override
    public String getDetails()
    {
        String personDetails;

        personDetails = String.format("%s client #%s %s joined the bank on %s",
                                      name.getFullName(),
                                      clientID,
                                      getAliveStatusForPrintDetails(),
                                      dateJoinedBank.getFullDate());

        return personDetails;
    }

    /**
     * Retrieves the alive status of the person for printing details.
     * If the person is alive, returns "(alive)". If the person is deceased, returns "(not alive)".
     *
     * @return The alive status as a formatted string.
     */
    @Override
    public String getAliveStatusForPrintDetails()
    {
        if(isAlive())
        {
            return "(alive)";
        }
        else
        {
            return "(not alive)";
        }
    }
}
