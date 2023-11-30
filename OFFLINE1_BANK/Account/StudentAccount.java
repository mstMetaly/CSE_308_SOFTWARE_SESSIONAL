package Account;

import Exception.StudentAccountException;
import Exception.NegativeAmountException;
import Exception.LoanException;

public class StudentAccount extends Account{

    public StudentAccount(String name, String accountType, double initialDeposit)
    {
       super(name ,accountType ,initialDeposit);
       setInterestRate(0.05);
    }

    @Override
    public void Deposit(double amount) {
            double balance = getBalance();
            balance += amount;
            setBalance(balance);
    }

    @Override
    public void Withdraw(double amount) throws StudentAccountException,NegativeAmountException {
            if(amount > 10000)
                throw new StudentAccountException(getBalance());

            double balance = getBalance();
            balance -= amount;

            if(balance<0)
                throw new NegativeAmountException();
            setBalance(balance);
    }

    @Override
    public void Request_Loan(double amount) throws LoanException {
            if(amount>1000)
                throw new LoanException();
            super.setRequestLoan(amount);
    }


}
