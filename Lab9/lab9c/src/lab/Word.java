package lab;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Word extends Token
{
    Letter[] letters;
    Word(String s)
    {
        letters = s.chars()
                .mapToObj(Letter::new)
                .toArray(Letter[]::new);
    }

    @Override
    public String toString()
    {
        return Arrays.stream(letters)
                .map(Letter::toString)
                .collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;

        Word word = (Word) o;

        return word.toString().equals(o.toString());
    }

    @Override
    public int hashCode()
    {
        return toString().hashCode();
    }
}
