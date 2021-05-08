package lab;

public class ShoppingCenter extends AbstractHouse
{
    public ShoppingCenter(BankAccount account, Room[] rooms)
    {
        super(account, rooms);
    }
    @Override
    public void buildHouse()
    {
        super.buildHouse();
        System.out.println("Построен торговый центр за " + getPrice());
    }
    @Override
    public void toRent()
    {
        double d = 0.03*getPrice();
        System.out.println("Доход от аренды " + d);
        account.earn(d);
    }

    @Override
    public void renovateRoom(int index, double cost)
    {
        super.renovateRoom(index,cost);
        System.out.println("Торговый центр : комната " + index + " отремонтирована за " + cost);
    }

    @Override
    public void addRoom(Room room)
    {
        System.out.println("В торговый центр добавлено помещение");
        super.addRoom(room);
    }
    public void decorate()
    {
        for(int i = 0; i < getNumOfRooms(); i++)
        {
            renovateRoom(i,10);
        }
        System.out.println("Торговый центр украшен к празднику");
    }
}
