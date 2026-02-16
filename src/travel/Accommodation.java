package travel;

public abstract class Accommodation {

	

	// Attributes
	private String accommID;
	private String name;
	private String location;
	private double priceNight;
	private static int nextAccommodationNum = 4001;  


	// Method to generate an accommodation ID
	private static String generateAccommID(){
		return "A" + nextAccommodationNum++;
	}


	// Default constructor 
	public Accommodation() {
		this.accommID = generateAccommID();
		this.name = "";
		this.location = "";
		this.priceNight = 0.0;
	}
	

	// Parameterized constructor
	public Accommodation(String name, String location, double priceNight) {
		this.accommID = generateAccommID();
		this.name = name;
		this.location =location;
		this.priceNight = priceNight;
	}


	// Copy constructor 
	public Accommodation(Accommodation other){
		this.accommID = generateAccommID();
		this.name = other.name;
		this.location = other.location;
		this.priceNight = other.priceNight;
	}


	// Getters (Accesors)
	public String getName(){
		return name;
	}

	public String getLocation(){
		return location;
	}

	public double getPriceNight(){
		return priceNight;
	}

	public String getNextAccommID(){
		return accommID;
	}


	// Setters (Mutators)
	public void setName(String name){
		this.name = name;
	}

	public void setLocation(String location){
		this.location = location; 
	}

	public void setPriceNight(double priceNight){
		this.priceNight = priceNight;
	}


	// Method will be used to calculate the total trip cost (overriden by subclasses)
	public abstract double calculateCost(int numberOfDays);


	public abstract Accommodation copy();


	// Printing description of object
	@Override
	public String toString(){
		return "Accommodation ID: " + accommID + 
				"\nName: " + name + 
				"\nLocation: " + location + 
				"\nPrice per night: " + priceNight;
	}


	// Compare two objects 
	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == null)
	        return false;

	    if (getClass() != otherObject.getClass())
	        return false;

		Accommodation other = (Accommodation) otherObject;

			return  this.name.equalsIgnoreCase(other.name) && 
					this.location.equalsIgnoreCase(other.location) &&
					this.priceNight == other.priceNight;
	
	}



}
