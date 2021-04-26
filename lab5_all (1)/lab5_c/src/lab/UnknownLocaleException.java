package lab;

public class UnknownLocaleException extends Exception
{
    public UnknownLocaleException(String what)
    {
        super("UnknownLocaleException " + what);
    }
}
