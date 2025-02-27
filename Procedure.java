/*
Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This class gets the details of the procedures and creates a class and fields to manipulate the procedures
 * Due:02/26/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Joel Mbah_________
*/


public class Procedure
{
	private String procedureName; // field to store the name of the procedure 
	private String procedureDate; // field for the date of the procedure
	private String procedurePractitioner; // field for the practitioner who peformed out the procedure
	private double procedureCharges; // field for the charge of the procedure
	
	//no arg constructor
	public Procedure()
	{
		
	}
	
	//constructor with parameters name and date
	public Procedure (String procedureName, String procedureDate)
	{
		this.procedureName = procedureName;
		this.procedureDate = procedureDate;
	}
	
	//constructor that initializes all attributes to their given values
	public Procedure (String procedureName, String procedureDate, String procedurePractitioner, double procedureCharges)
	{
		this.procedureName = procedureName;
		this.procedureDate = procedureDate;
		this.procedurePractitioner = procedurePractitioner;
		this.procedureCharges = procedureCharges;
	}
	
	//accessors for the attributes
	public String getProcedureName()
	{
		return procedureName;
	}
	public String getProcedureDate()
	{
		return procedureDate;
	}
	public String getProcedurePractioner()
	{
		return procedurePractitioner;
	}
	public double getProcedureCharges()
	{
		return procedureCharges;
	}
	
	//mutators for each attribute
	public void setProcedureName(String procedureName)
	{
		this.procedureName = procedureName;
	}
	public void  setProcedureDate(String procedureDate)
	{
		this.procedureDate = procedureDate;
	}
	public void setProcedurePractitioner(String procedurePractitioner)
	{
		this.procedurePractitioner = procedurePractitioner;
	}
	public void setProcdureCharges(double procedureCharges)
	{
		this.procedureCharges = procedureCharges;
	}
	
	//method that displays the info
	public String toString()
	{
		return "\t" + ("Procedure: "+ procedureName + "\n")+
				"\t" + ("Procedure Date: " + procedureDate + "\n")+
				"\t" + ("Practitioner: " + procedurePractitioner + "\n")+
				"\t" + ("Charge: " + procedureCharges + "\n");
	}
	
}
