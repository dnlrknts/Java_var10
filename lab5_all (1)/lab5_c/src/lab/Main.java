package lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.DoubleStream;

public class Main {
    private static List<Double> readFile(String filename) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new FileInputStream(filename));
        List<Double> list = new ArrayList<>();
        LocaledNumberParser parser = new LocaledNumberParser(0.2,0.8);
        while (scanner.hasNextLine())
        {
            try
            {
                list.add(parser.parseNumber(scanner.nextLine()));
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        return list;
    }
    private static void createFile(int size,String filename) throws IOException
    {
        FileWriter out = new FileWriter(filename);
        NumberFormat rus = NumberFormat.getInstance(Locale.ROOT);
        NumberFormat us = NumberFormat.getInstance(Locale.US);
        Random random = new Random();
        for(int i = 0; i < size; i++)
        {
            if(random.nextBoolean())
                out.write("RUS " + rus.format(random.nextDouble()));
            else
                out.write("US " + us.format(random.nextDouble()));
            out.write("\n");
        }
        out.close();
    }

    public static void main(String[] args)
    {
/*        try
        {
            createFile(10,"data.txt");
        }
        catch (IOException e)
        {
            System.out.println("Не удалось создать файл");
        }*/
        try
        {
            List<Double> list = readFile("data.txt");
            //Double::doubleValue ссылка на метод класса Double
            double sum = list.stream().mapToDouble(Double::doubleValue).sum();
            double av = list.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
            System.out.println("sum " + sum + "\naverage "+ av);
        }
        catch (NoSuchElementException e)
        {
            System.out.println("Нет подходящих чисел в списке");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
