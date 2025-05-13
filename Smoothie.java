/*
 * Class: CMSC203 
 * Instructor:Khandan Monshi
 * Description: This is the Smoothie class, a sub class of the Beverage class
 * Due: 05/13/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Joel Mbah________
*/



public class Smoothie extends Beverage{
	private int numOfFruits;
	private boolean addProtein;
	private final double ADDITIONAL_PROTEIN = 1.5;
	private final double ADDITIONAL_FRUIT =0.5;
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		super(bevName, Type.SMOOTHIE,size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
		
	}
	
	public int getNumOfFruits() {
		return numOfFruits;
	}
	
	public boolean getAddProtein() {
		return addProtein;
	}
	
	@Override 
	public double calcPrice() {
		double price = addSizePrice() + (getNumOfFruits() * ADDITIONAL_FRUIT);
		if(getAddProtein()) {
			price += ADDITIONAL_PROTEIN;
		}
		return price;
	}
	
	@Override 
	public String toString() {
		return (super.toString() + ", " + getAddProtein() +
				", "+ getNumOfFruits() + ", " + calcPrice() );
	}
	
	@Override
	public boolean equals(Object anotherBev) {
		if(anotherBev instanceof Smoothie) {
			Smoothie temp = (Smoothie)anotherBev;
		return (super.equals(anotherBev) && this.getNumOfFruits() == temp.getNumOfFruits() &&
				this.getAddProtein() == temp.getAddProtein());
		}
		else
			return false;
	}

}
