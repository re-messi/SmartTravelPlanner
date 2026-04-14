//-----------------------------------------------------
// Assignment 2
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
import exceptions.InvalidTripDataException;
import interfaces.*;

public class Trip implements Identifiable, Billable, CsvPersistable, Comparable<Trip> {

	//Attributes
	private String tripId;
	private String destination;
	private int durationInDays;
	private double basePrice;
	private Client client;
	private Transportation transportation;
	private Accommodation accommodation;
	private static int nextTripNum = 2001;
	
	private String tempClientId;
	private String tempAccommodationId;
	private String tempTransportId;

	public void setTempIds(String c, String a, String t) {
		tempClientId = c;
		tempAccommodationId = a;
		tempTransportId = t;
	}

public String getTempClientId() { return tempClientId; }
public String getTempAccommodationId() { return tempAccommodationId; }
public String getTempTransportId() { return tempTransportId; }
	
	//Helper method to generate IDs
	private static String generateTripId() {
		return "T" + (nextTripNum++); 
		
	  }
	
	//Parameterized constructor
	public Trip(String destination, int durationInDays, double basePrice, Client client, Transportation transportation, Accommodation accommodation) throws InvalidTripDataException {
		this.tripId = generateTripId();
		setDestination(destination);
		setDurationInDays(durationInDays);
		setBasePrice(basePrice);
		setClient(client);
		setTransportation(transportation);
		setAccommodation(accommodation);	
				
	}

	// Parameterized constrcutor with allIDs for loading from file
	public Trip(String tripId, String destination,
				int duration, double basePrice) throws InvalidTripDataException {

		this.tripId = tripId;
		setDestination(destination);
		setDurationInDays(duration);
		setBasePrice(basePrice);

		this.client = null;
		this.transportation = null;
		this.accommodation = null;

	
    // Update nextTripNum
  	  int numericPart = Integer.parseInt(tripId.substring(1));
  	  if (numericPart >= nextTripNum) {
        nextTripNum = numericPart + 1;
    }
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

		// Polymorphic deep copy 
    	this.transportation = (other.transportation == null) ? null : other.transportation.copy();
    	this.accommodation  = (other.accommodation  == null) ? null : other.accommodation.copy();
		}
	
	// Accessors
	
	public String getTripId() { return tripId; }
	
	public String getDestination() { return destination; }

	public int getDurationInDays() { return durationInDays; }
	
	@Override
	public double getBasePrice() { return basePrice; }
	
	public Client getClient() { return client; }
	
	public Transportation getTransportation() { return transportation; }
	
	public Accommodation getAccommodation() { return accommodation; }
	
	// Mutators (update trip attributes, excluding tripId)

	public void setDestination(String destination) throws InvalidTripDataException {
		if (destination == null || destination.trim().isEmpty())
			throw new InvalidTripDataException("Destination cannot be empty.");
		this.destination = destination;
	}
	
	public void setDurationInDays(int durationInDays) throws InvalidTripDataException {
		if (durationInDays < 1 || durationInDays > 20)
			throw new InvalidTripDataException("Duration must be between 1 and 20 days.");
		this.durationInDays = durationInDays;
	}
	
	public void setBasePrice(double basePrice) throws InvalidTripDataException {
		if (basePrice < 100.0)
			throw new InvalidTripDataException("Base price must be at least $100.00.");
		this.basePrice = basePrice;
	}
	
	public void setClient(Client client) throws InvalidTripDataException {
		if (client == null)
			throw new InvalidTripDataException("Trip must have a client.");
		this.client = client;
	}
	
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
	public String getId() {
    	return getTripId();
	}

	@Override
	public double getTotalCost() {
    	return calculateTotalCost();
	}

	@Override
	public String toCsvRow() {
    	return tripId + ";" +
           (client != null ? client.getClientId() : "") + ";" +
           (accommodation != null ? accommodation.getAccommodationID() : "") + ";" +
           (transportation != null ? transportation.getTransportId() : "") + ";" +
           destination + ";" + durationInDays + ";" + basePrice;
}

	@Override
	public int compareTo(Trip other) {
    	return Double.compare(other.calculateTotalCost(), this.calculateTotalCost());
	}

	public static Trip fromCsvRow(String line) throws InvalidTripDataException {
    String[] p = line.split(";");

    String tripId = p[0];
    String clientId = p[1];
    String accommodationId = p[2];
    String transportId = p[3];
    String destination = p[4];
    int duration = Integer.parseInt(p[5]);
    double basePrice = Double.parseDouble(p[6]);

    Trip t = new Trip(tripId, destination, duration, basePrice);

    t.setTempIds(clientId, accommodationId, transportId); 

    return t;
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
		           "\nTotal Cost: $" + getTotalCost();
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
