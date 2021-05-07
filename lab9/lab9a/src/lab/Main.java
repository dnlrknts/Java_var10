package lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {
    private static List<Map.Entry<Character,Integer>> process(String filename) throws IOException
    {
        Map<Character,Integer> map = new HashMap<>();
        Files.lines(Path.of(filename)).forEach(s->
        {
            for (String word : s.split(" "))
                for (char ch : word.toCharArray())
                {
                    map.computeIfPresent(ch,(k,v)->v+1);
                    map.computeIfPresent(ch,(c,i)->map.replace(c,i++));
                    map.putIfAbsent(ch,1);
                }
        });
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet().stream().toList());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));
        Collections.reverse(list);
        return list;
    }
    public static void main(String[] args) throws IOException
    {
        System.out.println(process("data.txt").subList(0,Integer.parseInt(args[0])));
    }
}
