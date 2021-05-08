package lab;

public class House extends AbstractHouse
{
    public House(BankAccount account, Room[] rooms)
    {
        super(account, rooms);
    }
    @Override
    public void addRoom(Room room)
    {
        System.out.println("В дом добавлена комната");
        super.addRoom(room);
    }
    @Override
    public void buildHouse()
    {
        super.buildHouse();
        System.out.println("Построен дом за " + getPrice());
    }
    @Override
    public void toRent()
    {
        double d = 0.01*getPrice();
        System.out.println("Доход от аренды " + d);
        account.earn(d);
    }

    @Override
    public void renovateRoom(int index, double cost)
    {
        super.renovateRoom(index,cost);
        System.out.println("Дом : комната " + index + " отремонтирована за " + cost);
    }
    public void clean()
    {
        System.out.println("В доме проведена уборка");
        account.pay(10);
    }
}
