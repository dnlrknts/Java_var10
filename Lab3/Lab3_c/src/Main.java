import java.util.*;

import static java.util.Comparator.comparingDouble;

public class Main {
    private static final Quadrilateral[] squares = new Quadrilateral[]
            {
                    new Quadrilateral(new Point(0,0),new Point(0,1),new Point(1,1),new Point(1,0)),
                    new Quadrilateral(new Point(0,0),new Point(0,2),new Point(2,2),new Point(2,0)),
                    new Quadrilateral(new Point(0,0),new Point(0,3),new Point(3,3),new Point(3,0))
            };
    private static final Quadrilateral[] rectangles = new Quadrilateral[]
            {

                    new Quadrilateral(new Point(0,0),new Point(0,1),new Point(2,1),new Point(2,0)),
                    new Quadrilateral(new Point(0,0),new Point(0,2),new Point(4,2),new Point(4,0)),
                    new Quadrilateral(new Point(0,0),new Point(0,3),new Point(6,3),new Point(6,0))
            };
    private static final Quadrilateral[] rhombuses = new Quadrilateral[]
            {
                    new Quadrilateral(new Point(1,0),new Point(0,2),new Point(1,4),new Point(2,2)),
                    new Quadrilateral(new Point(1,0),new Point(0,3),new Point(1,6),new Point(2,3)),
                    new Quadrilateral(new Point(1,0),new Point(0,5),new Point(1,10),new Point(2,5)),
            };
    private static final Quadrilateral[] other = new Quadrilateral[]
            {
                    new Quadrilateral(new Point(0,0),new Point(0,2),new Point(1,1),new Point(2,0)),
                    new Quadrilateral(new Point(0,0),new Point(0,3),new Point(2,2),new Point(3,0)),
                    new Quadrilateral(new Point(0,0),new Point(0,5),new Point(4,3),new Point(2,0))
            };
    private static void perimeter(Quadrilateral[] figs)
    {
        ArrayList<Quadrilateral> list = new ArrayList<>(Arrays.asList(figs));
        list.sort(comparingDouble(Quadrilateral::getPerimeter));
        System.out.println("min : " + list.get(0) + " max : " + list.get(list.size()-1));
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(squares));
        System.out.println(Arrays.toString(rectangles));
        System.out.println(Arrays.toString(rhombuses));
        System.out.println(Arrays.toString(other));
        System.out.println("*".repeat(40));
        perimeter(squares);
        perimeter(rectangles);
        perimeter(rhombuses);
        perimeter(other);
    }
}
