package Account;

import Exception.SavingsAccountException;
import Exception.NegativeAmountException;
import Exception.LoanException;

public class SavingsAccount extends Account{
    public SavingsAccount(String name, String accountType, double initialDeposit)
    {
       super(name ,accountType, initialDeposit);
       setInterestRate(0.1);
    }

    @Override
    public void Deposit(double amount) {
        double balance = getBalance();
        balance += amount;
        setBalance(balance);
    }

    @Override
    public void Withdraw(double amount) throws SavingsAccountException,NegativeAmountException {
            double  balance = getBalance();
            if(balance - amount < 1000)
                throw  new SavingsAccountException(balance);
            balance -= amount;

            if(balance < 0)
                 throw new NegativeAmountException();

            setBalance(balance);

    }

    @Override
    public void Request_Loan(double amount) throws LoanException {
            if(amount>10000)
                throw new LoanException();
            super.setRequestLoan(amount);
    }

}
