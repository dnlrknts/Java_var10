import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main
{
    private static ArrayList<Car> loadFromFile(File file) throws FileNotFoundException
    {
        ArrayList<Car> cars = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        double cost;
        double fuelc;
        double maxSpeed;
        String type;
        while (scanner.hasNextLine())
        {
            type = scanner.next();
            cost = Double.parseDouble(scanner.next());
            fuelc = Double.parseDouble(scanner.next());
            maxSpeed = Double.parseDouble(scanner.next());
                switch (type)
                {
                    case "A" -> cars.add(new OrdinaryCar(cost,fuelc,maxSpeed));
                    case "B" -> cars.add(new ChildSeatCar(cost,fuelc,maxSpeed));
                    default -> throw new IllegalStateException("Unexpected value: " + scanner.next());
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
        return cars.stream().filter(car ->
        {
            double fuel = car.getFuelConsumption();
            return (from <= fuel) && (fuel<=to);
        }).collect(Collectors.toList());
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
    public static void main(String[] args) throws FileNotFoundException
    {
        ArrayList<Car> cars = loadFromFile(new File("/Users/whiteshark53/Downloads/lab4_b/src/main/Data.txt"));
        System.out.println(takeByFuel(cars,8,10));
        System.out.println(sortByFuel(cars));
        System.out.println(calcCost(cars));
    }
}
