import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TrainFactory
{
    private TrainFactory()
    {}
    private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    private static final Random random = new Random();
    private static final String[] availableDest = new String[]{"Minsk","Grodno","Vitebsk","Mogilev","Gomel","Brest"};
    private static final Date[] availableDates = new Date[20];
    static
    {
        try
        {
            for(int i = 0 ; i < 20; i++)
                availableDates[i] = format.parse(i+":00:00");
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    private static final List<Train> trains = new ArrayList<>();
    public static List<Train> addTrain(Train t)
    {
        trains.add(t);
        return trains;
    }
    public static List<Train> randomGenerate(int n)
    {
        for(int i = 0; i < n; i++)
        {
            trains.add(new Train(
                    availableDest[random.nextInt(availableDest.length)],
                    random.nextInt(1000000),
                    availableDates[random.nextInt(availableDest.length)],
                    new Places(random.nextInt(30),
                            random.nextInt(30),
                            random.nextInt(30),
                            random.nextInt(30))));
        }
        return trains;
    }
    public static void prettyPrint( List<Train> trains)
    {
        for (Train t : trains)
            System.out.println(t);
    }

}
