/*
Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: This is a class with fields to initialize and control the patient information
 * Due:02/26/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: _Joel Mbah_________
*/


public class Patient
{
	private String firstName; //to hold the patient's first name
	private String middleName; //to hold middle name
	private String lastName; // to hold last name
	private String streetAddress; // to hold the patients street address
	private String city;
	private String state;
	private String zipCode;
	
	private String contact; // to hold the patients phone number
	private String emergencyName; // to hold the name of the emergency contact
	private String emergencyContact; // to hold the phone number of emergency contact
	
	
	public Patient()
	{
		
	}
	//parametrized constructor for patient's name
	public Patient(String firstName, String middleName, String lastName)
	{
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	
	//parametrized constructor that initializes all attributes of the patient
	public Patient(String firstName, String middleName, String lastName, String streetAdress,String city,
			String state, String zipCode, String contact, String emergencyName, String emergencyContact)
	{
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.streetAddress = streetAdress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.contact = contact;
		this.emergencyName = emergencyName;
		this.emergencyContact = emergencyContact;
		
	}
	
	//accessors for the attributes
	public String getFirstName()
	{
		return firstName;
	}
	public String getMiddleName()
	{
		return middleName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getStreetAddress()
	{
		return streetAddress;
	}
	public String getCity()
	{
		return city;
	}
	public String getState()
	{
		return state;
	}
	public String getZipCode()
	{
		return zipCode;
	}
	public String getContact()
	{
		return contact;
	}
	public String getEmergencyName()
	{
		return emergencyName;
	}
	public String getEmergencyContact()
	{
		return emergencyContact;
	}
	
	//mutators for the attributes
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;

	}
	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public void setStreetAddress(String streetAddress)
	{
		this.streetAddress = streetAddress;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
	public void setContact(String contact)
	{
		this.contact = contact;
	}
	public void setEmergencyName(String emergencyName)
	{
		this.emergencyName = emergencyName;
	}
	public void setmergencyContact(String emergencyContact)
	{
		this.emergencyContact = emergencyContact;
	}
	
	//method that returns full name
	public String buildFullName()
	{
		return (firstName + " " + middleName + " " + lastName);
	}
	
	//method that returns address
	public String buildAddress()
	{
		return (streetAddress + " " + city + " " + state + " " + zipCode);
	}
	
	//method that returns emergency contact
	public String buildEmergencyContact()
	{
		return (emergencyName + " " + emergencyContact);
	}
	
	public String toString()
	{
		return "Name: " + buildFullName()  +
		"/n"+"Address: " + buildAddress() +
		"/n"+ "Emergency Contact: " + buildEmergencyContact();
	}
	
	
	
}

