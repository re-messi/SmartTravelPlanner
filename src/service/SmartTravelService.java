package service;

import client.Client;
import exceptions.EntityNotFoundException;
import travel.Accommodation;
import travel.Transportation;
import travel.Trip;
import persistence.*;

/* SmartTravelService manages all arrays used in the SmartTravel system.
 * It provides accessor methods for dashboard generation, chart generation,
 * and future file I/O operations.
 */

public class SmartTravelService {

    private Client[] clients;
    private int clientCount;

    private Trip[] trips;
    private int tripCount;

    private Transportation[] transportations;
    private int transportationCount;

    private Accommodation[] accommodations;
    private int accommodationCount;

    
    // Constructs a SmartTravelService with references to the main arrays 
    public SmartTravelService(Client[] clients, int clientCount, Trip[] trips, int tripCount, Transportation[] transportations, int transportationCount, Accommodation[] accommodations, int accommodationCount) {
        
        this.clients = clients;
        this.clientCount = clientCount;
        this.trips = trips;
        this.tripCount = tripCount;
        this.transportations = transportations;
        this.transportationCount = transportationCount;
        this.accommodations = accommodations;
        this.accommodationCount = accommodationCount;
    }

    
    //Returns the number of clients
    public int getClientCount() {
        return clientCount;
    }

    // Returns the number of trips
    public int getTripCount() {
        return tripCount;
    }


    // Returns the number of transportation objects
     
    public int getTransportationCount() {
        return transportationCount;
    }

     //Returns the number of accommodations
    
    public int getAccommodationCount() {
        return accommodationCount;
    }
    // Returns the client at the given index
    public Client getClient(int index) {
        return clients[index];
    }

    // Returns the trip at the given index
    public Trip getTrip(int index) {
        return trips[index];
    }

    //Returns the transportation object at the given index
    public Transportation getTransportation(int index) {
        return transportations[index];
    }

    //Returns the accommodation object at the given index
    public Accommodation getAccommodation(int index) {
        return accommodations[index];
    }

    //Calculates the total cost of the trip at a given index
    public double calculateTripTotal(int index) {
        if (index < 0 || index >= tripCount || trips[index] == null) {
            return 0;
        }
        return trips[index].calculateTotalCost();
    }

    //Returns the full client array
    public Client[] getClients() {
        return clients;
    }

    //Returns the full trip array
    public Trip[] getTrips() {
        return trips;
    }

    //Returns the full transportation array
    public Transportation[] getTransportations() {
        return transportations;
    }

    //Returns the full accommodation array
    public Accommodation[] getAccommodations() {
        return accommodations;
    }

    //Sets the client count
    public void setClientCount(int clientCount) {
        this.clientCount = clientCount;
    }

    //Sets the trip count
    public void setTripCount(int tripCount) {
        this.tripCount = tripCount;
    }

    //Sets the transportation count
    public void setTransportationCount(int transportationCount) {
        this.transportationCount = transportationCount;
    }

    //Sets the accommodation count
    public void setAccommodationCount(int accommodationCount) {
        this.accommodationCount = accommodationCount;
    }




    public Client findClientById(String id) throws EntityNotFoundException {
    for (int i = 0; i < clientCount; i++) {
        if (clients[i].getClientId().equals(id)) {
            return clients[i];
        }
    }
    throw new EntityNotFoundException("Client not found: " + id);
    }


    public Accommodation findAccommodationById(String id) throws EntityNotFoundException {
    for (int i = 0; i < accommodationCount; i++) {
        if (accommodations[i].getAccommodationID().equals(id)) {
            return accommodations[i];
        }
    }
    throw new EntityNotFoundException("Accommodation not found: " + id);
    } 

    public Transportation findTransportById(String id) throws EntityNotFoundException {
    for (int i = 0; i < transportationCount; i++) {
        if (transportations[i].getTransportId().equals(id)) {
            return transportations[i];
        }
    }
    throw new EntityNotFoundException("Transport not found: " + id);
    }


    public void loadAllData(String basePath) {
    
    //reset count before loading 
    clientCount = 0;
    tripCount = 0;
    transportationCount = 0;
    accommodationCount = 0;
    
        try {
        clientCount = ClientFileManager.loadClients(clients, basePath + "clients.csv");
        accommodationCount = AccommodationFileManager.loadAccommodations(accommodations, basePath + "accommodations.csv");
        transportationCount = TransportationFileManager.loadTransportation(transportations, basePath + "transports.csv");
        tripCount = TripFileManager.loadTrips(trips, basePath + "trips.csv");

        
        for (int i = 0; i < tripCount; i++) {
            Trip t = trips[i];

            try {
                if (t.getTempClientId() != null && !t.getTempClientId().isEmpty()) {
                    t.setClient(findClientById(t.getTempClientId()));
                }

                if (t.getTempAccommodationId() != null && !t.getTempAccommodationId().isEmpty()) {
                    t.setAccommodation(findAccommodationById(t.getTempAccommodationId()));
                }

                if (t.getTempTransportId() != null && !t.getTempTransportId().isEmpty()) {
                    t.setTransportation(findTransportById(t.getTempTransportId()));
                }

            } catch (Exception e) {
                ErrorLogger.log("Error linking trip: " + t.getTripId());
            }
        }

    } catch (Exception e) {
        System.out.println("Error loading data: " + e.getMessage());
    }
}

    public void saveAllData(String basePath) {
        try {
            ClientFileManager.saveClients(clients, clientCount, basePath + "clients.csv");
            AccommodationFileManager.saveAccommodations(accommodations, accommodationCount, basePath + "accommodations.csv");
            TransportationFileManager.saveTransportation(transportations, transportationCount, basePath + "transports.csv");
            TripFileManager.saveTrips(trips, tripCount, basePath + "trips.csv");

        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }





}