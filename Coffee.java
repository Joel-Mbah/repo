

/*
 * Class: CMSC203 
 * Instructor:Khandan Monshi
 * Description: This is the Coffee class, a sub class of Beverage
 * Due: 05/13/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Joel Mbah________
*/

public class Coffee extends Beverage {
	private boolean extraShot;
	private boolean extraSyrup;
	private final double EXTRA_SHOT_COST = 0.5;
	private final double EXTRA_SYRUP_COST = 0.5;
	
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName, Type.COFFEE,size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	
	public boolean getExtraShot() {
		return extraShot;
	}
	
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	
	@Override
	public double calcPrice() {
		double price = addSizePrice();
		if(extraShot && extraSyrup) {
			price += (EXTRA_SHOT_COST + EXTRA_SYRUP_COST);
		}
		else if(extraShot && !extraSyrup) {
			price += EXTRA_SHOT_COST;
		}
		else if(!extraShot && extraSyrup) {
			price += EXTRA_SYRUP_COST;
		}
		else { 
			return price;
		}
		return price;
	}
	
	@Override
	public String toString() {
		return (super.toString() + extraShot + extraSyrup + calcPrice());
	}
	
	@Override 
	public boolean equals(Object anotherBev) {
		if (anotherBev instanceof Coffee) {
			Coffee temp = (Coffee)anotherBev;
			return (super.equals(anotherBev) && this.extraShot == temp.extraShot && this.extraSyrup == temp.extraSyrup);
		}
		else
			return false;
	}

}
