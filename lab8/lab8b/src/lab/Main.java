package lab;

public class Main {
    private static Room[] rooms()
    {
        return  new Room[]{
                new Room(25,10),
                new Room(30,12),
                new Room(45,20)};
    }
    private static void testAbstractHouse(AbstractHouse house)
    {
        System.out.println("**********************");
        house.buildHouse();
        System.out.println("Цена за м.кв. = " + house.getCostPerSquare());
        System.out.println("Цена = " + house.getPrice());
        System.out.println("Площадь = " + house.getArea());
        System.out.println("Число комнат = " + house.getNumOfRooms());
        house.addRoom(new Room(12,50));
        house.renovateRoom(0,23);
        house.toRent();
    }
    private static void testHouse(BankAccount bankAccount)
    {
        House house = new House(bankAccount, rooms());
        testAbstractHouse(house);
        house.clean();
    }
    private static void testOfficeBuilding(BankAccount bankAccount)
    {
        OfficeBuilding building = new OfficeBuilding(bankAccount, rooms());
        testAbstractHouse(building);
        building.increaseRentK();
    }
    private static void testShoppingCenter(BankAccount account)
    {
        ShoppingCenter center = new ShoppingCenter(account,rooms());
        testAbstractHouse(center);
        center.decorate();
    }
    public static void main(String[] args)
    {
        BankAccount account = new BankAccount(1000);
        testHouse(account);
        testOfficeBuilding(account);
        testShoppingCenter(account);
    }
}
