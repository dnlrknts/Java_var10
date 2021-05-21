import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * Класс класс для представления диапазона целых чисел
     * @author Даниела Раконяц
     *
     */
    public record Range(int from, int to)
    {}
    /**
     * Функция печатет в системный вывод таблицу умножения
     * @param range представляет диапазон выводимых значений таблиц умножения
     */
    public static void printTable(Range range)
    {
        final int diff = range.to -range.from+1;
        final int[][] table = new int[diff][diff];
        for (int i = range.from; i <= range.to; i++)
            for(int j = range.from; j<= range.to; j++)
                table[i-1][j-1] = i*j;
        System.out.println(Arrays.deepToString(table).replace("], ", "]\n"));
    }
    /**
     * Функция для получения диапазона {@link Range} из системного ввода
     * @return возвращает прочитанный диапазон
     */
    public static Range readRange()
    {
        Scanner scanner = new Scanner(System.in);
        return new Range(scanner.nextInt(),scanner.nextInt());
    }

    public static void main(String[] args) {
        TaskInfo taskInfo = TaskInfo.instance();
        System.out.println(taskInfo.author());
        System.out.println(taskInfo.description());
        printTable(readRange());
    }
}