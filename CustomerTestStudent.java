/*
 * Class: CMSC203 
 * Instructor:Khandan Monshi
 * Description: This is the j unit test for the customer class
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

public class CustomerTestStudent {

    @Test
    public void testConstructor() {
        Customer customer = new Customer("John Doe", 25);
        assertEquals("John Doe", customer.getName());
        assertEquals(25, customer.getAge());
    }

    @Test
    public void testCopyConstructor() {
        Customer original = new Customer("Jane Smith", 30);
        Customer copy = new Customer(original);

        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getAge(), copy.getAge());
        assertNotSame(original, copy);  // Ensures it's a new object
    }

    @Test
    public void testSettersAndGetters() {
        Customer customer = new Customer("Alice", 20);

        // Test setName and getName
        customer.setName("Bob");
        assertEquals("Bob", customer.getName());

        // Test setAge and getAge
        customer.setAge(35);
        assertEquals(35, customer.getAge());
    }

    @Test
    public void testToString() {
        Customer customer = new Customer("Charlie", 40);
        String result = customer.toString();

        assertTrue(result.contains("Charlie"));
        assertTrue(result.contains("40"));
    }

}
