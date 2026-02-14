package travel;

public class Train extends Transportation {

	// Attributes

	private String trainType; 
	private String seatClass;

	@Override
	public Transportation copy() {
		return new Train(this);
	}
	
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

	@Override
	public double calculateCost(int numberOfDays) {
	
	}

	@Override
	public String toString() {
		return "Train: " + 
			"\n" + super.toString() + 
			"\n Train Type: " + trainType +
			"\n Seat Class: " + seatClass;
	}

	@Override
	public boolean equals(Train otherObject) {
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
