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

import exceptions.InvalidTransportDataException;

public class Bus extends Transportation {

	// Attributes
	private String busCompany;
	private int numberofStops;

	
	// Parameterized constructor
	public Bus(String companyName, String departureCity, String arrivalCity, String busCompany, int numberofStops) throws InvalidTransportDataException {
		super(companyName, departureCity, arrivalCity);
		this.busCompany = busCompany;
		setNumberofStops(numberofStops);
	}

	// parameterized constructor with transportId for loading from file
	public Bus(String transportId, String companyName, String departureCity, String arrivalCity, double price, int numberofStops) throws InvalidTransportDataException{
		super(transportId, companyName, departureCity, arrivalCity, price);
		setNumberofStops(numberofStops); 
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

	public void setNumberofStops(int numberofStops) throws InvalidTransportDataException {
		if (numberofStops < 1) 
			throw new InvalidTransportDataException("A bus must have at least 1 stop.");
		this.numberofStops = numberofStops;
	}

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
	public String toCsvRow() {
    	return "BUS" + getTransportId() + ";" +
           getCompanyName() + ";" +
           getDepartureCity() + ";" +
           getArrivalCity() + ";" +
           getPrice() + ";" +
           numberofStops;
	}


	public static Bus fromCsvRow(String line) throws InvalidTransportDataException {
    String[] parts = line.split(";");

    return new Bus(
        parts[1], parts[2], parts[3], parts[4], 
        Double.parseDouble(parts[5]),
        Integer.parseInt(parts[6])
    );
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
