package lab;

import java.util.Arrays;

public abstract class AbstractHouse
{
    protected Room[] rooms;
    protected BankAccount account;
    public AbstractHouse(BankAccount account,Room[] rooms)
    {
        this.account = account;
        this.rooms = rooms;
    }

    public double getPrice()
    {
        return Arrays.stream(rooms).mapToDouble(Room::getPrice).sum();
    }

    public double getArea()
    {
        return Arrays.stream(rooms).mapToDouble(Room::getArea).sum();
    }

    public double getCostPerSquare()
    {
        return getPrice()/getArea();
    }

    public int getNumOfRooms()
    {
        return rooms.length;
    }

    public void addRoom(Room room)
    {
        rooms = Arrays.copyOf(rooms,rooms.length+1);
        rooms[rooms.length-1] = room;
    }
    public abstract void toRent();
    public void renovateRoom(int index, double cost)
    {
        rooms[index].renovate(cost);
        account.pay(cost);
    }
    public void buildHouse()
    {
        account.pay(getPrice());
    }
}
