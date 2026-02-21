//-----------------------------------------------------
// Assignment 1
// COMP 249 – Object-Oriented Programming II
// Written by: Rebecca Messier (40338041) and Taminda Ait Ouazzou (Student ID)
//
// This abstract class represents a general transportation
// option in the SmartTravel system. It stores common
// information such as company name, departure city,
// and arrival city, and is extended by Train, Flight,
// and Bus classes.
//-----------------------------------------------------
package travel;

public abstract class Transportation {

	// Attributes
	private String transportId;
	private String companyName;
	private String departureCity;
	private String arrivalCity;
	private static int nextTransportNum = 3001;
	
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
	
	// Parameterized constructor 
	public Transportation(String companyName, String departureCity, String arrivalCity) {
		this.transportId = generateTransportId();
		this.companyName = companyName;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
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
