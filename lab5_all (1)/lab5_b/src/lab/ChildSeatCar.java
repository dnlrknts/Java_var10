package lab;

public class ChildSeatCar extends Car implements CarInformation
{
    public ChildSeatCar(double cost, double fuelConsumption, double maxSpeed)
    {
        super(cost, fuelConsumption, maxSpeed);
    }

    @Override
    public String getInformation()
    {
        return "2 adult seats and 1 child seat";
    }
}
