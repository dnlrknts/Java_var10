package lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static List<Map.Entry<Word,Integer>> process(Text text, List<Word> words)
    {
        Map<Word,Integer> map = new HashMap<>();
        Arrays.stream(text.getWords())
                .forEach(word->
        {
            map.computeIfPresent(word,(k,v)->v+1);
            map.putIfAbsent(word,1);
        });
        List<Map.Entry<Word,Integer>> result = new ArrayList<>();
        for(Word word : new HashSet<>(words))
            if(map.containsKey(word))
                result.add(new AbstractMap.SimpleEntry<>(word, map.get(word)));
        result.sort(Comparator.comparingInt(Map.Entry::getValue));
        Collections.reverse(result);
        return result;
    }
    public static Text readFormFile(String filename) throws IOException
    {
        return new Text(new String(Files.readAllBytes(Paths.get(filename))));
    }
    public static void main(String[] args) throws IOException
    {
        Text text = readFormFile("data.txt");
        System.out.println(process(text, Arrays.asList(text.getWords())));
        System.out.println(text);
        text.format();
        System.out.println(text);
    }
}
