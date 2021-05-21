import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final String delim = "*".repeat(40);
        List<Train> trains = TrainFactory.randomGenerate(40);
        TrainFactory.addTrain(new Train());
        TrainFactory.prettyPrint(TrainSelector.byDest(trains,"Minsk"));
        System.out.println(delim);
        TrainFactory.prettyPrint(TrainSelector.byDestAndTime(trains,"Gomel",new Date(3600*5)));
        System.out.println(delim);
        TrainFactory.prettyPrint(TrainSelector.byGeneralPlaces(trains));
    }
}
