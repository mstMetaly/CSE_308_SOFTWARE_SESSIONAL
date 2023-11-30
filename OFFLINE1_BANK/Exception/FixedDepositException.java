package Exception;

public class FixedDepositException extends Throwable{

    public FixedDepositException()
    {

    }
    public String toString()
    {
        return "Invalid transaction!";
    }
}
