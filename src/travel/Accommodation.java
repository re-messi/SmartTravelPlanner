//-----------------------------------------------------
// Assignment 2
// Written by: Rebecca Messier (40338041) and Taminda Ait Ouazzou (40344517)
//
// This abstract class represents an accommodation
// option in the SmartTravel system. It stores common
// attributes such as name, location, and price per
// night, and is extended by Hotel and Hostel.
//-----------------------------------------------------
package travel;

import exceptions.InvalidAccommodationDataException;

public abstract class Accommodation {

	

	// Attributes
	private String accommodationID;
	private String name;
	private String location;
	private double pricePerNight;
	private static int nextAccommodationNum = 4001;  


	// Method to generate an accommodation ID
	private static String generateAccommodationID(){
		return "A" + nextAccommodationNum++;
	}


	// Default constructor : creates invalid objects
	

	// Parameterized constructor
	public Accommodation(String name, String location, double pricePerNight) throws InvalidAccommodationDataException {
		this.accommodationID = generateAccommodationID();
		this.name = name;
		this.location =location;
		setPricePerNight(pricePerNight);
	}


	// Copy constructor 
	public Accommodation(Accommodation other){
		this.accommodationID = generateAccommodationID();
		this.name = other.name;
		this.location = other.location;
		this.pricePerNight = other.pricePerNight;
	}


	// Accessors
	public String getName(){
		return name;
	}

	public String getLocation(){
		return location;
	}

	public double getPricePerNight(){
		return pricePerNight;
	}

	public String getAccommodationID(){
		return accommodationID;
	}


	// Mutators
	public void setName(String name){
		this.name = name;
	}

	public void setLocation(String location){
		this.location = location; 
	}

	public void setPricePerNight(double pricePerNight) throws InvalidAccommodationDataException {
		if (pricePerNight <= 0) 
			throw new InvalidAccommodationDataException("Price per night must be a positive value.");
		this.pricePerNight = pricePerNight;
	}


	// Method will be used to calculate the total trip cost (overriden by subclasses)
	public abstract double calculateCost(int numberOfDays);

	// Returns a deep copy of the object using copy constructors
	public abstract Accommodation copy();

	// Printing description of object
	@Override
	public String toString(){
		return "Accommodation ID: " + accommodationID + 
				"\nName: " + name + 
				"\nLocation: " + location + 
				"\nPrice per night: " + pricePerNight;
	}


	// Compare two objects 
	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == null)
	        return false;

	    if (getClass() != otherObject.getClass())
	        return false;

		Accommodation other = (Accommodation) otherObject;

			return  this.name.equalsIgnoreCase(other.name) && 
					this.location.equalsIgnoreCase(other.location) &&
					this.pricePerNight == other.pricePerNight;
	
	}



}
