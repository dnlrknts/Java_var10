public class Car
{
    private double cost;
    private double fuelConsumption;
    private double maxSpeed;

    public Car(double cost, double fuelConsumption, double maxSpeed)
    {
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
