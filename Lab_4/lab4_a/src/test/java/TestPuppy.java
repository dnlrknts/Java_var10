import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestPuppy
{
        private Puppy puppy;
        @BeforeEach
        public void setUp()
        {
            puppy = new Puppy("Mike","Mongrel");
        }

        @Test
        @DisplayName("Test Hash code")
        public void testHashCode() {
            assertNotEquals(0, puppy.hashCode());
        }

        @Test
        @DisplayName("Test toString")
        public void testToString() {
            assertNotEquals(" ", puppy.toString());
        }

        @Test
        @DisplayName("Test Name")
        public void testName() {
            assertEquals("Mike", puppy.getName());
        }

        @Test
        @DisplayName("Test Name")
        public void testBreed() {
            assertEquals("Mongrel", puppy.getBreed());
        }
}
