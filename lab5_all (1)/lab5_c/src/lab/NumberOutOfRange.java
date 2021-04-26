package lab;

public class NumberOutOfRange extends Exception
{
    public NumberOutOfRange(String what)
    {
        super("NumberOutOfRange " + what);
    }
}
