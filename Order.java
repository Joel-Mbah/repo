
/*
 * Class: CMSC203 
 * Instructor:Khandan Monshi
 * Description: This is the Order class, with methods that help the customer order
 * Due: 05/13/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Joel Mbah________
*/


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order extends Object implements OrderInterface, Comparable<Order> {
	private int orderTime;
	private int orderNo;
	private List<Beverage> beverages;
	private Day orderDay;
	private Customer cust;
	
	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = new Customer(cust);
		this.beverages = new ArrayList<>();
	}
	
	public int generateOrder() {
		Random rand = new Random();
		return rand.nextInt(90000 - 10000 + 1) + 10000;
	}
	
	public int getOrderNo()
	{
		return orderNo;
	}
	
	public int getOrderTime() {
		return orderTime;
	}
	
	public Day getOrderDay() {
		return orderDay;
	}
	
	public Customer getCustomer() {
		return cust;
	}
	
	@Override
	public boolean isWeekend() {
		return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
	}
	
	@Override
	public Beverage getBeverage(int itemNo) {
		if(itemNo >= 0 && itemNo < beverages.size()) {
			return beverages.get(itemNo);
		}
		return null;
	}
	
	public int getTotalItems() {
		return beverages.size();
	}
	
	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Beverage coffee = new Coffee(bevName, size, extraShot, extraSyrup);
		beverages.add(coffee);
	}
	
	@Override
	public void addNewBeverage(String bevName, Size size) {
		Beverage alcohol = new Alcohol(bevName, size);
		beverages.add(alcohol);
	}
	
	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Beverage smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
		beverages.add(smoothie);
	}
	
	@Override 
	public double calcOrderTotal() {
		double total = 0;
		for(Beverage b: beverages)
			total += b.calcPrice();
		return total;
	}
	
	@Override 
	public int findNumOfBeveType(Type type) {
		int count = 0;
		for(Beverage b: beverages) {
			if (b.getType() == type)
				count++;
		}
		return count;
	}
	
	@Override 
	public String toString() {
		 StringBuilder sb = new StringBuilder();
	        sb.append("Order Number: ").append(orderNo)
	          .append(", Time: ").append(orderTime)
	          .append(", Day: ").append(orderDay)
	          .append(", Customer: ").append(cust.getName())
	          .append(", Age: ").append(cust.getAge()).append("\n");

	        for (Beverage b : beverages) {
	            sb.append("  ").append(b.toString()).append("\n");
	        }

	        sb.append("Total Price: $").append(String.format("%.2f", calcOrderTotal()));
	        return sb.toString();
	}
	
	@Override
	public int compareTo(Order anotherOrder) {
		if(this.getOrderNo() == anotherOrder.getOrderNo()) {
			return 0;
		}
		else if (anotherOrder.getOrderNo() > this.getOrderNo()) {
			return 1;
		}
		else
			return -1;
	}
}
