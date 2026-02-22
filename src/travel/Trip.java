//-----------------------------------------------------
// Assignment 1
// Written by: Rebecca Messier (40338041) and Taminda Ait Ouazzou (40344517)
//
// This class represents a trip in the SmartTravel
// system. A trip is associated with one client and
// may include one transportation option and one
// accommodation. It also calculates the total cost
// of the trip.
//-----------------------------------------------------
package travel;

import client.Client;

public class Trip {

	//Attributes
	private String tripId;
	private String destination;
	private int durationInDays;
	private double basePrice;
	private Client client;
	private Transportation transportation;
	private Accommodation accommodation;
	private static int nextTripNum = 2001;
	
	//Helper method to generate IDs
	private static String generateTripId() {
		return "T" + (nextTripNum++); 
		
	  }
	
	//Default constructor
	public Trip() {
		this.tripId = generateTripId();
		this.destination = "";
		this.durationInDays = 0;
		this.basePrice = 0.00;
		this.client = null;
		this.transportation = null;
		this.accommodation = null;
		
	}
	
	//Parameterized constructor
	public Trip(String destination, int durationInDays, double basePrice, Client client, Transportation transportation, Accommodation accommodation) {
		this.tripId = generateTripId();
		this.destination = destination;
		this.durationInDays = durationInDays;
		this.basePrice = basePrice;
		this.client = client;
		this.transportation = transportation;
		this.accommodation = accommodation;	
				
	}
	
	//Copy constructor (deep copy)
	public Trip(Trip other) {
		this.tripId = generateTripId();
		
		// Copy basic attributes
		this.destination = other.destination;
		this.durationInDays = other.durationInDays;
		this.basePrice = other.basePrice;
		
		 // Deep copy composed objects
		this.client = (other.client == null) ? null : new Client(other.client);

				//Tranaportation Deep copy
				if (other.transportation == null) { this.transportation = null; } 
				else if (other.transportation instanceof Train) {this.transportation = new Train((Train) other.transportation);} 
				else if (other.transportation instanceof Flight) {this.transportation = new Flight((Flight) other.transportation);} 
				else if (other.transportation instanceof Bus) {this.transportation = new Bus((Bus) other.transportation);} 
				else {this.transportation = null; } // Fallback in case of unknown type
    
				//Accommodation Deep copy
				if (other.accommodation == null) { this.accommodation = null; } 
				else if (other.accommodation instanceof Hotel) {this.accommodation = new Hotel((Hotel) other.accommodation);} 
				else if (other.accommodation instanceof Hostel) {this.accommodation = new Hostel((Hostel) other.accommodation);} 
				else {this.accommodation = null; } // Fallback in case of unknown type
	}
	
	// Accessors
	
	public String getTripId() { return tripId; }
	
	public String getDestination() { return destination; }

	public int getDurationInDays() { return durationInDays; }
	
	public double getBasePrice() { return basePrice; }
	
	public Client getClient() { return client; }
	
	public Transportation getTransportation() { return transportation; }
	
	public Accommodation getAccommodation() { return accommodation; }
	
	// Mutators (update trip attributes, excluding tripId)

	public void setDestination(String destination) { this.destination = destination; }
	
	public void setDurationInDays(int durationInDays) { this.durationInDays = durationInDays; }	
	
	public void setBasePrice(double basePrice) { this.basePrice = basePrice; }
	
	public void setClient(Client client) { this.client = client; }
	
	public void setTransportation(Transportation transportation) { this.transportation = transportation; }
	
	public void setAccommodation(Accommodation accommodation) { this.accommodation = accommodation; }
	
	// Calculate total trip cost using polymorphism
	//base price + transportation cost + accommodation cost
	public double calculateTotalCost() {
		double totalCost = basePrice;
		// Add transportation cost if present
		totalCost += (transportation == null) ? 0 : transportation.calculateCost(durationInDays);
		// Add accommodation cost if present
		totalCost += (accommodation == null) ? 0 : accommodation.calculateCost(durationInDays);
		return totalCost;
	}
	@Override
	 // Returns a string representation of the Trip 
	public String toString() {
		return "Trip ID: " + tripId +
		           "\nDestination: " + destination +
		           "\nDuration (days): " + durationInDays +
		           "\nBase Price: $" + basePrice +
		           "\nClient: " + (client == null ? "None" : client.getFirstName() + " " + client.getLastName()) +
		           "\nTransportation: " + (transportation == null ? "None" : transportation.toString()) +
		           "\nAccommodation: " + (accommodation == null ? "None" : accommodation.toString()) +
		           "\nTotal Cost: $" + calculateTotalCost();
	}
	@Override
	// Checks equality between two Trips
	public boolean equals(Object otherObject) {
		if (otherObject == null)
	        return false;

	    if (getClass() != otherObject.getClass())
	        return false;

	    Trip other = (Trip) otherObject;
	    
	    //Comparisons for composed objects
	    boolean clientEqual = (client == null && other.client == null) || (client != null && client.equals(other.client));
	    boolean transportationEqual = (transportation == null && other.transportation == null) || (transportation != null && transportation.equals(other.transportation));
	    boolean accommodationEqual = (accommodation == null && other.accommodation == null) || (accommodation != null && accommodation.equals(other.accommodation));

	    return destination.equals(other.destination) &&
	           durationInDays == other.durationInDays &&
	           basePrice == other.basePrice &&
	           clientEqual &&
	           transportationEqual &&
	           accommodationEqual;

	}
	

	
}
