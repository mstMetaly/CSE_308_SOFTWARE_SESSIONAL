package Exception;

public class SameNameException extends Throwable {
    public SameNameException()
    {
    }
    public String toString()
    {
        return "Account already exists with this name";
    }
}
