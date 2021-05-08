package lab;

public class Room
{
    private final double area;
    private double price;

    public Room(double area, double price)
    {
        this.area = area;
        this.price = price;
    }

    public double getArea()
    {
        return area;
    }

    public double getPrice()
    {
        return price;
    }

    void renovate(double cost)
    {
        price+=cost;
    }
}
