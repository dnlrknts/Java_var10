import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DogTest
{
    private Dog dog;
    @BeforeEach
    public void setUp()
    {
        dog = new Dog("Mike","Mongrel");
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
