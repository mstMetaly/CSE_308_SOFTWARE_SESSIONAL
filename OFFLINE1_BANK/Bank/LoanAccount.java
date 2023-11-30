package Bank;

import Account.Account;

public class LoanAccount {
    private double loan;
    Account account;

    public LoanAccount(double loan, Account account)
    {
        this.loan = loan;
        this.account = account;
    }

    public double getLoan()
    {
        return loan;
    }
    public void setLoan(double loan)
    {
        this.loan = loan;
    }

    public Account getAccount()
    {
        return account;
    }
}
