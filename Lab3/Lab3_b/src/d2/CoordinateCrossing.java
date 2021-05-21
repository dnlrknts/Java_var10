package d2;

public record CoordinateCrossing(Point2D p1, Point2D p2)
{
    @Override
    public String toString()
    {
        return "CoordinateCrossing{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }
}
