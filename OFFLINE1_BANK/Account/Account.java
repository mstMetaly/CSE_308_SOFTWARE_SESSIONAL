package Account;

import Exception.FixedDepositException;
import Exception.StudentAccountException;
import Exception.SavingsAccountException;
import Exception.MaturityPeriodException;
import Exception.NegativeAmountException;
import Exception.LoanException;


public abstract class Account {
    private String name;

    public String getAccountType() {
        return accountType;
    }

    private String accountType;
    private double balance;
    private int year;

    private static double interestRate;

    private double loanRequest;

    private double loan;

    Account(String name , String accountType ,double balance)
    {
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
        year = 0;
    }

    public abstract void Deposit(double amount) throws FixedDepositException;
    public abstract void Withdraw(double amount) throws NegativeAmountException,StudentAccountException, SavingsAccountException,MaturityPeriodException;
    public abstract void Request_Loan(double amount) throws LoanException;


    public double getBalance()
    {
        return  balance;
    }

    public void setBalance(double amount)
    {
        balance = amount;
    }

    public String getName()
    {
        return  name;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public double getRequestLoan()
    {
        return loanRequest;
    }

    protected void setRequestLoan(double loanRequest)
    {
        this.loanRequest = loanRequest;
    }

    public void Approved_Loan()
    {
        this.loan = loanRequest;
        loanRequest = 0;
    }

    public static void setInterestRate(double rate)
    {
        interestRate = rate;
    };

    public double getProfit()
    {
        double profit = balance * interestRate;
        return profit;
    }

    public void addProfit(double profit)
    {
        balance += profit;
    }

    public double getLoan()
    {
        return loan;
    }

    public void setLoan(double amount)
    {
        this.loan =  amount;
    }

}
