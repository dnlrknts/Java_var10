public class Puppy extends Dog
{
    public Puppy(String name, String breed)
    {
        super(name, breed);
    }

    @Override
    void run()
    {
        System.out.println("Puppy : "+ breed + " : "+ name + " runs");
    }
    @Override
    void bite()
    {
        System.out.println("Puppy : "+ breed + " : " + name + " bites");
    }

    @Override
    void jump()
    {
        System.out.println("Puppy : "+ breed + " : " + name + " jumps");
    }

    @Override
    void say()
    {
        System.out.println("Puppy : " + breed + " : " + name + " : says woof");
    }

    @Override
    public String toString()
    {
        return "Puppy{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
}
