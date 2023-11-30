package Employee;

import Account.Account;

public class Officer implements Employee{
    public String eName;

    public Officer(String name)
    {
        this.eName = name;
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
