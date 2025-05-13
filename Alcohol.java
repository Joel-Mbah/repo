/*
 * Class: CMSC203 
 * Instructor:Khandan Monshi
 * Description: This is the Alcohol class which initializes and creates alcohol objects
 * Due: 05/13/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Joel Mbah________
*/


public class Alcohol extends Beverage{
	private boolean isWeekend;
	private final double WEEKEND_COST = 0.6;
	
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
	public Alcohol (String bevName, Size size) {
		super(bevName, Type.ALCOHOL, size);
	}
	
	@Override
	public double calcPrice() {
		double price = addSizePrice();
		if(isWeekend)
			price += WEEKEND_COST;
		
		return price;
	}
	
	@Override 
	public String toString() {
		return super.toString() + isWeekend  + String.format("%.2f", calcPrice());
	}
	
	@Override 
	public boolean equals(Object anotherBev) {
		if (anotherBev instanceof Alcohol) {
			Alcohol temporary = (Alcohol)anotherBev;
			return super.equals(anotherBev)  && this.isWeekend == temporary.isWeekend;
		}
		else
			return false;
	}
	
	public boolean isWeekend() {
		return isWeekend;
	}

}
