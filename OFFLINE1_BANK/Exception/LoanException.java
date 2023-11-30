package Exception;

public class LoanException extends Throwable {
    public LoanException()
    {

    }
    public String toString()
    {
        return "Exceeded Loan Amount!";
    }
}
