package Exception;

public class SavingsAccountException extends Throwable {
    double currentBalance;

    public SavingsAccountException(double currentBalance)
    {
        this.currentBalance = currentBalance;
    }
    public String toString()
    {
        return "Invalid transaction; current balance "+ currentBalance;
    }
}
