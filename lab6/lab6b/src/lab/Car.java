package lab;

import java.io.Serializable;

public class Car implements Serializable
{
    private String type;
    private double cost;
    private double fuelConsumption;
    private double maxSpeed;

    public Car(String type,double cost, double fuelConsumption, double maxSpeed)
    {
        this.type = type;
        this.cost = cost;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    public void setFuelConsumption(double fuelConsumption)
    {
        this.fuelConsumption = fuelConsumption;
    }

    public double getCost()
    {
        return cost;
    }

    public double getFuelConsumption()
    {
        return fuelConsumption;
    }

    public String getType()
    {
        return type;
    }

    public double getMaxSpeed()
    {
        return maxSpeed;
    }

    @Override
    public String toString()
    {
        return "Car{" +
                "cost=" + cost +
                ", fuelConsumption=" + fuelConsumption +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
