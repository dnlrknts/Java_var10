package d2;

public record Point2D(double x, double y)
{
    @Override
    public String toString()
    {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
