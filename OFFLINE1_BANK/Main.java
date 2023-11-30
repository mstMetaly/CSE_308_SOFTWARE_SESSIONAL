import Account.Account;
import Bank.Bank;

import Employee.Employee;
import Bank.LoanAccount;

import Exception.FixedDepositException;
import Exception.SameNameException;
import Exception.StudentAccountException;
import Exception.NegativeAmountException;
import Exception.SavingsAccountException;
import Exception.MaturityPeriodException;
import Exception.LoanException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Bank bank =  new Bank(1000000);
        System.out.println("Bank Created; MD, S1, S2, C1, C2, C3, C4, C5 created");

        Scanner sc = new Scanner(System.in);
        Account account = null;
        String name = null;
        Employee bankEmployee = null;

        while(sc.hasNextLine()) {
            String commandLine = sc.nextLine();

            String[] arrCommand = commandLine.split(" ");

            String command = arrCommand[0];

            try {
                switch (command) {

                    case "Create": {
                        name = arrCommand[1];
                        String accountType = arrCommand[2];
                        double initialDeposit = Double.parseDouble(arrCommand[3]);

                        account = bank.Create(name, accountType, initialDeposit);

                        System.out.println(accountType+" account for "+name+" Created; initial balance "+initialDeposit+"$");

                        break;
                    }

                    case "Deposit": {
                        if(account==null)
                        {
                            System.out.println("You don’t have permission for this operation");
                            break;
                        }
                        double amount = Double.parseDouble(arrCommand[1]);

                        bank.Deposit(account,amount);
                        System.out.println(amount+ "$ deposited; current balance "+account.getBalance()+"$");
                        break;
                    }

                    case "Withdraw": {
                        if(account==null)
                        {
                            System.out.println("You don’t have permission for this operation");
                            break;
                        }
                        double amount = Double.parseDouble(arrCommand[1]);

                        bank.Withdraw(account , amount);
                        System.out.println(amount+ "$ withdrawn; current balance "+account.getBalance()+"$");
                        break;
                    }

                    case "Request": {
                        if(account==null)
                        {
                            System.out.println("You don’t have permission for this operation");
                            break;
                        }
                        double amount = Double.parseDouble(arrCommand[1]);

                        bank.RequestLoan(account,amount);

                        System.out.println("Loan request successful, sent for approval");
                        break;

                    }

                    case "Query": {
                        if(account==null)
                        {
                            System.out.println("You don’t have permission for this operation");
                            break;
                        }
                        if(account.getRequestLoan()==0)
                        System.out.println("Current Balance "+ account.getBalance()+"$");
                        else
                            System.out.println("Current Balance "+account.getBalance()+"$, loan "+account.getRequestLoan()+"$");
                        break;
                    }

                    case "Close": {
                        if(account==null && bankEmployee==null)
                        {
                            System.out.println("You don’t have permission for this operation");
                            break;
                        }
                        System.out.println("Transaction Closed for "+name);
                        account = null;
                        name = null;
                        bankEmployee= null;
                        break;
                    }

                    case "Open": {
                        name = arrCommand[1];
                        Employee employee = bank.getEmployee(name);

                        if(employee!=null)
                        {
                            bankEmployee = employee;

                            if(bank.loanAccountList.size()!=0)
                                System.out.println(name+" active, there are loan approvals pending");
                            else
                                System.out.println(name+" active, there is no loan approvals pending");
                            break;
                        }

                        System.out.println("Welcome back, "+name);
                        account = bank.getAccount(name);
                        break;
                    }

                    case "ApproveLoan":{
                        if(bank.loanAccountList.size()!=0)
                        {
                            for(LoanAccount obj : bank.loanAccountList)
                            {
                                Account account1= obj.getAccount();
                                System.out.println("Loan for "+account1.getName()+" approved");
                            }
                        }
                        bank.ApproveLoan(bankEmployee);
                        break;

                    }

                    case "Change":
                    {
                        String type = arrCommand[1];
                        double rate = Double.parseDouble(arrCommand[2]);

                        bank.ChangeInterestRate(bankEmployee ,type ,rate);
                        break;
                    }

                    case "Lookup":
                    {
                        String holder = arrCommand[1];
                        Account holderAccount = bank.getAccount(holder);

                        double holderBalance = bankEmployee.Lookup(holderAccount);
                        System.out.println(holder+"’s current balance "+ holderBalance +"$");
                        break;
                    }

                    case "See":{
                        //see internal fund
                        double fund = bank.SeeInternalFund(bankEmployee);

                        if(fund == -1)
                        {
                            System.out.println("You don’t have permission for this operation");
                            break;
                        }
                        System.out.println("Total internal fund "+ fund);
                        break;
                    }

                    case "INC":{
                        bank.incrementYear();
                        System.out.println("1 year passed");

                        bank.calculateProfit();
                        bank.ChargeAccount();
                        break;
                    }

                }

            }
            catch (FixedDepositException e)
            {
                System.out.println(e);
            }
            catch (SameNameException e)
            {
                System.out.println(e);
            }
            catch (StudentAccountException e)
            {
                System.out.println(e);
            }
            catch (NegativeAmountException e)
            {
                System.out.println(e);
            }
            catch (MaturityPeriodException e)
            {
                System.out.println(e);
            }
            catch (SavingsAccountException e)
            {
                System.out.println(e);
            }
            catch (LoanException e)
            {
                System.out.println(e);
            }

        }


        }


}
