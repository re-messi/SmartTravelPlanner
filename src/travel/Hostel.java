//-----------------------------------------------------
// Assignment 2
// Written by: Rebecca Messier (40338041) and Taminda Ait Ouazzou (40344517)
//
// This class represents a hostel accommodation in the
// SmartTravel system. It extends Accommodation and
// includes the number of shared beds per room.
//-----------------------------------------------------
package travel;

public class Hostel extends Accommodation {


	// Attributes
	private int sharedBedsPerRoom;

	// Default constructor
	public Hostel() {
		super();
		this.sharedBedsPerRoom = 0;
	}

	// Parameterized constructor
	public Hostel(String name, String location, double pricePerNight, int sharedBedsPerRoom) {
		super(name, location, pricePerNight);
		this.sharedBedsPerRoom = sharedBedsPerRoom;
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
	// Cost calculation based on price per night and number of days
	public double calculateCost(int numberOfDays) {
		return getPricePerNight() * numberOfDays; // Cost based on price per night and number of days
	}

	@Override
	public Accommodation copy() {
    return new Hostel(this);
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
