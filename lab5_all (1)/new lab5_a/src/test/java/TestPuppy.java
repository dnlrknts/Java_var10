import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestPuppy
{
    private Puppy puppy;
    private ByteArrayOutputStream out;
    private final String  breed = "Mongrel";
    private final String name = "Mike";
    private final String ls = "\r\n";
    @BeforeEach
    public void setUp()
    {
        out = new ByteArrayOutputStream();
        // устанавливаем системный вывод в буфер в памяти
        System.setOut(new PrintStream(out));
        puppy = new Puppy("Mike", "Mongrel");
    }

    @Test
    @DisplayName("Test jump")
    void jump()
    {
        puppy.jump();
        assertEquals("Puppy : " + breed + " : " + name + " jumps"+ls, out.toString());
    }

    @Test
    @DisplayName("Test run")
    void run()
    {
        puppy.run();
        assertEquals("Puppy : " + breed + " : " + name + " runs"+ls, out.toString());
    }

    @Test
    @DisplayName("Test bite")
    void bite()
    {
        puppy.bite();
        assertEquals("Puppy : " + breed + " : " + name + " bites"+ls, out.toString());
    }

    @Test
    @DisplayName("Test say")
    void say()
    {
        puppy.say();
        assertEquals("Puppy : " + breed + " : " + name + " : says woof"+ls, out.toString());
    }

    @Test
    @DisplayName("Test Hash code")
    public void testHashCode()
    {
        assertNotEquals(0, puppy.hashCode());
    }

    @Test
    @DisplayName("Test toString")
    public void testToString()
    {
        assertNotEquals(" ", puppy.toString());
    }

    @Test
    @DisplayName("Test Name")
    public void testName()
    {
        assertEquals("Mike", puppy.getName());
    }

    @Test
    @DisplayName("Test Name")
    public void testBreed()
    {
        assertEquals("Mongrel", puppy.getBreed());
    }
}
