/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This is the main method with three other methods that creates new objects and display the info
 * Due:02/26/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Joel Mbah_________
*/


import java.util.Scanner;
import java.text.DecimalFormat;
public class PatientDriverApp
{

	public static void main(String[] args)
	{
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter patient's first name: ");
		String userFirstName = keyboard.nextLine();
		System.out.println("Enter patient's middle name: ");
		String userMiddleName = keyboard.nextLine();
		System.out.println("Enter patient's last name: ");
		String userLastName = keyboard.nextLine();
		System.out.println("Enter patient's street address: ");
		String userStreetAddress = keyboard.nextLine();
		System.out.println("Enter patient's City: ");
		String userCity = keyboard.nextLine();
		System.out.println("Enter patient's State: ");
		String userState = keyboard.nextLine();
		System.out.println("Enter patient's ZipCode: ");
		String userZipCode = keyboard.nextLine();
		System.out.println("Enter patient's contact: ");
		String userContact = keyboard.nextLine();
		System.out.println("Enter patient's emergency contact's name: ");
		String userEmergencyName = keyboard.nextLine();
		System.out.println("Enter emergency contact's phone number: ");
		String userEmergencyContact = keyboard.nextLine();
		
		System.out.println("Enter the name of patient's procedure: ");
		String userProcedureName = keyboard.nextLine();
		System.out.println("Enter the date of the patient's procedure: ");
		String userProcedureDate = keyboard.nextLine();
		System.out.println("Enter the physician's name: ");
		String userProcedurePractitioner = keyboard.nextLine();
		System.out.println("Enter the charge: ");
		double userCharge = keyboard.nextDouble();
		keyboard.nextLine();
		
		
		System.out.println("Enter the name of patient's procedure: ");
		String userProcedureName2 = keyboard.nextLine();
		System.out.println("Enter the date of the patient's procedure: ");
		String userProcedureDate2 = keyboard.nextLine();
		System.out.println("Enter the physician's name: ");
		String userProcedurePractitioner2 = keyboard.nextLine();
		System.out.println("Enter the charge: ");
		double userCharge2 = keyboard.nextDouble();
		keyboard.nextLine();
		
		//Procedure procedure = new Procedure(userProcedureName2, userProcedureDate2);
		System.out.println("Enter the name of patient's procedure: ");
		String userProcedureName3 = keyboard.nextLine();
		System.out.println("Enter the date of the patient's procedure: ");
		String userProcedureDate3 = keyboard.nextLine();
		System.out.println("Enter the physician's name: ");
		String userProcedurePractitioner3 = keyboard.nextLine();
		System.out.println("Enter the charge: ");
		double userCharge3 = keyboard.nextDouble();
		
		
		//creating a patient instance
		Patient patientInfo = new Patient(userFirstName, userMiddleName, userLastName, userStreetAddress,
										userCity, userState, userZipCode, userContact, userEmergencyName ,userEmergencyContact );
		
		displayPatient(patientInfo);		
		
		//creating an instance of the procedure class
		Procedure procedure1 = new Procedure();
		procedure1.setProcedureName(userProcedureName);
		procedure1.setProcedureDate(userProcedureDate);
		procedure1.setProcedurePractitioner(userProcedurePractitioner);
		procedure1.setProcdureCharges(userCharge);
		
		System.out.println("");
		displayProcedure(procedure1);
		
		Procedure procedure2 = new Procedure(userProcedureName2, userProcedureDate2);
		procedure2.setProcedurePractitioner(userProcedurePractitioner2);
		procedure2.setProcdureCharges(userCharge2);
		
		System.out.println("");
		displayProcedure(procedure2);
		
		System.out.println("");
		Procedure procedure3 = new Procedure(userProcedureName3, userProcedureDate3, userProcedurePractitioner3, userCharge3);
		displayProcedure(procedure3);
		System.out.println("");
		
		double totalCharge = calculateTotalCharges(userCharge, userCharge2, userCharge3);
		DecimalFormat df = new DecimalFormat("#,###.00");
		String total = df.format(totalCharge);
		System.out.println("Total charges: $" + total);
		
		System.out.println("");
		System.out.println("Student Name: Joel Mbah");
		System.out.println("MC#: M21186138");
		System.out.println("Due date: 02/26/2025");

		
	}
	
	//method for display patient info
	public static void displayPatient(Patient patientInfo)
	{
		System.out.println("Patient Info: ");
		System.out.println(" " + "Name: " + patientInfo.buildFullName());
		System.out.println(" " + "Address: " + patientInfo.buildAddress() );
		System.out.println(" " + "Emergency Contact: " + patientInfo.buildEmergencyContact());
		
		
	}
	
	//method for displaying the procedures
	public static void displayProcedure(Procedure procedure)
	{
		System.out.println("\t" + "Procedure: " + procedure.getProcedureName());
		System.out.println("\t" + "Procedure Date: " + procedure.getProcedureDate());
		System.out.println("\t" + "Practitioner: " + procedure.getProcedurePractioner());
		System.out.println("\t" + "Charge = " + procedure.getProcedureCharges());
	}
	
	//method for displaying the total charge
	public static double calculateTotalCharges(double c1, double c2, double c3)
	{
		double sum = c1+c2+c3;
		return sum;
	}
	

}
