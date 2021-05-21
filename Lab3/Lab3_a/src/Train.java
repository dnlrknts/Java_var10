import java.util.Date;

public class Train
{
    private final String dest;
    private final int id;
    private final Date departure;
    private final Places places;
    public Train()
    {
        dest="";
        id=0;
        departure=new Date(0);
        places=new Places();
    }
    public Train(String dest, int id, Date departure, Places places)
    {
        this.dest = dest;
        this.id = id;
        this.departure = departure;
        this.places = places;
    }

    public String getDest()
    {
        return dest;
    }

    public int getId()
    {
        return id;
    }

    public Date getDeparture()
    {
        return departure;
    }

    public Places getPlaces()
    {
        return places;
    }

    @Override
    public String toString()
    {
        return "Поезд[" +
                "пункт назначения : " + dest + '\'' +
                ", номер : " + id +
                ", время отправления : " + departure +
                ", места : " + places +
                ']';
    }

}
