package lab;

import lab.save.ObjectCarSaveLoader;
import lab.save.TextCarSaveLoader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main
{
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
            TextCarSaveLoader textCarSaveLoader = new TextCarSaveLoader();
            List<Car> cars = textCarSaveLoader.load("Data.txt");
            textCarSaveLoader.save("test.txt",takeByFuel(cars,8,10));
            System.out.println(takeByFuel(cars,8,10));
            System.out.println(sortByFuel(cars));
            System.out.println(calcCost(cars));
            System.out.println(textCarSaveLoader.load("test.txt"));
            ObjectCarSaveLoader objectCarSaveLoader = new ObjectCarSaveLoader();
            objectCarSaveLoader.save("test.ser",sortByFuel(cars));
            System.out.println(objectCarSaveLoader.load("test.ser"));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Такого файла нет");
        } catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }
}
