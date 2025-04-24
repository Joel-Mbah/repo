/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This class makes practice of aggregation and inheritance as it takes a parameter of type Plot
 * Due: 04/23/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: __Joel Mbah________
*/
public class Property extends Object{
	private String city;
	private String owner;
	private Plot plot;
	private String propertyName;
	private double rentAmount;
	
	public Property() {
		this.plot = new Plot();
		
	}
	
	public Property(String propertyName, String city, 
					double rentAmount,String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot();
	}
	public Property(String propertyName, String city,double rentAmount,
					String owner, int x, int y, int width, int depth){
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot(x,y,width,depth);
		
	}
	
	public Property(Property otherProperty) {
		this.propertyName = otherProperty.getPropertyName();
		this.city = otherProperty.getCity();
		this.rentAmount = otherProperty.getRentAmount();
		this.owner = otherProperty.getOwner();
		
		this.plot = new Plot();
	}
	
	
	public Plot getPlot() {
		return plot;
	}
	
	public String getPropertyName() {
		return this.propertyName;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public double getRentAmount() {
		return this.rentAmount;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	@Override
	public String toString() {
		return(getPropertyName() + "," + getCity()+ "," +
				getOwner()+ "," + getRentAmount());
	}

}
