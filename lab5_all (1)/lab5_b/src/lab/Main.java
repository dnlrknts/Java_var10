package lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.*;

public class Main
{
    private static ArrayList<Car> loadFromFile(File file) throws FileNotFoundException
    {
        ArrayList<Car> cars = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        double cost;
        double fuelc;
        double maxSpeed;
        String type = null;
        while (scanner.hasNextLine())
        {
            try
            {
                type = scanner.next();
                cost = Double.parseDouble(scanner.next());
                fuelc = Double.parseDouble(scanner.next());
                maxSpeed = Double.parseDouble(scanner.next());
                switch (type)
                {
                    case "A" -> cars.add(new OrdinaryCar(cost, fuelc, maxSpeed));
                    case "B" -> cars.add(new ChildSeatCar(cost, fuelc, maxSpeed));
                    default -> throw new IllegalStateException("Неподдерживаемый тип");
                }
            }
            catch (NoSuchElementException | IllegalStateException e)
            {
                System.out.println("Неверный формат входных данных");
                System.out.println(e.getMessage() + " " + type);
            }

        }
        return cars;
    }
    private static List<Car> sortByFuel(List<Car> cars)
    {
        ArrayList<Car> sorted = new ArrayList<>(cars);
        sorted.sort(Comparator.comparingDouble(Car::getFuelConsumption));
        return sorted;
    }
    private static List<Car> takeByFuel(List<Car> cars, double from, double to)
    {
        List<Car> list = new ArrayList<>();
        double fuel;
        for (Car c : cars)
        {
            fuel = c.getFuelConsumption();
            if((from <= fuel) && (fuel<=to))
                list.add(c);
        }
        return list;
    }

    private static double calcCost(List<Car> cars)
    {
        double cost = 0;
        for (Car c : cars)
        {
            cost+=c.getCost();
        }
        return cost;
    }
    public static void main(String[] args)
    {
        try
        {
            ArrayList<Car> cars = loadFromFile(new File("Data.txt"));
            System.out.println(takeByFuel(cars,8,10));
            System.out.println(sortByFuel(cars));
            System.out.println(calcCost(cars));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Такого файла нет");
        }

    }
}
