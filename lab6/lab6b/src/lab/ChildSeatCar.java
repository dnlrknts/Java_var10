package lab;

import java.io.Serializable;

public class ChildSeatCar extends Car implements CarInformation, Serializable
{
    public ChildSeatCar(String type, double cost, double fuelConsumption, double maxSpeed)
    {
        super(type, cost, fuelConsumption, maxSpeed);
    }

    @Override
    public String getInformation()
    {
        return "2 adult seats and 1 child seat";
    }
}
