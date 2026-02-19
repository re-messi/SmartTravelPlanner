package travel;

public class Flight extends Transportation {

	// Attributes
	private String airlineName;
	private double luggageAllowanceKg;
	
	
	
	public Flight() {
		super();
		this.airlineName = "";
		this.luggageAllowanceKg = 0.0;
	}

	public Flight(String companyName, String departureCity, String arrivalCity, String airlineName, double luggageAllowanceKg) {
		super(companyName, departureCity, arrivalCity);
		this.airlineName = airlineName;
		this.luggageAllowanceKg = luggageAllowanceKg;
	}

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

	@Override // WILL NEED TO CHANGE THIS
	public double calculateCost(int numberOfDays) {
		return numberOfDays * 100; // Placeholder cost calculation, can be modified based on airlineName and luggageAllowanceKg
	}

	@Override
	public String toString() {
		return "Flight: " + 
			"\n" + super.toString() + 
			"\n Airline Name: " + airlineName +
			"\n Luggage Allowance (kg): " + luggageAllowanceKg;
	}

	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == null)
	        return false;

	    if (getClass() != otherObject.getClass())
			return false;

		Flight other = (Flight) otherObject;

	    return this.airlineName.equals(other.airlineName) && 
	    	this.luggageAllowanceKg == other.luggageAllowanceKg;

	}
}
