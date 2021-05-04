package lab.save;

import lab.Car;
import lab.ChildSeatCar;
import lab.OrdinaryCar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TextCarSaveLoader implements CarSaveLoader
{
    @Override
    public List<Car> load(String filename) throws IOException
    {
        ArrayList<Car> cars = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filename));
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
                    case "A" -> cars.add(new OrdinaryCar(type,cost, fuelc, maxSpeed));
                    case "B" -> cars.add(new ChildSeatCar(type,cost, fuelc, maxSpeed));
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

    @Override
    public void save(String filename, List<Car> cars) throws IOException
    {
        File outFile = new File(filename);
        outFile.createNewFile();
        FileWriter out = new FileWriter(outFile);
        Iterator<Car> iterator = cars.iterator();
        Car c;
        int i = 0;
        do
        {
            c = iterator.next();
            out.write(c.getType() + ' ' + c.getCost() + ' ' + c.getFuelConsumption() + ' ' + c.getMaxSpeed() + '\n');
        }
        while (i<cars.size()-2);
        c = iterator.next();
        out.write(c.getType() + ' ' + c.getCost() + ' ' + c.getFuelConsumption() + ' ' + c.getMaxSpeed());
        out.close();
    }
}