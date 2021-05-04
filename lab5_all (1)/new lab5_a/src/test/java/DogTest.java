import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DogTest
{
    private Dog dog;
    private ByteArrayOutputStream out;
    private final String breed = "Mongrel";
    private final String name = "Mike";
    private final String ls = "\r\n";
    @BeforeEach
    public void setUp()
    {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        dog = new Dog(name,breed);
    }
    @Test
    @DisplayName("Test jump")
    void jump()
    {
        dog.jump();
        assertEquals("Dog : "+ breed + " : "+ name + " jumps"+ls,out.toString());
    }
    @Test
    @DisplayName("Test run")
    void run()
    {
        dog.run();
        assertEquals("Dog : "+ breed + " : " + name + " runs"+ls,out.toString());
    }
    @Test
    @DisplayName("Test bite")
    void bite()
    {
        dog.bite();
        assertEquals("Dog : "+ breed + " : " + name + " bites"+ls,out.toString());
    }
    @Test
    @DisplayName("Test say")
    void say()
    {
        dog.say();
        assertEquals("Dog : "+ breed + " : "+ " says woof"+ls,out.toString());
    }
    @Test
    @DisplayName("Test Hash code")
    public void testHashCode() {
        assertNotEquals(0, dog.hashCode());
    }

    @Test
    @DisplayName("Test toString")
    public void testToString() {
        assertNotEquals(" ", dog.toString());
    }

    @Test
    @DisplayName("Test Name")
    public void testName() {
        assertEquals("Mike", dog.getName());
    }

    @Test
    @DisplayName("Test Name")
    public void testBreed() {
        assertEquals("Mongrel", dog.getBreed());
    }
}
