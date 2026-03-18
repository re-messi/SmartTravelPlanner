//-----------------------------------------------------
// Assignment 2
// Written by: Rebecca Messier (40338041) and Taminda Ait Ouazzou (40344517)	
//
// This class represents a client in the SmartTravel
// system. It stores basic client information such as
// first name, last name, and email address.
//-----------------------------------------------------
package client;

import exceptions.InvalidClientDataException;

public class Client {

	//Attributes
	private String clientID;
	private String firstName;
	private String lastName;
	private String email;
	private static int nextClientNum = 1001; 
	
	//helper method to generate IDs
	private static String generateClientID() {
		return "C" + (nextClientNum++);
	}
	
	//default constructor : no use, only placeholder data which would use up a clientID
	
	
	//parameterized constructor
	public Client(String firstName, String lastName, String email) throws InvalidClientDataException {
		this.clientID = generateClientID();
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
	}
	
	//copy constructor
	public Client(Client other) {
		this.clientID = generateClientID();  
    	this.firstName = other.firstName;
   	 	this.lastName = other.lastName;
    	this.email = other.email;
	}
	
	//Accessors
	public String getClientId() {return clientID;}
	
	public String getFirstName() {return firstName;}
	
	public String getLastName() {return lastName;}
	
	public String getEmail() {return email;}
	
	//Mutators
	public void setFirstName(String firstName) throws InvalidClientDataException {
    if (firstName == null || firstName.trim().isEmpty())
        throw new InvalidClientDataException("First name cannot be empty.");
    if (firstName.length() > 50)
        throw new InvalidClientDataException("First name exceeds 50 characters.");
    this.firstName = firstName;
	}

	public void setLastName(String lastName) throws InvalidClientDataException {
    if (lastName == null || lastName.trim().isEmpty())
        throw new InvalidClientDataException("Last name cannot be empty.");
    if (lastName.length() > 50)
        throw new InvalidClientDataException("Last name exceeds 50 characters.");
    this.lastName = lastName;
	}
	
	public void setEmail(String email) throws InvalidClientDataException {
    if (email == null)
    	throw new InvalidClientDataException("Email cannot be null.");
	if (email.length() > 100)
    	throw new InvalidClientDataException("Email exceeds 100 characters.");
	if (!email.contains("@") || !email.contains(".") || email.contains(" "))
    	throw new InvalidClientDataException("Invalid email format.");
    this.email = email;
	}

	//toString method
	@Override
	public String toString() {
		return "ClientID: " + clientID + 
				"\nName: " + firstName + " " + lastName + 
				"\nEmail: " + email;
	}
	
	//equals
	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == null)
			return false;
		else if(getClass() !=otherObject.getClass())
			return false;
		
		Client other = (Client) otherObject;
		
		return firstName.equals(other.firstName)
				&& lastName.equals(other.lastName)
				&& email.equals(other.email);	
	}

	
}
