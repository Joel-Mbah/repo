/*
 * Class: CMSC203 
 * Instructor:Khandan Monshi
 * Description: This is the j unit test for the Coffee class
 * Due: 05/13/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Joel Mbah________
*/



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoffeeTestStudent {

    @Test
    public void testConstructorAndGetters() {
        Coffee coffee = new Coffee("Latte", Size.MEDIUM, true, false);
        assertEquals("Latte", coffee.getBevName());
        assertEquals(Type.COFFEE, coffee.getType());
        assertEquals(Size.MEDIUM, coffee.getSize());
        assertTrue(coffee.getExtraShot());
        assertFalse(coffee.getExtraSyrup());
    }

    @Test
    public void testCalcPrice() {
        // Base = 2.0, Medium = +0.5, Shot = +0.5, Syrup = +0.5
        Coffee smallPlain = new Coffee("Black", Size.SMALL, false, false);
        assertEquals(2.0, smallPlain.calcPrice(), 0.01);

        Coffee mediumShot = new Coffee("Black", Size.MEDIUM, true, false);
        assertEquals(3.0, mediumShot.calcPrice(), 0.01); // 2.0 + 0.5 + 0.5

        Coffee largeBoth = new Coffee("Black", Size.LARGE, true, true);
        assertEquals(3.0 + 0.5 + 0.5, largeBoth.calcPrice(), 0.01); // 2.0 + 1.0 + 0.5 + 0.5 = 4.0
    }

    @Test
    public void testToStringContainsKeyInfo() {
        Coffee coffee = new Coffee("Mocha", Size.SMALL, true, true);
        String result = coffee.toString();
        assertTrue(result.contains("Mocha"));
        assertTrue(result.contains("SMALL"));
        assertTrue(result.contains("true")); // extraShot and extraSyrup both true
        assertTrue(result.contains(String.format("%.1f", coffee.calcPrice())));
    }

    @Test
    public void testEquals() {
        Coffee coffee1 = new Coffee("Espresso", Size.SMALL, true, false);
        Coffee coffee2 = new Coffee("Espresso", Size.SMALL, true, false);
        Coffee coffee3 = new Coffee("Espresso", Size.LARGE, true, false);
        Coffee coffee4 = new Coffee("Espresso", Size.SMALL, false, false);

        assertEquals(coffee1, coffee2);
        assertNotEquals(coffee1, coffee3);
        assertNotEquals(coffee1, coffee4);
    }
}
