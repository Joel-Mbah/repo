
/*
 * Class: CMSC203 
 * Instructor:Khandan Monshi
 * Description: This is the j unit test for the Beverage class
 * Due: 05/13/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Joel Mbah________
*/


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BeverageTestStudent {

    @Test
    public void testGetters() {
        Beverage alcohol = new Alcohol("Beer", Size.SMALL, false);

        assertEquals("Beer", alcohol.getBevName());
        assertEquals(Type.ALCOHOL, alcohol.getType());
        assertEquals(Size.SMALL, alcohol.getSize());
    }

    @Test
    public void testAddSizePrice() {
        Beverage small = new Alcohol("Beer", Size.SMALL, false);
        Beverage medium = new Alcohol("Beer", Size.MEDIUM, false);
        Beverage large = new Alcohol("Beer", Size.LARGE, false);

        assertEquals(2.0, small.addSizePrice(), 0.01);
        assertEquals(2.5, medium.addSizePrice(), 0.01);
        assertEquals(3.0, large.addSizePrice(), 0.01);
    }

    @Test
    public void testToString() {
        Beverage alcohol = new Alcohol("Whiskey", Size.MEDIUM, true);
        String result = alcohol.toString();

        assertTrue(result.contains("Whiskey"));
        assertTrue(result.contains("MEDIUM"));
    }

    @Test
    public void testEquals() {
        Beverage a1 = new Alcohol("Beer", Size.SMALL, false);
        Beverage a2 = new Alcohol("Beer", Size.SMALL, false);
        Beverage a3 = new Alcohol("Wine", Size.SMALL, false);

        assertTrue(a1.equals(a2));
        assertFalse(a1.equals(a3));
    }
}
