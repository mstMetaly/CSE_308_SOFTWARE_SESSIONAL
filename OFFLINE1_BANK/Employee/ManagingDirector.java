package Employee;

import Account.Account;

public class ManagingDirector implements Employee{
    private String eName;

    public ManagingDirector(String name)
    {
        this.eName  = name;

    }
    @Override
    public double Lookup(Account account) {
        return account.getBalance();
    }

    public String getName()
    {
        return eName;
    }
}
