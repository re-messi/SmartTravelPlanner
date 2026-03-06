//-----------------------------------------------------
// Assignment 1
// Written by: Rebecca Messier (40338041) and Taminda Ait Ouazzou (40344517)
//
// This class represents a flight transportation option
// in the SmartTravel system. It extends Transportation
// and stores information such as airline name and
// luggage allowance.
//-----------------------------------------------------
package travel;

public class Flight extends Transportation {

	// Attributes
	private String airlineName;
	private double luggageAllowanceKg;
	
	
	// Default constructor
	public Flight() {
		super();
		this.airlineName = "";
		this.luggageAllowanceKg = 0.0;
	}
	// Parameterized constructor
	public Flight(String companyName, String departureCity, String arrivalCity, String airlineName, double luggageAllowanceKg) {
		super(companyName, departureCity, arrivalCity);
		this.airlineName = airlineName;
		this.luggageAllowanceKg = luggageAllowanceKg;
	}
	// Copy constructor
	public Flight(Flight other) {
		super(other);
		this.airlineName = other.airlineName;
		this.luggageAllowanceKg = other.luggageAllowanceKg;
	}

	// Accessors
	public String getAirlineName() { return airlineName; }

	public double getLuggageAllowanceKg() { return luggageAllowanceKg; }

	// Mutators

	public void setAirlineName(String airlineName) { this.airlineName = airlineName; }

	public void setLuggageAllowanceKg(double luggageAllowanceKg) { this.luggageAllowanceKg = luggageAllowanceKg; }

	@Override
	public double calculateCost(int numberOfDays) {
		// Base flight cost + luggage factor + per-day factor
		return 100.0 + (luggageAllowanceKg * 2.0) + (numberOfDays * 20.0);
	}

	@Override
	public Transportation copy() {
    return new Flight(this);
}

	@Override
	// Returns a string representation of the Flight
	public String toString() {
		return "Flight: " + 
			"\n" + super.toString() + 
			"\nAirline Name: " + airlineName +
			"\nLuggage Allowance (kg): " + luggageAllowanceKg;
	}

	@Override
	// Checks equality between Flights
	public boolean equals(Object otherObject) {
		if (otherObject == null)
	        return false;

	    if (getClass() != otherObject.getClass())
			return false;

		if (!super.equals(otherObject)) // compare parent attributes first
    		return false;

		Flight other = (Flight) otherObject;

	    return this.airlineName.equals(other.airlineName) && 
	    	   this.luggageAllowanceKg == other.luggageAllowanceKg;

	}
}
