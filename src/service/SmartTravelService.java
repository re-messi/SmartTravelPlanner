package service;

import client.Client;
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

    /**
     * Constructs a SmartTravelService with references to the main arrays.
     *
     * @param clients client array
     * @param clientCount current number of clients
     * @param trips trip array
     * @param tripCount current number of trips
     * @param transportations transportation array
     * @param transportationCount current number of transportation objects
     * @param accommodations accommodation array
     * @param accommodationCount current number of accommodations
     */
    public SmartTravelService(Client[] clients, int clientCount,
                              Trip[] trips, int tripCount,
                              Transportation[] transportations, int transportationCount,
                              Accommodation[] accommodations, int accommodationCount) {
        this.clients = clients;
        this.clientCount = clientCount;
        this.trips = trips;
        this.tripCount = tripCount;
        this.transportations = transportations;
        this.transportationCount = transportationCount;
        this.accommodations = accommodations;
        this.accommodationCount = accommodationCount;
    }

    /**
     * Returns the number of clients.
     *
     * @return current client count
     */
    public int getClientCount() {
        return clientCount;
    }

    /**
     * Returns the number of trips.
     *
     * @return current trip count
     */
    public int getTripCount() {
        return tripCount;
    }

    /**
     * Returns the number of transportation objects.
     *
     * @return current transportation count
     */
    public int getTransportationCount() {
        return transportationCount;
    }

    /**
     * Returns the number of accommodations.
     *
     * @return current accommodation count
     */
    public int getAccommodationCount() {
        return accommodationCount;
    }

    /**
     * Returns the client at the given index.
     *
     * @param index position in array
     * @return client object
     */
    public Client getClient(int index) {
        return clients[index];
    }

    /**
     * Returns the trip at the given index.
     *
     * @param index position in array
     * @return trip object
     */
    public Trip getTrip(int index) {
        return trips[index];
    }

    /**
     * Returns the transportation object at the given index.
     *
     * @param index position in array
     * @return transportation object
     */
    public Transportation getTransportation(int index) {
        return transportations[index];
    }

    /**
     * Returns the accommodation object at the given index.
     *
     * @param index position in array
     * @return accommodation object
     */
    public Accommodation getAccommodation(int index) {
        return accommodations[index];
    }

    /**
     * Calculates the total cost of the trip at a given index.
     *
     * @param index trip index
     * @return total trip cost
     */
    public double calculateTripTotal(int index) {
        return trips[index].calculateTotalCost();
    }

    /**
     * Returns the full client array.
     *
     * @return client array
     */
    public Client[] getClients() {
        return clients;
    }

    /**
     * Returns the full trip array.
     *
     * @return trip array
     */
    public Trip[] getTrips() {
        return trips;
    }

    /**
     * Returns the full transportation array.
     *
     * @return transportation array
     */
    public Transportation[] getTransportations() {
        return transportations;
    }

    /**
     * Returns the full accommodation array.
     *
     * @return accommodation array
     */
    public Accommodation[] getAccommodations() {
        return accommodations;
    }


    public Client findClientById(String id) throws Exception {
    for (int i = 0; i < clientCount; i++) {
        if (clients[i].getClientId().equals(id)) {
            return clients[i];
        }
    }
    throw new Exception("Client not found: " + id);
    }


    public Accommodation findAccommodationById(String id) throws Exception {
    for (int i = 0; i < accommodationCount; i++) {
        if (accommodations[i].getAccommodationID().equals(id)) {
            return accommodations[i];
        }
    }
    throw new Exception("Accommodation not found: " + id);
    } 

    public Transportation findTransportById(String id) throws Exception {
    for (int i = 0; i < transportationCount; i++) {
        if (transportations[i].getTransportId().equals(id)) {
            return transportations[i];
        }
    }
    throw new Exception("Transport not found: " + id);
    }


    public void loadAllData(String basePath) {
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