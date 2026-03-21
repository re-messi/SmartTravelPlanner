package service;

import client.Client;
import travel.Accommodation;
import travel.Transportation;
import travel.Trip;

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
}