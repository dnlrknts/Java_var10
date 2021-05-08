package lab;

public class OfficeBuilding extends AbstractHouse
{
    double k = 0.02;
    public OfficeBuilding(BankAccount account, Room[] rooms)
    {
        super(account, rooms);
    }
    @Override
    public void buildHouse()
    {
        super.buildHouse();
        System.out.println("Построено офисное здание за " + getPrice());
    }
    @Override
    public void toRent()
    {

        double d = k*getPrice();
        System.out.println("Доход от аренды " + d);
        account.earn(d);
    }
    @Override
    public void renovateRoom(int index, double cost)
    {
        super.renovateRoom(index,cost);
        System.out.println("Офисное здание : комната " + index + " отремонтирована за " + cost);
    }
    @Override
    public void addRoom(Room room)
    {
        System.out.println("В офисное здание добавлен кабинет");
        super.addRoom(room);
    }
    public void increaseRentK()
    {
        System.out.println("Увеличена стоимость аренды");
        k+=0.01;
    }
}
