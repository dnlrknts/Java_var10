public class Animal
{
    protected String name;
    public Animal(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;

        Animal animal = (Animal) o;

        return name.equals(animal.name);
    }

    @Override
    public int hashCode()
    {
        int result = name.hashCode();
        return result+15;
    }

    @Override
    public String toString()
    {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

    void printName()
    {
        System.out.println(name);
    }
}
