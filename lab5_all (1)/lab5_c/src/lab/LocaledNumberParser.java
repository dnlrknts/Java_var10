package lab;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class LocaledNumberParser
{
    private double min;
    private double max;
    private NumberFormat rus = NumberFormat.getInstance(Locale.ROOT);
    private NumberFormat us = NumberFormat.getInstance(Locale.US);

    public LocaledNumberParser(double min,double max)
    {
        this.min = min;
        this.max = max;
    }
    public double parseNumber(String line) throws NumberOutOfRange,InvalidNumberFormat,UnknownLocaleException
    {
        String[] s = line.split(" ");
        if(s.length!=2)
            throw new InvalidNumberFormat("String " + line + " is not a number");
        String locale = s[0];
        String number = s[1];
        double d=0;
        try
        {
            d = (switch (locale)
            {
                case "RUS" -> rus.parse(number);
                case "US" -> us.parse(number);
                default -> throw new UnknownLocaleException(locale);
            }).doubleValue();
        }
        catch (ParseException e)
        {
            throw new InvalidNumberFormat(e.getMessage());
        }
        if((min<=d) && (d<=max))
            return d;
        else throw new NumberOutOfRange("min: "+ min+" max: " + max + " number: " + d);
    }
}
