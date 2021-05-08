package lab;

public class BankAccount
{
    private double value;

    public BankAccount(double value)
    {
        this.value = value;
    }
    public void pay(double d)
    {
        value-=d;
    }
    public void earn(double d)
    {
        value+=d;
    }
}
