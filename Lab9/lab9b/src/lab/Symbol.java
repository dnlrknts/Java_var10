package lab;

public class Symbol extends Token
{
    private final char c;
    public Symbol(char c)
    {
        this.c = c;
    }
    public char get()
    {
        return c;
    }

    @Override
    public String toString()
    {
        return Character.toString(c);
    }
}
