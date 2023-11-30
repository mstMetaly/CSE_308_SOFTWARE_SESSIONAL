package Bank;

import Account.Account;
import Account.SavingsAccount;
import  Account.StudentAccount;
import Account.FixedDepositAccount;

import Employee.Employee;
import Employee.ManagingDirector;
import Employee.Officer;
import Employee.Cashier;

import Exception.FixedDepositException;
import Exception.SameNameException;
import Exception.StudentAccountException;
import Exception.NegativeAmountException;
import Exception.SavingsAccountException;
import Exception.MaturityPeriodException;
import Exception.LoanException;



public class Bank extends AbstractBank{

    public Bank(double internalFund)
    {
        super(internalFund);
        addEmployees();
    }

    @Override
    public void addEmployees() {
        createManagingDirector();
        createOfficer();
        createCashier();

        for(Employee employee : managerList)
            employeeList.add(employee);
        for(Employee employee : officerrList)
            employeeList.add(employee);
        for(Employee employee : cashierList)
            employeeList.add(employee);
    }

    public void createManagingDirector()
    {
        Employee manager = new ManagingDirector("MD");
        managerList.add(manager);
    }

    public void createOfficer()
    {
        Employee officer1= new Officer("S1");
        Employee officer2 = new Officer("S2");
        officerrList.add(officer1);
        officerrList.add(officer2);
    }

    public void createCashier()
    {
        Employee c1 = new Cashier("C1");
        Employee c2 = new Cashier("C2");
        Employee c3 = new Cashier("C3");
        Employee c4 = new Cashier("C4");
        Employee c5 = new Cashier("C5");
        cashierList.add(c1);
        cashierList.add(c2);
        cashierList.add(c3);
        cashierList.add(c4);
        cashierList.add(c5);
    }


    //Create Account
    public  Account Create(String name , String accountType , double initialDeposit) throws FixedDepositException,SameNameException
    {
        if(isExistAccount(name))
            throw new SameNameException();

        Account account = null;

        if(accountType.equals("Savings"))
        {
            account = new SavingsAccount(name,accountType,initialDeposit);
            super.addAccount(account);
        }
        else if(accountType.equals("Student"))
        {
            account = new StudentAccount(name,accountType,initialDeposit);
            super.addAccount(account);
        }
        else if(accountType.equals("FixedDeposit"))
        {
            if(initialDeposit<100000)
                throw new FixedDepositException();
            account = new FixedDepositAccount(name,accountType,initialDeposit);
            super.addAccount(account);
        }

        return account;
    }


    //Deposit Money to bank
    public void Deposit(Account account ,double amount) throws FixedDepositException
    {
      account.Deposit(amount);
      double internalFund = getInternalFund();
      internalFund+= amount;
      setInternalFund(internalFund);
    }



    //Withdraw money from bank
    public void Withdraw(Account account, double amount) throws NegativeAmountException,StudentAccountException, SavingsAccountException, MaturityPeriodException
    {
        account.Withdraw(amount);

        double internalFund = getInternalFund();
        internalFund-= amount;
        setInternalFund(internalFund);

    }


    //Request Loan to bank
    public void RequestLoan(Account account,double amount) throws LoanException
    {
        account.Request_Loan(amount);
        loanAccountList.add(new LoanAccount(amount,account));
    }


    //Approve Loan By only manager or officer
    public void ApproveLoan(Employee employee)
    {
        if(managerList.contains(employee) | officerrList.contains(employee))
        {
            for(LoanAccount accountObj : loanAccountList)
            {
                Account oldAccount = accountObj.account;
                Account modAccount = accountObj.account;
                modAccount.Approved_Loan();

                updateAccount(oldAccount,modAccount);
            }
            loanAccountList.clear();
        }
    }


    //Change Interest Rate by only Managing Director
    public void ChangeInterestRate(Employee employee ,String type , double rate)
    {
        if(managerList.contains(employee))
        {
            if(type.equals("Savings"))
                SavingsAccount.setInterestRate(rate);
            else if(type.equals("Student"))
                StudentAccount.setInterestRate(rate);
            else if(type.equals("FixedDeposit"))
                FixedDepositAccount.setInterestRate(rate);
        }

    }



    //See Internal fund by only managing director
    public double SeeInternalFund(Employee employee)
    {
        System.out.println("bank :"+employee.getName());
        System.out.println( managerList.size());
      if(managerList.contains(employee))
      {
          System.out.println("in if ocnd");
          return getInternalFund();
      }
      else return  -1;
    }



    //Get an employee with this name
    public Employee getEmployee(String name)
    {
       for(Employee employee : employeeList)
       {
           if(employee.getName().equalsIgnoreCase(name))
               return employee;
       }
       return  null;
    }




}
