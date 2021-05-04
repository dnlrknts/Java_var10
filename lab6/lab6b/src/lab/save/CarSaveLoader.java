package lab.save;

import lab.Car;

import java.io.IOException;
import java.util.List;

interface CarSaveLoader
{
    List<Car> load(String filename) throws IOException, ClassNotFoundException;
    void save(String filename,List<Car> cars) throws IOException;
}
