/*
 * Class: CMSC203 
 * Instructor:Khandan Monshi
 * Description: This class is an implementation of BevShopInterface
 * Due: 05/13/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Joel Mbah________
*/



import java.util.ArrayList;

public class BevShop extends Object implements BevShopInterface{
	public ArrayList<Order> orders;
	private int numOfAlcohol = 0;
	private Order currentOrder;
	
	public BevShop() {
		orders = new ArrayList<>();
	}
	
	@Override
	public boolean isValidTime(int time) {
		if (time <=23 && time >= 8) {
			return true;
		}
		else 
			return false;
	}
	
	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}
	
	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	@Override
	public boolean isMaxFruit(int numOfFruits) {
		return (numOfFruits > MAX_FRUIT);
	}
	
	@Override 
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	@Override 
	public boolean isEligibleForMore() {
		return numOfAlcohol < MAX_ORDER_FOR_ALCOHOL;
	}
	
	@Override 
	public int getNumOfAlcoholDrink() {
		return numOfAlcohol;
	}
	
	@Override
	public boolean isValidAge(int age) {
		return (age > MIN_AGE_FOR_ALCOHOL);
	}
	
	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		Customer customer = new Customer (customerName, customerAge);
		currentOrder = new Order (time, day, customer);
		orders.add(currentOrder);
		numOfAlcohol = 0;
	}
	
	@Override 
	public void processCoffeeOrder(String bevName, Size size,
								boolean extraShot, boolean extraSyrup) {
		if(currentOrder != null)
			currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	
	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		if(currentOrder != null)
			currentOrder.addNewBeverage(bevName, size);
	}
	
	@Override
	public void processSmoothieOrder(String bevName, Size size,
								int numOfFruits, boolean addProtein) {
		if (currentOrder != null)
			currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
	}
	
	@Override
	public int findOrder(int orderNo) {
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getOrderNo() == orderNo)
				return i;
		}
			return -1;
	}
	
	@Override 
	public double totalOrderPrice(int orderNo) {
		for(Order order : orders) {
			if(order.getOrderNo() == orderNo)
				return order.calcOrderTotal();
		}
		return 0.0;
	}
	
	@Override
	public double totalMonthlySale() {
		double total = 0.0;
		for(Order o: orders) {
			total +=o.calcOrderTotal();
		}
		return total;
	}
	
	
	@Override
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}
	
	@Override 
	public Order getCurrentOrder() {
		return currentOrder;
	}
	
	@Override
	public Order getOrderAtIndex(int index) {
		if (index >= 0 && index < orders.size()) {
			return orders.get(index);
		}
		else
			return null;
	}
	
	@Override 
	public void sortOrders() {
		int n = orders.size();
		for(int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i+1; j < n; j++) {
				if (orders.get(j).getOrderNo() < orders.get(minIndex).getOrderNo())
					minIndex = j;
			}
		}
	}
	
	
	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Beverage Shop MOnthly Orders Summary:\n");
		sb.append("==================================\n");
		
		for (Order o : orders) {
			sb.append(o.toString()).append("\n");
		}
		sb.append("============================\n");
		sb.append("Total Monthly Sale: $").append(String.format("%.2f", totalMonthlySale()));
		return sb.toString();
	}
}
