//-----------------------------------------------------
// Assignment 2
// Written by: Rebecca Messier (40338041) and Taminda Ait Ouazzou (40344517)
//
// This class represents a bus transportation option
// in the SmartTravel system. It extends Transportation
// and includes details such as bus company and
// number of stops.
//-----------------------------------------------------
package travel;

public class Bus extends Transportation {

	// Attributes
	private String busCompany;
	private int numberofStops;

	// Default constructor
	public Bus() {
		super();
		this.busCompany = "";
		this.numberofStops = 0;
	}
	// Parameterized constructor
	public Bus(String companyName, String departureCity, String arrivalCity, String busCompany, int numberofStops) {
		super(companyName, departureCity, arrivalCity);
		this.busCompany = busCompany;
		this.numberofStops = numberofStops;
	}
	// Copy constructor
	public Bus(Bus other) {
		super(other);
		this.busCompany = other.busCompany;
		this.numberofStops = other.numberofStops;
	}

	// Accessors 
	public String getBusCompany() { return busCompany; }

	public int getNumberofStops() { return numberofStops; }
	
	// Mutators
	public void setBusCompany(String busCompany) { this.busCompany = busCompany; }

	public void setNumberofStops(int numberofStops) { this.numberofStops = numberofStops; }

	@Override
	//Returns the cost of the bus transportation 
	public double calculateCost(int numberOfDays) {
     // Base bus cost + small increase per stop + per-day factor
    	return 30.0 + (numberofStops * 5.0) + (numberOfDays * 5.0);
}
	@Override
	public Transportation copy() {
    return new Bus(this);
}

	@Override
	// Returns a string representation of the Bus
	public String toString() {
		return "Bus: " + 
			"\n" + super.toString() + 
			"\nBus Company: " + busCompany +
			"\nNumber of Stops: " + numberofStops;
	}

	@Override
	// Checks equality between Buses
	public boolean equals(Object otherObject) {
		if (otherObject == null)
	        return false;

	    if (getClass() != otherObject.getClass())
	        return false;

		if (!super.equals(otherObject)) // compare parent attributes first
    		return false;
		
		Bus other = (Bus) otherObject;

	    	return  this.busCompany.equals(other.busCompany) && 
	    			this.numberofStops == other.numberofStops;

	 }

}
