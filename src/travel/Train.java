//-----------------------------------------------------
// Assignment 1
// COMP 249 – Object-Oriented Programming II
// Written by: Rebecca Messier (40338041) and Taminda Ait Ouazzou (Student ID)
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

	
	public Train() {
		this.trainType = "";
		this.seatClass = "";
	}

	public Train(String companyName, String departureCity, String arrivalCity, String trainType, String seatClass) {
		super(companyName, departureCity, arrivalCity);
		this.trainType = trainType;
		this.seatClass = seatClass;
	}

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

	@Override //WILL NEED TO CHANGE THIS
	public double calculateCost(int numberOfDays) {
		return numberOfDays * 50; // Placeholder cost calculation, can be modified based on trainType and seatClass
	}
		
	
	@Override
	public String toString() {
		return "Train: " + 
			"\n" + super.toString() + 
			"\nTrain Type: " + trainType +
			"\nSeat Class: " + seatClass;
	}

	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == null)
	        return false;

	    if (getClass() != otherObject.getClass())
	        return false;
	    
	    Train other = (Train) otherObject;
		
	    	return super.equals(other) && 
	    			this.trainType.equals(other.trainType) &&
	    			this.seatClass.equals(other.seatClass);
	}

}
