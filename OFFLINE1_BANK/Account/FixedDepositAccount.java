package Account;

import Exception.FixedDepositException;
import Exception.MaturityPeriodException;
import Exception.NegativeAmountException;
import Exception.LoanException;

public class FixedDepositAccount extends Account{
    public FixedDepositAccount(String name, String accountType, double initialDeposit)
    {
        super(name,accountType,initialDeposit);
        setInterestRate(.15);

    }

    @Override
    public void Deposit(double amount) throws FixedDepositException {
        if(amount < 50000)
            throw new FixedDepositException();

        double balance = getBalance();
        balance += amount;
        setBalance(balance);
    }

    @Override
    public void Withdraw(double amount) throws MaturityPeriodException,NegativeAmountException{
            if(getYear() < 1)
                throw new MaturityPeriodException(getYear());
            double  balance = getBalance();
            balance -= amount;

            if(balance < 0)
                throw new NegativeAmountException();

            setBalance(balance);
    }

    @Override
    public void Request_Loan(double amount) throws LoanException {
            if(amount>100000)
                throw new LoanException();
            super.setRequestLoan(amount);
    }

    @Override
    public int getYear() {
        return super.getYear();
    }

}
