
/*
 * Class: CMSC203 
 * Instructor:Khandan Monshi
 * Description: This is the beverage class which is the super class of alcohol, coffee and smoothie
 * Due: 05/13/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Joel Mbah________
*/


public abstract class Beverage extends Object {
	private String bevName;
	private Type type;
	private Size size;
	final double BASE_PRICE = 2.0;
	final double SIZE_PRICE = 0.5;
	
	public Beverage(String bevName, Type type, Size size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
		//Beverage b = new Beverage(bevName, type, size);
	}
	
	
	
	public double getBasePrice() {
		return BASE_PRICE;
	}
	
	public Type getType() {
		return type;
	}
	public String getBevName() {
		return bevName;
	}
	public Size getSize() {
		return size;
	}
	
	public double addSizePrice() {
		switch(size) {
		case MEDIUM: // to hold medium size
		{
			return BASE_PRICE + SIZE_PRICE;
		}
		case LARGE: // large size
		{
			return BASE_PRICE + 2 * SIZE_PRICE;
		}
		default: //returns the base price if the size is Small
			return BASE_PRICE;
		}
	}
	@Override
	public String toString() {
		return (this.bevName + "," + this.size);
	}
	
	@Override 
	public boolean equals(Object anotherBev) {
		Beverage temp = (Beverage)anotherBev;
		return (this.bevName.equals(temp.bevName) && this.type.equals(temp.type) && this.size.equals(temp.size));
		
	}
	public abstract double calcPrice();

}
