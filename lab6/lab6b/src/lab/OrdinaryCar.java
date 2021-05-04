package lab;

import java.io.Serializable;

public class OrdinaryCar extends Car implements CarInformation, Serializable
{
    public OrdinaryCar(String type, double cost, double fuelConsumption, double maxSpeed)
    {
        super(type, cost, fuelConsumption, maxSpeed);
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
