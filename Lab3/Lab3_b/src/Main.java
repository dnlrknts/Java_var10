import d2.Line2D;
import d2.LineFactory;
import d2.Point2D;
import d2.Vector2D;

public class Main {

    public static void main(String[] args) {
        Line2D line = new Line2D(new Point2D(0,1),new Vector2D(1,1));
        System.out.println(line.getCrossing());
        System.out.println(line.getCrossing(new Line2D(new Point2D(2,0),new Vector2D(-1,1))));
        System.out.println(line.isParallelTo(new Line2D(new Point2D(0,0),new Vector2D(-1,-1))));
        LineFactory.prettyPrint(LineFactory.splitParallel(LineFactory.generate(10)));
    }
}
