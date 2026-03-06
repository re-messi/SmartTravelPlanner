//-----------------------------------------------------
// Assignment 1
// Written by: Rebecca Messier (40338041) and Taminda Ait Ouazzou (40344517)
//
// This class represents a train transportation option
// in the SmartTravel system. It extends Transportation
// and includes specific details such as train type
// and seat class.
//-----------------------------------------------------
package travel;

public class Train extends Transportation {

	// Attributes
	private String trainType; 
	private String seatClass;

	// Default constructor
	public Train() {
		this.trainType = "";
		this.seatClass = "";
	}
	// Parameterized constructor
	public Train(String companyName, String departureCity, String arrivalCity, String trainType, String seatClass) {
		super(companyName, departureCity, arrivalCity);
		this.trainType = trainType;
		this.seatClass = seatClass;
	}
	// Copy constructor
	public Train(Train other) {
		super(other);
		this.trainType = other.trainType;
		this.seatClass = other.seatClass;
	}

	// Accessors 
	public String getTrainType() { return trainType; }

	public String getSeatClass() { return seatClass; }
	
	// Mutators
	public void setTrainType(String trainType) { this.trainType = trainType; }

	public void setSeatClass(String seatClass) { this.seatClass = seatClass; }

	@Override
	public double calculateCost(int numberOfDays) {
		double base = 50.0;
		// Adjust cost based on seat class
		if (seatClass != null) {
			if (seatClass.equalsIgnoreCase("First")) {
				base += 20.0; } 
			else if (seatClass.equalsIgnoreCase("Business")) {
				base += 15.0;} 
			else if (seatClass.equalsIgnoreCase("Second")) {
				base += 10.0; }
		} return base + (numberOfDays * 10.0);
	}
		
	@Override
	public Transportation copy() {
    return new Train(this);
}
	
	@Override
	// Returns a string representation of the Train
	public String toString() {
		return "Train: " + 
			"\n" + super.toString() + 
			"\nTrain Type: " + trainType +
			"\nSeat Class: " + seatClass;
	}

	@Override
	// Checks equality between Trains
	public boolean equals(Object otherObject) {
		if (otherObject == null)
	        return false;

	    if (getClass() != otherObject.getClass())
	        return false;

		if (!super.equals(otherObject)) // compare parent attributes first
    		return false;
	    
	    Train other = (Train) otherObject;
		
	    	return  this.trainType.equals(other.trainType) &&
	    			this.seatClass.equals(other.seatClass);
	}

}
