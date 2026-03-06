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
	
	//default constructor
	public Client() {
		clientID = generateClientID();
		firstName = "";
		lastName = "";
		email = "";	
	}
	
	//parameterized constructor
	public Client(String firstName, String lastName, String email) {
		this.clientID = generateClientID();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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
	public void setFirstName(String firstName) {this.firstName = firstName;}
	
	public void setLastName(String lastName) {this.lastName = lastName;}
	
	public void setEmail(String email) {this.email = email;}
	
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
