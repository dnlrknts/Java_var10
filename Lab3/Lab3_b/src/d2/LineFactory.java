package d2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class LineFactory
{
    private static final Random random = new Random();
    private final static Vector2D[] availableVectors = new Vector2D[]
            {
                    new Vector2D(1, 1),
                    new Vector2D(1, -1),
                    new Vector2D(-1, 1),
                    new Vector2D(-1, -1)
            };

    public static Line2D randomLine()
    {
        return new Line2D(new Point2D(
                random.nextInt(20), random.nextInt(20)),
                availableVectors[random.nextInt(availableVectors.length)]);
    }

    public static List<Line2D> generate(int n)
    {
        List<Line2D> lines = new ArrayList<>();
        for (int i = 0; i < n; i++)
            lines.add(randomLine());
        return lines;
    }

    public static List<List<Line2D>> splitParallel(final List<Line2D> lines)
    {
        final List<Line2D> copy = new ArrayList<>(lines);
        List<List<Line2D>> result = new ArrayList<>();

        while (!copy.isEmpty())
        {
            Line2D current = copy.get(0);
            copy.remove(0);
            ArrayList<Line2D> add = new ArrayList<>();
            add.add(current);
            for (Line2D line : copy)
                if (current.isParallelTo(line))
                    add.add(line);

            copy.removeAll(add);
            result.add(add);
        }
        return result;
    }

    public static void prettyPrint(List<List<Line2D>> list)
    {
        final String delim = "*".repeat(40);
        System.out.println(delim);
        for (List<Line2D> lines : list)
        {
            for (Line2D line : lines)
                System.out.println(line);
            System.out.println(delim);
        }
    }
}
