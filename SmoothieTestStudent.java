/*
 * Class: CMSC203 
 * Instructor:Khandan Monshi
 * Description: This is a j unit test for the Smoothie class
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

public class SmoothieTestStudent {

    @Test
    public void testConstructorAndGetters() {
        Smoothie smoothie = new Smoothie("Berry Blast", Size.MEDIUM, 3, true);

        assertEquals("Berry Blast", smoothie.getBevName());
        assertEquals(Size.MEDIUM, smoothie.getSize());
        assertEquals(Type.SMOOTHIE, smoothie.getType());
        assertEquals(3, smoothie.getNumOfFruits());
        assertTrue(smoothie.getAddProtein());
    }

    @Test
    public void testCalcPriceWithoutProtein() {
        Smoothie smoothie = new Smoothie("Fruit Mix", Size.SMALL, 2, false);
        double expected = 2.0 + (2 * 0.5);  // base + fruit cost
        assertEquals(expected, smoothie.calcPrice(), 0.01);
    }

    @Test
    public void testCalcPriceWithProtein() {
        Smoothie smoothie = new Smoothie("Tropical Boost", Size.LARGE, 4, true);
        double expected = 2.0 + (2 * 0.5) + (4 * 0.5) + 1.5;  // large + fruit + protein
        assertEquals(expected, smoothie.calcPrice(), 0.01);
    }

    @Test
    public void testEqualsMethodTrue() {
        Smoothie s1 = new Smoothie("Green Energy", Size.MEDIUM, 2, true);
        Smoothie s2 = new Smoothie("Green Energy", Size.MEDIUM, 2, true);
        assertTrue(s1.equals(s2));
    }

    @Test
    public void testEqualsMethodFalse() {
        Smoothie s1 = new Smoothie("Green Energy", Size.MEDIUM, 2, true);
        Smoothie s2 = new Smoothie("Green Energy", Size.MEDIUM, 1, false);
        assertFalse(s1.equals(s2));
    }

    @Test
    public void testToStringIncludesValues() {
        Smoothie smoothie = new Smoothie("Berry Blast", Size.SMALL, 3, true);
        String output = smoothie.toString();

        assertTrue(output.contains("Berry Blast"));
        assertTrue(output.contains("SMALL"));
        assertTrue(output.contains("true"));      // addProtein
        assertTrue(output.contains("3"));         // numOfFruits
        assertTrue(output.contains(String.format("%.1f", smoothie.calcPrice())));  // price
    }
}
