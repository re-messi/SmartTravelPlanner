package travel;

public class Bus extends Transportation {

	// Attributes
	private String busCompany;
	private String numberofStops;

	@Override
	public Transportation copy() {
		return new Bus(this);
	}
	
	public Bus() {
		this.busCompany = "";
		this.numberofStops = "";
	}

	public Bus(String companyName, String departureCity, String arrivalCity, String busCompany, String numberofStops) {
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

	public String getNumberofStops() { return numberofStops; }
	
	// Mutators
	public void setBusCompany(String busCompany) { this.busCompany = busCompany; }

	public void setNumberofStops(String numberofStops) { this.numberofStops = numberofStops; }

	@Override
	public double calculateCost(int numberOfDays) {
		//need to figure this out
	}

	@Override
	public String toString() {
		return "Bus: " + 
			"\n" + super.toString() + 
			"\n Bus Company: " + busCompany +
			"\n Number of Stops: " + numberofStops;
	}

	@Override
	public boolean equals(Bus otherObject) {
		if (otherObject == null)
	        return false;

	    if (getClass() != otherObject.getClass())
	        return false;
		
		Bus other = (Bus) otherObject;

	    	return super.equals(other) &&
	    			this.busCompany.equals(other.busCompany) && 
	    			this.numberofStops.equals(other.numberofStops);

}


