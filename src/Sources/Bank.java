import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Bank class represents a bank with various functionalities like adding and removing accounts,
 * retrieving information about accounts and the CEO, and finding accounts based on client ID or maximum balance.
 * @author user
 * @version 1.0
 */
public class Bank
{
    private Person CEO;
    private final List<BankAccount> accounts;

    /**
     * Constructs a Bank object with the given CEO.
     *
     * @param CEO The CEO of the bank.
     */
    public Bank(final Person CEO)
    {
        this.CEO = CEO;
        accounts = new ArrayList<>();
    }

    /**
     * Adds a new bank account to the bank.
     *
     * @param newAccount The BankAccount object to add.
     * @throws IllegalArgumentException If an account with the same account number already exists.
     */
    public void addAccount(final BankAccount newAccount)
    {
        for(final BankAccount account : accounts)
        {
            if(account.getAccountNumber().equalsIgnoreCase(newAccount.getAccountNumber()))
            {
                throw new IllegalArgumentException(
                        String.format("The account with the number %s already exists!.", account.getAccountNumber()));
            }
        }

        accounts.add(newAccount);
    }

    /**
     * Removes a bank account from the bank based on its account number.
     *
     * @param accountNumber The account number of the account to remove.
     */
    public void removeAccount(final String accountNumber)
    {
        final Iterator<BankAccount> it;
        String currentAccountNumber;

        it = accounts.iterator();

        while(it.hasNext())
        {
            currentAccountNumber = it.next().getAccountNumber();

            if(accountNumber.equalsIgnoreCase(currentAccountNumber))
            {
                it.remove();
            }
        }
    }

    /**
     * Retrieves the CEO of the bank.
     *
     * @return The CEO of the bank.
     */
    public Person getCEO()
    {
        return CEO;
    }

    /**
     * Sets the CEO of the bank.
     *
     * @param CEO The new CEO of the bank.
     */
    public void setCEO(final Person CEO)
    {
        this.CEO = CEO;
    }

    /**
     * Retrieves a list of all bank accounts in the bank.
     *
     * @return A list of BankAccount objects representing all accounts in the bank.
     */
    public List<BankAccount> getAllAccounts()
    {
        return accounts;
    }

    /**
     * Retrieves the account with the maximum balance.
     *
     * @return The BankAccount object with the maximum balance.
     */
    public BankAccount getMaxAccount()
    {
        double maxBalance;

        BankAccount maxAccount;
        BankAccount currentAccount;

        maxBalance = accounts.getFirst().getBalanceUsd();
        maxAccount = accounts.getFirst();

        for(int i=1; i < accounts.size(); i++)
        {
            currentAccount = accounts.get(i);

            if(currentAccount.getBalanceUsd() > maxBalance)
            {
                maxBalance = currentAccount.getBalanceUsd();
                maxAccount = currentAccount;
            }
        }

        return maxAccount;
    }

    /**
     * Retrieves the account associated with the given client ID.
     *
     * @param clientID The client ID to search for.
     * @return The BankAccount object associated with the client ID, or null if not found.
     */
    public BankAccount getAccountFor(String clientID)
    {
        for(final BankAccount account : accounts)
        {
            if(account.getClient().clientID.equalsIgnoreCase(clientID))
            {
                return account;
            }
        }

        return null;
    }
}
