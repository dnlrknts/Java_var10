import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс представлет информацию о задании
 * @author Даниела Раконяц
 */
public class TaskInfo
{
    private static final TaskInfo instance = new TaskInfo();
    private static final SimpleDateFormat format = new SimpleDateFormat("HH:mm dd.MM.yyyy");
    private static final String startDate = "16.05.2021";
    private TaskInfo()
    {}
    public String description()
    {
        return "Таблица умножения\nВведите диапазо чисел: от до";
    }
    public String author()
    {
        return "*".repeat(40) + "\n"+
                "Задание выполнила Даниела Раконяц\n"+
                "Дата получения задания "+ startDate+ "\n" +
                "Дата сдачи задания " + format.format(new Date()) +"\n"+
                "*".repeat(40) + "\n";
    }
    public static TaskInfo instance()
    {
        return instance;
    }
}
