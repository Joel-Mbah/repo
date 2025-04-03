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

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class TwoDimRaggedArrayUtility
{
	private static final int MAX_ROW = 10; // constant to hold the max number of rows
    private static final int MAX_COLUMN = 10; //constant to hold the max number of columns
    
	public TwoDimRaggedArrayUtility()
	{
		
	}
	

	    public static double[][] readFile(File file) throws FileNotFoundException {
	        String[][] tempArray = new String[MAX_ROW][MAX_COLUMN];

	        Scanner scanner = new Scanner(file);

	        // Read from file into tempArray
	        int row = 0;
	        while (scanner.hasNextLine() && row < MAX_ROW) {
	            String[] elements = scanner.nextLine().split(" ");
	            for (int col = 0; col < elements.length && col < MAX_COLUMN; col++) {
	                tempArray[row][col] = elements[col];
	            }
	            row++;
	        }
	        scanner.close();

	        // Check if the file is empty
	        if (row == 0) {
	            return null;
	        }

	        // Create the ragged array based on rows
	        double[][] array = new double[row][];

	        for (int i = 0; i < row; i++) {
	            int columnCount = 0;
	            for (int j = 0; j < MAX_COLUMN; j++) {
	                if (tempArray[i][j] != null) {
	                    columnCount++;
	                }
	            }

	            array[i] = new double[columnCount];

	            for (int j = 0; j < columnCount; j++) {
	                array[i][j] = Double.parseDouble(tempArray[i][j]);
	            }
	        }

	        return array;
	    }
	    
	    
	    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
	    	PrintWriter writer = new PrintWriter(outputFile);
	    	for (int i = 0; i < data.length; i++)
	    	{
	                double[] row = data[i];

	                for (int j = 0; j < row.length; j++) {
	                    writer.print(row[j]);
	                    if (j < row.length - 1) {
	                        writer.print(" "); // This adds an empty space between the doubles
	                    }
	                }
	                writer.println(); // This takes the cursor to the next line for each row
	            }

	            writer.close();
	        }
	    
	    public static double getTotal(double[][] data)
	    {
	    	double sum = 0.0;
	    	for(int row = 0; row < data.length; row++ )
	    	{
	    		for(int col = 0; col < data[row].length; col++)
	    		{
	    			sum += data[row][col];
	    		}
	    	}
	    	return sum;
	    }
	    
	    public static double getAverage(double[][] data)
	    {
	    	
	    	
	    	double average = 0.0; // initialization of the average 
	    	double sum = 0.0;  // to hold the sum
	    	int numOfElements = 0;  // initialization of the total number of elements
	    	
//	    	if (data == null || data.length == 0) {
//	            return 0.0;  // If there's no data, return 0 as the average.
//	        }
	    	for(int row = 0; row < data.length; row++ )
	    	{
	    		for(int col = 0; col < data[row].length; col++)
	    		{
	    			sum += data[row][col];
	    			numOfElements++;
	    		}
	    	}
	    	
	    	if(numOfElements == 0)
	    	{
	    		average = 0.0; // using this statement to set the average to 0 if the number of elements is 0 so I dont get division by 0
	    	}
	    	else
	    	{
	    		average = sum/numOfElements;
	    	}
	    	return average;
	    	
	    }
	    
	    public static double getRowTotal(double[][] data,int row)
	    {
	    	double rowSum = 0.0;  // to hold the sum of the rows
	    	if (row >= 0 && row < data.length)
	    	{
	    		for (int col = 0; col < data[row].length; col++)
	    		{
	    			rowSum += data[row][col];
	    		}
	    	}	
	    	else 
	    	{
	    		throw new IllegalArgumentException("Number of Rows should be greater than or equal to 0");
	    	}
	    	return rowSum;
	    }
	    	
	    public static double getColumnTotal(double[][] data,int col)
	    {
	    	double colSum = 0.0;  // to hold the sum of the colimns
	    		for (int row = 0; row < data.length; row++)
	    		{
	    			if (col >= 0 && col< data[row].length)
	    				colSum += data[row][col];
	    		}
	    	return colSum;
	    }
	    
	    public static double getHighestInRow(double[][] data,int row)
	    {
	    	double largestRow = data[row][0]; // starting largest value of the array
	    	if (row >= 0 && row < data.length)
	    	{
	    		for(int col = 1; col < data[row].length;col++ )
		    	{
		    		if ( data[row][col] > largestRow )
		    		{
		    			largestRow = data[row][col];
		    		}
		    	}
	    	}
	    	else
	    		throw new IllegalArgumentException("The number of rows entered is Invalid");
	    	return largestRow;
	    }
	    
	    public static int getHighestInRowIndex(double[][] data,int row)
	    {
	    	int highestRowIndex = 0; // to hold the index of the rows
	    	double largestRow = data[row][0]; // to hold and find the largest value in a specific row
	    	if (row >= 0 && row < data.length)
	    	{
	    		for(int col = 1; col < data[row].length;col++ )
		    	{
		    		if ( data[row][col] > largestRow )
		    		{
		    			largestRow = data[row][col];
		    			highestRowIndex = col;
		    		}
		    	}
	    	}
	    	else
	    		throw new IllegalArgumentException("The number of rows entered is Invalid");
	    	return highestRowIndex;
	    }
	    
	    public static double getLowestInRow(double[][] data, int row)
	    {
	    	double smallestRow = data[row][0]; // to hold the smallest value in the row 
	    	if (row >= 0 && row < data.length)
	    	{
	    		for(int col = 1; col < data[row].length;col++ )
		    	{
		    		if ( data[row][col] < smallestRow )
		    		{
		    			smallestRow = data[row][col]; // loop through the array to find the smallest value in the array
		    		}
		    	}
	    	}
	    	else
	    		throw new IllegalArgumentException("The number of rows entered is Invalid");
	    	return smallestRow;
	    }
	    
	    
	    public static int getLowestInRowIndex(double[][] data,int row)
	    {
	    	int lowestRowIndex = 0; //to hold the row index
	    	double smallestRow = data[row][0]; // to hold the smallest value in a specific row
	    	if (row >= 0 && row < data.length)
	    	{
	    		for(int col = 1; col < data[row].length;col++ )
		    	{
		    		if ( data[row][col] < smallestRow )
		    		{
		    			smallestRow = data[row][col]; // looping through to find the smallest value in the array, then getting the index of that value
		    			lowestRowIndex = col;
		    		}
		    	}
	    	}
	    	else
	    		throw new IllegalArgumentException("The number of rows entered is Invalid");
	    	return lowestRowIndex;
	    	
	    }
	    
	    
	    public static double getHighestInColumn(double[][] data,int col)
	    {
	    	double highestCol = data[0][col]; //double to hold the highest value in a specific column in the array
	    
	    	for (int row = 1; row < data.length; row++)
    		{
    			if (col >= 0 && col < data[row].length)
    			{
    				if(data[row][col] > highestCol)
    				{
    					highestCol = data[row][col];   // looping through to find the highest value in a specific column
    				}
    			}
    		}
	    	return highestCol;
	    }
	    
	    
	    public static int getHighestInColumnIndex(double[][] data,int col)
	    {
	    	double highestCol = data[0][col]; //double to hold the highest value in a specific column in the array
		    int highestColIndex = 0; // to hold the index of the highest column
	    	for (int row = 1; row < data.length; row++)
    		{
    			if (col >= 0 && col < data[row].length)
    			{
    				if(data[row][col] > highestCol)
    				{
    					highestCol = data[row][col];// looping through to find the highest value in a specific column
    					highestColIndex = row; // finding and storing the value of the index with the highest column
    				}
    			}
    		}
	    	return highestColIndex;
	    }
	    
	    public static double getLowestInColumn(double[][] data,int col)
	    {
	    	double lowestCol = Double.POSITIVE_INFINITY; //assigning the largest possible value to the lowestCol
		    
	    	for (int row = 0; row < data.length; row++)
    		{
    			if (col >= 0 && col < data[row].length)
    			{
    				if(data[row][col] < lowestCol)
    				{
    					lowestCol = data[row][col]; 
    				}
    			}
    		}
	    	return lowestCol;
	    }
	    
	    
	    public static int getLowestInColumnIndex(double[][] data, int col)
	    {
	    	double lowestCol = Double.POSITIVE_INFINITY; //assigning the largest possible value to the lowestCol
		    int lowestColIndex = -1; //assigning the lowest col index to -1 so that if there is no value in the first index i wouldn't rely on it
	    	for (int row = 0; row < data.length; row++)
    		{
    			if (col >= 0 && col < data[row].length)
    			{
    				if(data[row][col] < lowestCol)
    				{
    					lowestCol = data[row][col]; 
    					lowestColIndex = row;
    				}
    			}
    		}
	    	return lowestColIndex;
	    }
	    
	    public static double getHighestInArray(double[][] data)
	    {
	    	double highestInArray = Double.NEGATIVE_INFINITY;
	    	for(int row = 0; row < data.length; row++)
	    	{
	    		for(int col = 0; col < data[row].length;  col++)
	    		{
	    			if(data[row][col] > highestInArray)
	    			{
	    				highestInArray = data[row][col];
	    			}
	    		}
	    	}
	    	return highestInArray;
	    	
	    }
	    
	    public static double getLowestInArray(double[][] data)
	    {
	    	double lowestInArray = Double.POSITIVE_INFINITY; //assigning the smallest value to a very large number so that when I loop through, the first index becomes the smallest
	    	for(int row = 0; row < data.length; row++)
	    	{
	    		for(int col = 0; col < data[row].length; col++)
	    		{
	    			if (data[row][col] < lowestInArray)
	    			{
	    				lowestInArray = data[row][col];
	    			}
	    		}
	    	}
	    	return lowestInArray;
	    }


}
