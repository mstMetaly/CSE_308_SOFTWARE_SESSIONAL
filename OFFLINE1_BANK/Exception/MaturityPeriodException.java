package Exception;

public class MaturityPeriodException extends Throwable{
    int year;

    public MaturityPeriodException(int year)
    {
        this.year  = year;
    }
    public String toString()
    {
        return "Invalid transaction; year:  "+ year;
    }
}
