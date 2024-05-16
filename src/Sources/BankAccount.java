/**
 * BankAccount
 *
 * @author @author Andres Arevalo & Dustin & Shamin
 * @version 1.0
 */
public class BankAccount
{
    private final BankClient client;
    private final Date       accountOpened;
    private Date             accountClosed;
    private double           balanceUsd;
    private int              pin;
    private final String     accountNumber;

    /**
     * Constructs a BankAccount object with the given client, account opened date, balance, PIN, and account number.
     *
     * @param client         The bank client associated with the account.
     * @param accountOpened  The date the account was opened.
     * @param balanceUsd     The balance in USD.
     * @param pin            The PIN associated with the account.
     * @param accountNumber  The account number.
     */
    public BankAccount(final BankClient client,
                       final Date accountOpened,
                       final double balanceUsd,
                       int pin,
                       final String accountNumber)
    {
        this.client = client;
        this.accountOpened = accountOpened;
        this.balanceUsd = balanceUsd;
        this.pin = pin;
        this.accountNumber = accountNumber;
    }

    /**
     * Constructs a BankAccount object with the given client, account opened date, account closed date,
     * balance, PIN, and account number.
     *
     * @param client         The bank client associated with the account.
     * @param accountOpened  The date the account was opened.
     * @param accountClosed  The date the account was closed (if applicable).
     * @param balanceUsd     The balance in USD.
     * @param pin            The PIN associated with the account.
     * @param accountNumber  The account number.
     */
    public BankAccount(final BankClient client,
                       final Date accountOpened,
                       final Date accountClosed,
                       final double balanceUsd,
                       int pin,
                       final String accountNumber)
    {
        this.client = client;
        this.accountOpened = accountOpened;
        this.accountClosed = accountClosed;
        this.balanceUsd = balanceUsd;
        this.pin = pin;
        this.accountNumber = accountNumber;
    }

    /**
     * Withdraws funds from the account if the amount does not exceed the balance.
     * Throws an IllegalArgumentException if the withdrawal amount exceeds the balance.
     *
     * @param amountUsd The amount to withdraw in USD.
     */
    public void withdraw(final double amountUsd)
    {
        if(balanceUsd >= amountUsd)
        {
            balanceUsd -= amountUsd;
        }
        else
        {
            throw new IllegalArgumentException(
                    String.format("The amount you want to withdraw %.2f exceed your total balance $%.2f.\n",
                                  amountUsd,
                                  balanceUsd));
        }
    }

    /**
     * Withdraws funds from the account if the amount does not exceed the balance and the provided PIN matches.
     * Throws an IllegalArgumentException if the PIN does not match.
     *
     * @param amountUsd   The amount to withdraw in USD.
     * @param pinToMatch  The PIN to match for withdrawal.
     */
    public void withdraw(final double amountUsd, final int pinToMatch)
    {
        if(pinToMatch == pin)
        {
            withdraw(amountUsd);
        }
        else
        {
            throw new IllegalArgumentException("Invalid pin. Your transaction has been canceled");
        }
    }

    /**
     *
     * @return client that holds the bank Account
     */
    public BankClient getClient()
    {
        return client;
    }

    /**
     *
     * @return balance of the account in USD
     */
    public double getBalanceUsd()
    {
        return balanceUsd;
    }

    /**
     *
     * @return pin of the account
     */
    public int getPin()
    {
        return pin;
    }

    /**
     *
     * @return the account number
     */
    public String getAccountNumber()
    {
        return accountNumber;
    }


    /**
     *
     * @param pin set a new pin for the account.
     */
    public void setPin(final int pin)
    {
        this.pin = pin;
    }
}
