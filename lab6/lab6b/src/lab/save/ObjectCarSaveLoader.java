package lab.save;

import lab.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectCarSaveLoader implements CarSaveLoader
{
    @Override
    public List<Car> load(String filename) throws IOException, ClassNotFoundException
    {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
        List<Car> cars = new ArrayList<>();
        while (true) {
            try {
                Car obj = (Car)ois.readObject();
                cars.add(obj);
            } catch (Exception ex)
            {
                break;
            }
        }
        return cars;
    }

    @Override
    public void save(String filename, List<Car> cars) throws IOException
    {
        File outFile = new File(filename);
        outFile.createNewFile();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outFile));
        for (Car c: cars)
            oos.writeObject(c);
        oos.close();
    }
}
