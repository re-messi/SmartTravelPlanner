//-----------------------------------------------------
// Assignment 2
// Written by: Rebecca Messier (40338041) and Taminda Ait Ouazzou (40344517)
//
// This class represents a hostel accommodation in the
// SmartTravel system. It extends Accommodation and
// includes the number of shared beds per room.
//-----------------------------------------------------
package travel;

import exceptions.InvalidAccommodationDataException;

public class Hostel extends Accommodation {


	// Attributes
	private int sharedBedsPerRoom;


	// Parameterized constructor
	public Hostel(String name, String location, double pricePerNight, int sharedBedsPerRoom) throws InvalidAccommodationDataException {
		super(name, location, pricePerNight);
		this.sharedBedsPerRoom = sharedBedsPerRoom;
		setPricePerNight(pricePerNight); 
	}


	// parameterized constructor with accommodationID for loading from file 
	public Hostel(String accommodationID, String name, String location, double pricePerNight, int sharedBeds) throws InvalidAccommodationDataException {
    	super(accommodationID, name, location, pricePerNight);
   		this.sharedBedsPerRoom = sharedBeds;
	}

	// Copy constructor
	public Hostel(Hostel other) {
		super(other);
		this.sharedBedsPerRoom = other.sharedBedsPerRoom;
	}

	// Accessor
	public int getSharedBedsPerRoom() {
		return sharedBedsPerRoom;
	}

	// Mutator
	public void setSharedBedsPerRoom(int sharedBedsPerRoom) {
		this.sharedBedsPerRoom = sharedBedsPerRoom;
	}

	@Override
	public void setPricePerNight(double pricePerNight)
        throws InvalidAccommodationDataException {
    if (pricePerNight <= 0)
        throw new InvalidAccommodationDataException("Price per night must be > 0.");
    if (pricePerNight > 150)
        throw new InvalidAccommodationDataException("Hostel price cannot exceed 150.");
    super.setPricePerNight(pricePerNight);
}

	@Override
	// Cost calculation based on price per night and number of days
	public double calculateCost(int numberOfDays) {
		return getPricePerNight() * numberOfDays; // Cost based on price per night and number of days
	}

	@Override
	public Accommodation copy() {
    return new Hostel(this);
}

	@Override
	public String toCsvRow() {
    	return "HOSTEL;" + getAccommodationID() + ";" +
           	getName() + ";" +
           	getLocation() + ";" +
           	getPricePerNight() + ";" +
           	sharedBedsPerRoom;
	}

	public static Hostel fromCsvRow(String line) throws InvalidAccommodationDataException {
    	String[] parts = line.split(";");

    	return new Hostel(
        	parts[1],parts[2],parts[3],
        	Double.parseDouble(parts[4]),
        	Integer.parseInt(parts[5])
    	);
	}

	@Override
	// Returns a string representation of the Hostel
	public String toString() {
		return "Hostel: " + 
			"\n" + super.toString() +
			"\nShared Beds per Room: " + sharedBedsPerRoom;
	}

	@Override
	// Checks equality between Hostels
	public boolean equals(Object otherObject) {
		if (otherObject == null)
	        return false;

	    if (getClass() != otherObject.getClass())
				return false;

		if (!super.equals(otherObject)) // compare parent attributes first
    		return false;

		Hostel other = (Hostel) otherObject;

	    	return this.sharedBedsPerRoom == other.sharedBedsPerRoom;

	}




	
}
