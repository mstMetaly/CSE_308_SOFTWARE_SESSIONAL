package Exception;

public class NegativeAmountException extends Throwable {
    public NegativeAmountException()
    {

    }
    public String toString()
    {
        return "Invalid transaction!";
    }
}
