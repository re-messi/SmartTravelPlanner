package travel;

public class Bus extends Transportation {

	// Attributes
	private String busCompany;
	private int numberofStops;

	
	public Bus() {
		this.busCompany = "";
		this.numberofStops = 0;
	}

	public Bus(String companyName, String departureCity, String arrivalCity, String busCompany, int numberofStops) {
		super(companyName, departureCity, arrivalCity);
		this.busCompany = busCompany;
		this.numberofStops = numberofStops;
	}

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

	@Override //WILL NEED TO CHANGE THIS
	public double calculateCost(int numberOfDays) {
		return numberOfDays * 30; // Placeholder cost calculation, can be modified based on busCompany and numberofStops
	}

	@Override
	public String toString() {
		return "Bus: " + 
			"\n" + super.toString() + 
			"\n Bus Company: " + busCompany +
			"\n Number of Stops: " + numberofStops;
	}

	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == null)
	        return false;

	    if (getClass() != otherObject.getClass())
	        return false;
		
		Bus other = (Bus) otherObject;

	    	return super.equals(other) &&
	    			this.busCompany.equals(other.busCompany) && 
	    			this.numberofStops == other.numberofStops;

	 }

}
