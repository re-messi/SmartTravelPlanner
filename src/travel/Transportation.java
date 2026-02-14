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
	
	public void setCompanyName() { this.companyName = companyName; }
	
	public void setDepartureCity() { this.departureCity = departureCity; }
	
	public void setArrivalCity() { this.arrivalCity = arrivalCity; }
	
	
	// Abstract methods (implemented by subclasses)
	public abstract double calculateCost(int numberOfDays);
		
	public abstract Transportation copy();
	
	@Override
	public String toString() {
		return "Transport ID: " + transportId +
				"\n Company Name: " + companyName +
				"\n Departure City: " + departureCity +
				"\n Arrival City: " + arrivalCity;
	}
	
	@Override
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
