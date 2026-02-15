package travel;

public abstract class Accommodation {

	
	
	public abstract Accommodation copy();
	

	// Attributes
	private String name;
	private String location;
	private double priceNight;
	private static String nextAccommodationID = "A4001";  // not sure if should be int or string???


	// Default constructor 
	public Accommodation() {
		this.nextAccommodationID = nextAccommodationID;
		this.name = "";
		this.location = "";
		this.priceNight = 0.0;
	}
	

	// Parameterized constructor
	public Accommodation(String name, String location, double priceNight, String nextAccommodationID) {
		this.nextAccommodationID = nextAccommodationID;
		this.name = name;
		this.location =location;
		this.priceNight = priceNight;
	}


	// Copy constructor 
	public Accommodation(Accommodation other){
		this.nextAccommodationID = nextAccommodationID;
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

	public String getNextAccommodationID(){
		return nextAccommodationID;
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


	//
}
