/*
 * Class: CMSC203 
 * Instructor:Khandan Monshi
 * Description: This is the j unit test for the Alcohol class
 * Due: 05/13/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Joel Mbah________
*/



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlcoholTestStudent {

    private Alcohol weekendAlcohol;
    private Alcohol weekdayAlcohol;

    @BeforeEach
    public void setUp() {
        weekendAlcohol = new Alcohol("Wine", Size.LARGE, true);
        weekdayAlcohol = new Alcohol("Wine", Size.LARGE, false);
    }

    @Test
    public void testCalcPriceWeekend() {
        // base = 2.0, size = LARGE (+0.5 * 2), weekend = +0.6
        assertEquals(3.6, weekendAlcohol.calcPrice(), 0.01);
    }

    @Test
    public void testCalcPriceWeekday() {
        // base = 2.0, size = LARGE (+0.5 * 2), no weekend charge
        assertEquals(3.0, weekdayAlcohol.calcPrice(), 0.01);
    }

    @Test
    public void testEqualsTrue() {
        Alcohol another = new Alcohol("Wine", Size.LARGE, true);
        assertTrue(weekendAlcohol.equals(another));
    }

    @Test
    public void testEqualsFalse_DifferentWeekend() {
        assertFalse(weekendAlcohol.equals(weekdayAlcohol));
    }

    @Test
    public void testEqualsFalse_DifferentSize() {
        Alcohol differentSize = new Alcohol("Wine", Size.MEDIUM, true);
        assertFalse(weekendAlcohol.equals(differentSize));
    }

    @Test
    public void testToStringContainsCorrectInfo() {
        String output = weekendAlcohol.toString();
        assertTrue(output.contains("Wine"));
        assertTrue(output.contains("LARGE"));
        assertTrue(output.contains("true"));
        assertTrue(output.contains("3.60"));
    }

    @Test
    public void testIsWeekendGetter() {
        assertTrue(weekendAlcohol.isWeekend());
        assertFalse(weekdayAlcohol.isWeekend());
    }
}
