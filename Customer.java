/*
 * Class: CMSC203 
 * Instructor:Khandan Monshi
 * Description: This is the Customer class
 * Due: 05/13/2025
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: __Joel Mbah________
*/



public class Customer extends Object {
	private int age;
	private String name;
	
	public Customer (String name, int age) {
		this.name =name;
		this.age = age;
	}
	
	public Customer(Customer c) {//copy constructor
		this.name = c.name;
		this.age  = c.age;
	}
	
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override 
	public String toString() {
		return ( name + age );
	}

}
