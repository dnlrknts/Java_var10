package lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Sentence
{
    static final String delim = "—:, !\t";
    Token[] tokens;
    public Sentence(String s)
    {
        List<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder(s);
        while(delim.contains(String.valueOf(builder.charAt(0))))
        {
            builder.delete(0,1);
        }
        builder.reverse();
        while(delim.contains(String.valueOf(builder.charAt(0))))
        {
            builder.delete(0,1);
        }
        s = builder.reverse().toString();
        StringTokenizer st = new StringTokenizer(s,delim , true);
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        List<Token> ts = new ArrayList<>();
        for(String str:list)
        {
            if(str.length()!=1)
                ts.add(new Word(str));
            else
            {
                if(delim.contains(str))
                    ts.add(new PunctuationMark(str.charAt(0)));
                else
                    ts.add(new Word(str));
            }
        }
        ts.add(new PunctuationMark('.'));
        tokens = ts.toArray(Token[]::new);
    }
    public Word[] getWords()
    {
        return Arrays.stream(tokens)
                .filter(t->t instanceof Word)
                .map(t->(Word)t)
                .toArray(Word[]::new);
    }

    @Override
    public String toString()
    {
        return Arrays.stream(tokens)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
    public int length()
    {
        return toString().length();
    }
    public void format(int newLength)
    {
        final int currentLength = length();
        int needSpaces = newLength - currentLength;
        int add = (int) Math.ceil(((double) needSpaces)/getWords().length);
        List<Token> list = new ArrayList<>();
        for(Token t: Arrays.copyOf(tokens,tokens.length-2))
        {
            list.add(t);
            if(t instanceof PunctuationMark)
            {
                int currentAdd = Math.min(add, needSpaces);
                for (int i = 0; i < currentAdd; i++, needSpaces--)
                    list.add(new PunctuationMark(' '));
            }
        }
        list.add(tokens[tokens.length-2]);
        list.add(new PunctuationMark('.'));
        tokens = list.toArray(Token[]::new);
    }
}
