package lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Text
{
    Sentence[] sentences;
    public Text(String st)
    {
        sentences = Arrays.stream(st.replaceAll("[\r\n \t]+"," ")
                .split("[.;]"))
                .filter(s->!s.isEmpty())
                .map(Sentence::new)
                .toArray(Sentence[]::new);
    }
    public Word[] getWords()
    {
        List<Word> words = new ArrayList<>();
        Arrays.stream(sentences)
                .map(s->Arrays.asList(s.getWords()))
                .forEach(words::addAll);
        return words.toArray(Word[]::new);
    }
    @Override
    public String toString()
    {
        return Arrays.stream(sentences)
                .map(Sentence::toString)
                .collect(Collectors.joining("\n"));
    }
    public void format()
    {
        int max = Arrays.stream(sentences).mapToInt(Sentence::length).max().orElseThrow();
        for(Sentence sentence : sentences)
        {
            sentence.format(max);
        }
    }
}
