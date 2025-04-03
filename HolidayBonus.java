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


public class HolidayBonus {
	static final double HIGHEST_SALE =5000.0;
	static final double LOWEST_SALE = 1000.0;
	static final double ALL_OTHERS = 2000.0;
	
	public HolidayBonus()
	{
		
	}
	
	public static double[] calculateHolidayBonus(double[][] data)
	{
		if (data == null || data.length == 0)
		{
		    throw new IllegalArgumentException("The array you just passed is empty.");
		}

		
		int stores = data.length;
		
		double[]  holidayArray = new double[stores];
		
		for (int row = 0; row < data.length; row++)
		{
			double storeBonus = 0.0;
			for(int col = 0; col < data[row].length; col++)
			{
				if (data[row][col] <= 0)
				{
					storeBonus += 0.0;
				}
				else if(data[row][col] == TwoDimRaggedArrayUtility.getHighestInColumn(data, col))
				{
					storeBonus += HIGHEST_SALE;
				}
				else if(data[row][col] == TwoDimRaggedArrayUtility.getLowestInColumn(data, col))
				{
					storeBonus += LOWEST_SALE;
				}
				else
				{
					storeBonus += ALL_OTHERS;
				}
			}
			
			holidayArray[row] = storeBonus;
		}
		return holidayArray;
	}
	
	public static double calculateTotalHolidayBonus(double[][] data)
	{
		double totalBonus = 0.0;
		double[] newArray = new double[data.length];
		if (data == null || data.length == 0)
		{
		    throw new IllegalArgumentException("The array you just passed is empty.");
		}
		
		
		
			newArray = HolidayBonus.calculateHolidayBonus(data);
		
		for(int j = 0; j < newArray.length; j++)
		{
			totalBonus += newArray[j];
		}
		return totalBonus;
	}
	

}
