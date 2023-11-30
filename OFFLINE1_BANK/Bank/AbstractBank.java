package Bank;

import Account.Account;
import Employee.Employee;

import Exception.FixedDepositException;
import Exception.SameNameException;
import Exception.StudentAccountException;
import Exception.NegativeAmountException;
import Exception.SavingsAccountException;
import Exception.MaturityPeriodException;
import Exception.LoanException;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBank {
    private double internalFund;
    private List<Account> accountList = new ArrayList<Account>();

    public List<LoanAccount> loanAccountList = new ArrayList<LoanAccount>();
    public List<Employee>employeeList = new ArrayList<Employee>();

    public List<Employee>managerList = new ArrayList<Employee>();
    public List<Employee>cashierList = new ArrayList<Employee>();
    public List<Employee>officerrList = new ArrayList<Employee>();


    AbstractBank(double internalFund)
    {
        this.internalFund = internalFund;
    }

    public abstract Account Create(String name, String accountType ,double initialDeposit) throws FixedDepositException, SameNameException;
    public abstract void Deposit(Account account, double amount) throws FixedDepositException;
    public abstract void Withdraw(Account account, double amount) throws NegativeAmountException,StudentAccountException, SavingsAccountException, MaturityPeriodException;
    public abstract void RequestLoan(Account account,double amount) throws LoanException;

    abstract void addEmployees();

    protected double getInternalFund()
    {
        return internalFund;
    };

    protected void setInternalFund(double amount)
    {
        internalFund = amount;
    }

    //add account to accountList
    public void addAccount(Account account)
    {
        accountList.add(account);
    }

    //is there exist an account with the same name
    public boolean isExistAccount(String name)
    {
        for(Account account : accountList)
        {
            if(account.getName().equals(name))
                return true;
        }

        return false;
    }

    //Get an account with the name
    public Account getAccount(String name)
    {
        Account account = null;
        for(Account ac : accountList)
        {
            if(ac.getName().equals(name))
                account = ac;
        }
        return account;

    }

    //Update an account
    public void updateAccount(Account oldAccount, Account modAccount)
    {
        int index = accountList.indexOf(oldAccount);
        accountList.set(index , modAccount);
    }


    //Increment year
    public void incrementYear()
    {
        for(Account account : accountList)
        {
            int year = account.getYear();
            year+=1 ;
            account.setYear(year);
        }
    }


    //Calculate profit on deposit
    public void calculateProfit()
    {
        for(Account account : accountList)
        {
            double profit=account.getProfit();
            account.addProfit(profit);
            double internalFund = getInternalFund();
            internalFund -= profit;
            setInternalFund(internalFund);
        }
    }


    //Yearly charge for every account
    public void ChargeAccount()
    {
        for(Account account : accountList)
        {
            if(account.getAccountType().equals("Student"))
            {
            }
            else{
                double bal = account.getBalance();
                bal -= 500;
                if(bal <= 0)
                {
                    double loan = account.getLoan();
                    loan+= (-bal);
                    account.setLoan(loan);
                    account.setBalance(0);
                }
                account.setBalance(bal);
            }
        }
    }



}
