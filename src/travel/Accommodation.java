//-----------------------------------------------------
// Assignment 1
// COMP 249 – Object-Oriented Programming II
// Written by: Rebecca Messier (40338041) and Taminda Ait Ouazzou (Student ID)
//
// This abstract class represents an accommodation
// option in the SmartTravel system. It stores common
// attributes such as name, location, and price per
// night, and is extended by Hotel and Hostel.
//-----------------------------------------------------
package travel;

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


	// Default constructor 
	public Accommodation() {
		this.accommodationID = generateAccommodationID();
		this.name = "";
		this.location = "";
		this.pricePerNight = 0.0;
	}
	

	// Parameterized constructor
	public Accommodation(String name, String location, double pricePerNight) {
		this.accommodationID = generateAccommodationID();
		this.name = name;
		this.location =location;
		this.pricePerNight = pricePerNight;
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

	public String getNextAccommodationID(){
		return accommodationID;
	}


	// Mutators
	public void setName(String name){
		this.name = name;
	}

	public void setLocation(String location){
		this.location = location; 
	}

	public void setPricePerNight(double pricePerNight){
		this.pricePerNight = pricePerNight;
	}


	// Method will be used to calculate the total trip cost (overriden by subclasses)
	public abstract double calculateCost(int numberOfDays);


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
