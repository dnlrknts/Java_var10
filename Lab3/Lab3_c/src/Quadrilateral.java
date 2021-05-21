import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import static java.lang.Math.*;

public final class Quadrilateral
{
    private final Point p1;
    private final Point p2;
    private final Point p3;
    private final Point p4;
    private final double area;
    private final double perimeter;
    private final Type type;

    private static boolean almostEqual(double a, double b){
        return Math.abs(a-b)<1E-7;
    }

    private static double getArea(Point p1, Point p2, Point p3, Point p4)
    {
        double[] X = new double[]{p1.x(),p2.x(),p3.x(),p4.x()};
        double[] Y = new double[]{p1.y(),p2.y(),p3.y(),p4.y()};
        int n =4;
        double area = 0.0;

        // Calculate value of shoelace formula
        int j = n - 1;
        for (int i = 0; i < n; i++)
        {
            area += (X[j] + X[i]) * (Y[j] - Y[i]);
            // j is previous vertex to i
            j = i;
        }
        return abs(0.5*area);
    }
    private static double dist(Point p1, Point p2)
    {
        return sqrt(pow(p1.x()- p2.x(),2)+pow(p1.y()-p2.y(),2));
    }
    private static double getPerimeter(Point p1, Point p2, Point p3, Point p4)
    {
        List<Double> list = Arrays.asList(getDists(p1,p2,p3,p4));
        return switch (getType(p1,p2,p3,p4))
        {
            case Arbitrary,Rectangle,Square -> list.subList(0,4)
                    .stream()
                    .mapToDouble(Double::doubleValue)
                    .sum();
            case Rhombus -> list.subList(1,5)
                    .stream()
                    .mapToDouble(Double::doubleValue)
                    .sum();
        };
    }
    private static Double[] getDists(Point p1, Point p2, Point p3, Point p4)
    {
        return Arrays.asList(dist(p1,p2),dist(p2,p3),dist(p3,p4),dist(p4,p1),dist(p1,p3),dist(p2,p4))
                .stream()
                .sorted()
                .toArray(Double[]::new);
    }
    private static boolean isSquare(Point p1, Point p2, Point p3, Point p4)
    {
        Double[] dists = getDists(p1,p2,p3,p4);
        return almostEqual(dists[0],dists[3])&&almostEqual(dists[4],dists[5]);
    }
    private static boolean isRectangle(Point p1,Point p2,Point p3,Point p4)
    {
        Double[] dists = getDists(p1,p2,p3,p4);
        return almostEqual(dists[0],dists[1])&&
                almostEqual(dists[2],dists[3])&&
                almostEqual(dists[4],dists[5]);
    }
    private static boolean isRhombus(Point p1,Point p2,Point p3,Point p4)
    {
        Double[] dists = getDists(p1,p2,p3,p4);
        return almostEqual(dists[1],dists[2])&&
                almostEqual(dists[3],dists[4])&&
                almostEqual(dists[1],dists[4]);
    }

    private static Type getType(Point p1, Point p2, Point p3, Point p4)
    {
        if(isSquare(p1,p2,p3,p4))
            return Type.Square;
        else if(isRhombus(p1,p2,p3,p4))
            return Type.Rhombus;
        else if(isRectangle(p1,p2,p3,p4))
            return Type.Rectangle;
        return Type.Arbitrary;
    }

    public Quadrilateral(Point p1, Point p2, Point p3, Point p4)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        area = getArea(p1,p2,p3,p4);
        perimeter = getPerimeter(p1,p2,p3,p4);
        type = getType(p1,p2,p3,p4);

    }

    public Point getP1()
    {
        return p1;
    }

    public Point getP2()
    {
        return p2;
    }

    public Point getP3()
    {
        return p3;
    }

    public Point getP4()
    {
        return p4;
    }

    public double getArea()
    {
        return area;
    }

    public double getPerimeter()
    {
        return perimeter;
    }

    public Type getType()
    {
        return type;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Quadrilateral) obj;
        return Objects.equals(this.p1, that.p1) &&
                Objects.equals(this.p2, that.p2) &&
                Objects.equals(this.p3, that.p3) &&
                Objects.equals(this.p4, that.p4);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(p1, p2, p3, p4);
    }

    @Override
    public String toString()
    {
        return "Quadrilateral[" +
                "area=" + area +
                ", perimeter=" + perimeter +
                ", type=" + type +
                ']';
    }

    public enum Type
    {
        Square,
        Rectangle,
        Rhombus,
        Arbitrary
    }
}
