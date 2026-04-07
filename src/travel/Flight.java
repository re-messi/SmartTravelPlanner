//-----------------------------------------------------
// Assignment 2
// Written by: Rebecca Messier (40338041) and Taminda Ait Ouazzou (40344517)
//
// This class represents a flight transportation option
// in the SmartTravel system. It extends Transportation
// and stores information such as airline name and
// luggage allowance.
//-----------------------------------------------------
package travel;

import exceptions.InvalidTransportDataException;

public class Flight extends Transportation {

	// Attributes
	private String airlineName;
	private double luggageAllowanceKg;
	

	// Parameterized constructor
	public Flight(String companyName, String departureCity, String arrivalCity, String airlineName, double luggageAllowanceKg) throws InvalidTransportDataException {
		super(companyName, departureCity, arrivalCity);
		this.airlineName = airlineName;
		setLuggageAllowanceKg(luggageAllowanceKg);
	}

	// parameterized constructor with transportationID for loeading from file
	public Flight (String transportId, String companyName, String departureCity, String arrivalCity, double price, String airlineName, double luggageAllowanceKg) throws InvalidTransportDataException{
		super(transportId,companyName, departureCity, arrivalCity, price);
		setLuggageAllowanceKg(luggageAllowanceKg);
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

	public void setLuggageAllowanceKg(double luggageAllowanceKg) throws InvalidTransportDataException {
		if (luggageAllowanceKg < 0) 
			throw new InvalidTransportDataException("Luggage allowance cannot be negative.");
		this.luggageAllowanceKg = luggageAllowanceKg;
	}

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
	public String toCsvRow() {
    	return "FLIGHT;" + getTransportId() + ";" +
           getCompanyName() + ";" +
           getDepartureCity() + ";" +
           getArrivalCity() + ";" +
           getPrice() + ";" +
           airlineName + ";" +
           luggageAllowanceKg;
	}

	public static Flight fromCsvRow(String line) throws InvalidTransportDataException {
    String[] parts = line.split(";");

    return new Flight(
        parts[1],
        parts[2],
        parts[3],
        parts[4],
        Double.parseDouble(parts[5]),
		parts[6],
        Double.parseDouble(parts[7])
    );
}

	@Override
	// Returns a string representation of the Flight
	public String toString() {
		return "Flight: " + 
			"\n" + super.toString() + 
			"\nAirline Name: " + getAirlineName() +
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
