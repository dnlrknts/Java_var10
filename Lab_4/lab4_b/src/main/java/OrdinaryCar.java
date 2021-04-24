public class OrdinaryCar extends Car implements CarInformation
{
    public OrdinaryCar(double cost, double fuelConsumption, double maxSpeed)
    {
        super(cost, fuelConsumption, maxSpeed);
    }

    @Override
    public String toString()
    {
        return super.toString() + " " +getInformation();
    }

    @Override
    public String getInformation()
    {
        return "3 adult seats car";
    }
}
