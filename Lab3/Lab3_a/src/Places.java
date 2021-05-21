public final class Places
{
    private final int common;
    private final int compartment;
    private final int reservedSeat;
    private final int luxury;

    public Places(int common,
                  int compartment,
                  int reservedSeat,
                  int luxury)
    {
        this.common = common;
        this.compartment = compartment;
        this.reservedSeat = reservedSeat;
        this.luxury = luxury;
    }

    public Places()
    {
        this(0, 0, 0, 0);
    }

    public int getCommon()
    {
        return common;
    }

    public int getCompartment()
    {
        return compartment;
    }

    public int getReservedSeat()
    {
        return reservedSeat;
    }

    public int getLuxury()
    {
        return luxury;
    }

    @Override
    public String toString()
    {
        return "Места[" +
                "общие=" + common +
                ", купе=" + compartment +
                ", плацкарт=" + reservedSeat +
                ", люкс=" + luxury +
                ']';
    }
}
