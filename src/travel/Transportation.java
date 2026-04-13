//-----------------------------------------------------
// Assignment 2
// Written by: Rebecca Messier (40338041) and Taminda Ait Ouazzou (40344517)
//
// This abstract class represents a general transportation
// option in the SmartTravel system. It stores common
// information such as company name, departure city,
// and arrival city, and is extended by Train, Flight,
// and Bus classes.
//-----------------------------------------------------
package travel;

import interfaces.*;

public abstract class Transportation implements Identifiable, CsvPersistable, Comparable<Transportation>{

	// Attributes
	private String transportId;
	private String companyName;
	private String departureCity;
	private String arrivalCity;
	private static int nextTransportNum = 3001;
	private double price;

	public double getPrice() {
    return price;
	}
	
	//Helper method to generate IDs
		private static String generateTransportId() {
			return "TR" + (nextTransportNum++); 
		}
		
	// Default constructor
	public Transportation() {
		this.transportId = generateTransportId();
		this.companyName = "";
		this.departureCity = "";
		this.arrivalCity = "";
	}

	// parameterized constructor with transportationID for loeading from file
	protected Transportation(String transportId, String companyName, String departureCity, String arrivalCity, double price){
		this.transportId = transportId;
		this.companyName = companyName;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.price = price;

	// Make sure nextAccommodationNum stays ahead
    int numericPart = Integer.parseInt(transportId.substring(2)); // remove ''
    if (numericPart >= nextTransportNum) {
        nextTransportNum = numericPart + 1;
    }
	}
	
	// Parameterized constructor 
	public Transportation(String companyName, String departureCity, String arrivalCity) {
		this.transportId = generateTransportId();
		this.companyName = companyName;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.price = 0.0;
	}
	
	// Copy Constructor
	public Transportation(Transportation other) {
		this.transportId = generateTransportId();
		this.companyName = other.companyName;
		this.departureCity = other.departureCity;
		this.arrivalCity = other.arrivalCity;
	}
	
	// Accessors
	
	public String getTransportId() { return transportId; }
	
	public String getCompanyName() { return companyName; }
	
	public String getDepartureCity() { return departureCity; }
	
	public String getArrivalCity() { return arrivalCity; }
	
	// Mutators
	
	public void setCompanyName(String companyName) { this.companyName = companyName; }
	
	public void setDepartureCity(String departureCity) { this.departureCity = departureCity; }
	
	public void setArrivalCity(String arrivalCity) { this.arrivalCity = arrivalCity; }
	
	
	// Abstract methods (implemented by subclasses)
	public abstract double calculateCost(int numberOfDays);

	// Returns a deep copy of the object using copy constructors
	public abstract Transportation copy();
		
	
	@Override
	public String getId() {
    	return getTransportId();
	}

	@Override
	public abstract String toCsvRow();

	@Override
	public int compareTo(Transportation other) {
    	return Double.compare(other.calculateCost(1), this.calculateCost(1));
	}


	public static Transportation fromCsvRow(String line) throws Exception {
    String[] p = line.split(";");

    String type = p[0];

    if (type.equals("BUS")) {
        return new Bus(
            p[1], p[2], p[3], p[4],Double.parseDouble(p[5]),Integer.parseInt(p[6]));
    }

    else if (type.equals("FLIGHT")) {
        return new Flight(
            p[1], p[2], p[3], p[4], Double.parseDouble(p[5]), p[6],Double.parseDouble(p[7]));
    }

    else if (type.equals("TRAIN")) {
        return new Train(
            p[1], p[2], p[3], p[4],Double.parseDouble(p[5]),p[6],p[7]);
    }

    throw new Exception("Unknown transport type");
}

	@Override
	// Returns a string representation of the Transportation
	public String toString() {
		return "Transport ID: " + transportId +
				"\nCompany Name: " + companyName +
				"\nDeparture City: " + departureCity +
				"\nArrival City: " + arrivalCity;
	}
	
	@Override
	// Checks equality between Transportations
	public boolean equals(Object otherObject) {
		if (otherObject == null)
	        return false;

	    if (getClass() != otherObject.getClass())
	        return false;
	    
	    Transportation other = (Transportation) otherObject;
		
	    	return this.companyName.equals(other.companyName) && 
	    			this.departureCity.equals(other.departureCity) &&
	    			this.arrivalCity.equals(other.arrivalCity);
	    
			
	    
	    
	}
	
	
}
