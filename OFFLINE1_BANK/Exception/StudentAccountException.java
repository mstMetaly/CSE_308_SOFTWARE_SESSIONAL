package Exception;

public class StudentAccountException extends Throwable {
    double currentBalance;

    public StudentAccountException(double currentBalance)
    {
        this.currentBalance = currentBalance;
    }
    public String toString()
    {
        return "Invalid transaction; current balance "+ currentBalance;
    }
}
