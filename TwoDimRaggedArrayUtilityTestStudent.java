/*
 * Class: CMSC203 
 * Instructor:Khandan Monshi
 * Description: The code in general reads data from a file , manipulates and writes data to another file
 * Due: 04/02/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: ____Joel Mbah______
*/

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TwoDimRaggedArrayUtilityTestStudent {
    
    private double[][] dataSet1;
    
    @Before
    public void setUp() throws Exception {
        // Initializing the dataset for testing
        dataSet1 = new double[][] {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetRowTotal() {
        assertEquals(9.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 1), 0.001);
    }
    @Test
    public void testGetColumnTotal() {
        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 2), 0.001);
    }

    @Test
    public void testGetTotal() {
        assertEquals(45.0, TwoDimRaggedArrayUtility.getTotal(dataSet1), 0.001);
    }

    @Test
    public void testGetAverage() {
        assertEquals(5.0, TwoDimRaggedArrayUtility.getAverage(dataSet1), 0.001);
    }

    @Test
    public void testGetHighestInRow() {
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 2), 0.001);
    }

    @Test
    public void testGetHighestInRowIndex() {
        assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 1));
    }

    @Test
    public void testGetLowestInRow() {
        assertEquals(6.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 2), 0.001);
    }

    @Test
    public void testGetLowestInRowIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 2));
    }

    @Test
    public void testGetHighestInColumn() {
        assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 2), 0.001);
    }

    @Test
    public void testGetHighestInColumnIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 2));
    }

    @Test
    public void testGetLowestInColumn() {
        assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 1), 0.001);
    }

    @Test
    public void testGetLowestInColumnIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 1));
    }

    @Test
    public void testGetHighestInArray() {
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet1), 0.001);
    }

    @Test
    public void testGetLowestInArray() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet1), 0.001);
    }

    @Test
    public void testReadFile() throws FileNotFoundException {
        
        File testFile = new File("test.txt");
        assertTrue("File does not exist", testFile.exists());
        double[][] result = TwoDimRaggedArrayUtility.readFile(testFile);
        assertNotNull("Result is null", result);
        assertEquals("Incorrect number of rows", 3, result.length);
        
    }

    @Test
    public void testWriteToFile() throws FileNotFoundException {
        File testFile = new File("output.txt");
        TwoDimRaggedArrayUtility.writeToFile(dataSet1, testFile);
        assertTrue(testFile.exists());
    }
}