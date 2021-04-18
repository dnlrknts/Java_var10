package laba1_10.MethodClass;

import java.util.*;
import java.util.Map.Entry;

public class NumberSolver {
    public static List<Integer> readInput(Scanner sc) {
        List<Integer> input = new ArrayList<>();
        System.out.print("Введите целые числа через пробел, "
                + "для окончания введите q: ");
        while (sc.hasNext()) {
            String number = sc.next();
            if (number.equals("q")) {
                break;
            } else {
                try {
                    input.add(Integer.parseInt(number));
                } catch (NumberFormatException e) {
                    System.out.print("Неправильный формат. Программа завершена. ");
                    System.exit(0);
                }
            }
        }
        if (input.size() == 0) {
            System.exit(0);
        }
        return input;
    }
    public static void findNumbers(List<Integer> numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer number : numbers)
        {
            map.put(number, Collections.frequency(numbers, number));
        }
        // создаём список пар ключ - значение для его сортиовки
        ArrayList<Map.Entry<Integer,Integer>> entries = new ArrayList(map.entrySet());
        // используя анонимный класс пререопределяем компаратор для Сортировки
        entries.sort(new Comparator<Entry<Integer, Integer>>()
        {
            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2)
            {
                return Integer.compare(o2.getValue(),o1.getValue());
            }
        });
        ArrayList<Integer> keys = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : entries)
        {
            keys.add(entry.getKey());
        }
        System.out.println("Числа в порядке убывания частоты встречаемости "
                + "чисел (число=встречаемость): " + keys);
    }
}