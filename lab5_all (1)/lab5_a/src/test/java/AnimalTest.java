import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AnimalTest
{
    private Animal animal;
    @BeforeEach
    public void setUp()
    {
        animal = new Animal("Mike");
    }

    @Test
    @DisplayName("Test Hash code")
    public void testHashCode() {
        assertNotEquals(0, animal.hashCode());
    }

    @Test
    @DisplayName("Test toString")
    public void testToString() {
        assertNotEquals(" ", animal.toString());
    }

    @Test
    @DisplayName("Test Name")
    public void testName() {
        assertEquals("Mike", animal.getName());
    }

}
