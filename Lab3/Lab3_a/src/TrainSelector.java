import java.util.Date;
import java.util.List;

public class TrainSelector
{
    private TrainSelector()
    {}
    public static List<Train> byDest(List<Train> trains, String dest)
    {
        return trains.stream().filter(t->t.getDest().equals(dest)).toList();
    }
    public static List<Train> byDestAndTime(List<Train> trains, String dest, Date date)
    {
        return byDest(trains,dest).stream().filter(t->t.getDeparture().after(date)).toList();
    }
    public static List<Train> byGeneralPlaces(List<Train> trains)
    {
        return trains.stream().filter(t->t.getPlaces().getCommon()>0).toList();
    }

}
