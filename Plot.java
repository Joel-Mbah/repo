/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This class inherits some methods from the object class and also just takes and sets basic plot details
 * Due: 04/23/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: __Joel Mbah________
*/

public class Plot extends Object {
	private int depth;
	private int width;
	private int x;
	private int y;
	
	public Plot() {
		this.width = 1;
		this.depth = 1;
	}
	
	public Plot (int x, int y, int width, int depth) {
		this.width = width;
		this.depth = depth;
		this.x = x;
		this.y = y;
	}
	
	public Plot(Plot otherPlot) {
		this(otherPlot.getX(), otherPlot.getY(), otherPlot.getWidth(), otherPlot.getDepth());
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getDepth() {
		return depth;
	}
	
	public boolean overlaps(Plot plot) {
	        // Check if one rectangle is to the left of the other
	       if (this.x + this.width <= plot.x || plot.x + plot.width <= this.x) {
	           return false;
	       }

	        // Check if one rectangle is above the other
	       if (this.y + this.depth <= plot.y || plot.y + plot.depth <= this.y) {
	           return false;
	       }

	       return true; //if the above conditions are nit met then they should be overlapping
	   }
	

	public boolean encompasses(Plot plot) {
	    return (plot.x >= this.x &&
	            plot.y >= this.y &&
	            plot.x + plot.width <= this.x + this.width &&
	            plot.y + plot.depth <= this.y + this.depth);
	}

	
	@Override 
	public String toString() {
		return(getX()+ "," + getY()+ ","+ getWidth() +"," +getDepth());
	}

}
