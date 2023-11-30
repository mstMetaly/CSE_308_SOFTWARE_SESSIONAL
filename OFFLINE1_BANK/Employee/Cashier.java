package Employee;

import Account.Account;

public class Cashier implements Employee{
    public String eName;

    public Cashier(String  name)
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
