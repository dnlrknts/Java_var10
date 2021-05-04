package lab;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.Arrays;

public class Main
{

    public static void main(String[] args)
    {
        try
        {
            String inFileName = args[0];
            String outFileName = args[1];
            String outDirName = args[2];
            File inFile = new File(inFileName);
            File outDir = new File(outDirName);
            outDir.mkdir();
            String outPathName = outDirName + "/" + outFileName;
            File outFile = new File(outPathName);
            outFile.createNewFile();

            FileWriter out = new FileWriter(outFile);
            String[] lines = Files.lines(inFile.toPath()).map(line ->
            {
                String[] words = line.split(" ");
                String temp = words[0];
                words[0] = words[words.length-1];
                words[words.length-1] = temp;
                StringBuilder str = new StringBuilder();
                Arrays.stream(words).forEach(w->str.append(w).append(' '));
                return str.toString();
            }).toArray(String[]::new);
            for (String line : lines)
            {
                out.write(line);
                out.write('\n');
            }
            out.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
