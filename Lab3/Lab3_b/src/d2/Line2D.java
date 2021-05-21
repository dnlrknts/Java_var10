package d2;

public record Line2D(Point2D point, Vector2D vector)
{
    public CoordinateCrossing getCrossing()
    {
        return new CoordinateCrossing(new Point2D(0, point.y() - vector.ay() * point.x() / vector.ax()),
                new Point2D(point.x() - vector().ax() * point.y() / vector.ay(), 0));
    }

    public Point2D getCrossing(Line2D line)
    {
        return new Point2D((line.vector.ax() * vector.ay() * point.x() - vector.ax() * line.vector.ay() * line.point.x() - vector.ax() * line.vector.ax() * point.y() + vector.ax() * line.vector.ax() * line.point.y()) /
                (line.vector.ax() * vector.ay() - vector.ax() * line.vector.ay()),
                (vector.ay() * line.vector.ay() * point.x() - vector.ay() * line.vector.ay() * line.point.x() - vector.ax() * line.vector.ay() * point.y() + line.vector.ax() * vector.ay() * line.point.y()) /
                        (line.vector.ax() * vector.ay() - vector.ax() * line.vector.ay()));
    }
    public boolean isParallelTo(Line2D line)
    {
        return vector.ax() * line.vector.ay() - line.vector.ax()* vector().ay()==0;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Line2D)) return false;

        Line2D line2D = (Line2D) o;

        if (!point.equals(line2D.point)) return false;
        return vector.equals(line2D.vector);
    }

    @Override
    public int hashCode()
    {
        int result = point.hashCode();
        result = 31 * result + vector.hashCode();
        return result;
    }
}
