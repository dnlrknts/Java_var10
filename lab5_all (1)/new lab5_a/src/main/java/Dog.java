public class Dog extends Animal
{
    protected String breed;

    public Dog(String name, String breed)
    {
        super(name);
        this.breed = breed;
    }

    void jump()
    {
        System.out.println("Dog : "+ breed + " : "+ name + " jumps");
    }
    void run()
    {
        System.out.println("Dog : "+ breed + " : " + name + " runs");
    }
    void bite()
    {
        System.out.println("Dog : "+ breed + " : " + name + " bites");
    }

    void say()
    {
        System.out.println("Dog : "+ breed + " : "+ " says woof");
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Dog)) return false;
        if (!super.equals(o)) return false;

        Dog dog = (Dog) o;

        return breed.equals(dog.breed);
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + breed.hashCode();
        return result;
    }

    public String getBreed()
    {
        return breed;
    }

    @Override
    public String toString()
    {
        return "Dog{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
}
