import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main
{
    static InOutFiles readPar(String filename) throws IOException
    {
        String[] args = Files.lines(Paths.get(filename)).toArray(String[]::new);
        return new InOutFiles(args[0],args[1]);
    }
    static void process(InOutFiles files)
    {
        try
        {
            FileWriter out  = new FileWriter(files.getOut());
            String[] lines = Files.lines(Paths.get(files.getIn())).map(line ->
            {
                String[] words = line.split(" ");
                StringBuilder str = new StringBuilder();
                Arrays.stream(words).map(w ->
                {
                    StringBuilder b = new StringBuilder(w);
                    b.setCharAt(0, Character.toUpperCase(w.charAt(0)));
                    return b.append(' ');
                }).forEach(str::append);
                return str.toString();
            }).toArray(String[]::new);
            for (String line : lines)
            {
                out.write(line);
                out.write('\n');
            }
            out.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        InOutFiles inOutFiles;
        try
        {
            switch (args[0])
            {
                case "-c" -> inOutFiles = new InOutFiles(args[1], args[2]);
                case "-f" -> inOutFiles = readPar(args[1]);
                default -> throw new IllegalArgumentException("Incorrect input");
            }
            process(inOutFiles);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
