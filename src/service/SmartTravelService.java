package service;

import java.util.ArrayList;
import java.util.List;

import client.Client;
import exceptions.EntityNotFoundException;
import travel.Accommodation;
import travel.Transportation;
import travel.Trip;
import persistence.*;
//-----------------------------------------------------
// Assignment 2 - COMP 249
// Written by: Rebecca Messier (40338041) and Taminda Ait Ouazzou (40344517)
//
// SmartTravelService manages all arrays used in the SmartTravel system.
// It provides accessor methods for dashboard generation, chart generation,
// and future file I/O operations.
//-----------------------------------------------------
 

public class SmartTravelService {

    private List<Client> clients = new ArrayList<>();
    private List<Trip> trips = new ArrayList<>();
    private List<Transportation> transportations = new ArrayList<>();
    private List<Accommodation> accommodations = new ArrayList<>();

    Repository<Client> clientRepo = new Repository<>();
    Repository<Trip> tripRepo = new Repository<>();
    Repository<Accommodation> accommodationRepo = new Repository<>();
    Repository<Transportation> transportationRepo = new Repository<>();

    
    public SmartTravelService() {

    }

    // Constructs a SmartTravelService with references to the main arrays 
    public SmartTravelService(Client[] clients, int clientCount, Trip[] trips, int tripCount, Transportation[] transportations, int transportationCount, Accommodation[] accommodations, int accommodationCount) {
        
        for (int i = 0; i < clientCount; i++) {
            this.clients.add(clients[i]);
            this.clientRepo.add(clients[i]);
        }

        for (int i = 0; i < tripCount; i++) {
            this.trips.add(trips[i]);
            this.tripRepo.add(trips[i]);
        }

        for (int i = 0; i < transportationCount; i++) {
            this.transportations.add(transportations[i]);
            this.transportationRepo.add(transportations[i]);
        }

        for (int i = 0; i < accommodationCount; i++) {
            this.accommodations.add(accommodations[i]);
            this.accommodationRepo.add(accommodations[i]);
        }
    }

    //add methods
    public void addClient(Client c) {
        clients.add(c);
        clientRepo.add(c);
    }

    public void addTrip(Trip t) {
        trips.add(t);
        tripRepo.add(t);
    }

    public void addTransportation(Transportation t) {
        transportations.add(t);
        transportationRepo.add(t);
    }

    public void addAccommodation(Accommodation a) {
        accommodations.add(a);
        accommodationRepo.add(a);
    }

    public void removeClient(String id) throws EntityNotFoundException {
    Client toRemove = findClientById(id);
    clients.remove(toRemove);
    }

    public void removeTrip(String id) throws EntityNotFoundException {
        Trip toRemove = null;
        for (Trip t : trips) {
            if (t.getTripId().equals(id)) { toRemove = t; break; }
        }
        if (toRemove == null) throw new EntityNotFoundException("Trip not found: " + id);
        trips.remove(toRemove);
    }

    public void removeTransportation(String id) throws EntityNotFoundException {
    Transportation toRemove = null;
    for (Transportation t : transportations) {
        if (t.getTransportId().equals(id)) { toRemove = t; break; }
    }
    if (toRemove == null) throw new EntityNotFoundException("Transport not found: " + id);
    transportations.remove(toRemove);
    }

    public void removeAccommodation(String id) throws EntityNotFoundException {
        Accommodation toRemove = null;
        for (Accommodation a : accommodations) {
            if (a.getAccommodationID().equals(id)) { toRemove = a; break; }
        }
        if (toRemove == null) throw new EntityNotFoundException("Accommodation not found: " + id);
        accommodations.remove(toRemove);
    }


    //Getters

    public int getClientCount() {return clients.size();}

    public int getTripCount() {return trips.size();}

    public int getTransportationCount() {return transportations.size();}

    public int getAccommodationCount() {return accommodations.size();}

    public Client getClient(int index) {return clients.get(index);}

    public Trip getTrip(int index) {return trips.get(index);}

    public Transportation getTransportation(int index) {return transportations.get(index);}

    public Accommodation getAccommodation(int index) {return accommodations.get(index);}

    public List<Client> getClients() {return clients;}

    public List<Trip> getTrips() {return trips;}

    public List<Transportation> getTransportations() {return transportations;}

    public List<Accommodation> getAccommodations() {return accommodations;}

    public Repository<Client> getClientRepo() {return clientRepo;}

    public Repository<Trip> getTripRepo() {return tripRepo;}

    public Repository<Transportation> getTransportationRepo() {return transportationRepo;}

    public Repository<Accommodation> getAccommodationRepo() {return accommodationRepo;}

   //List.size() is used instead of setters


    //Calculates the total cost of the trip at a given index
    public double calculateTripTotal(int index) {
        if (index < 0 || index >= trips.size() || trips.get(index) == null) {
            return 0;
        }
        return trips.get(index).calculateTotalCost(); // returns total cost
    }


    public Client findClientById(String id) throws EntityNotFoundException {
    for (Client c : clients) {
        if (c.getClientId().equals(id)) {
            return c;
        }
    }
    throw new EntityNotFoundException("Client not found: " + id);
    }


    public Accommodation findAccommodationById(String id) throws EntityNotFoundException {
    for (Accommodation a : accommodations) {
        if (a.getAccommodationID().equals(id)) {
            return a;
        }
    }
    throw new EntityNotFoundException("Accommodation not found: " + id);
    } 

    public Transportation findTransportById(String id) throws EntityNotFoundException {
    for (Transportation t : transportations) {
        if (t.getTransportId().equals(id)) {
            return t;
        }
    }
    throw new EntityNotFoundException("Transport not found: " + id);
    }

    // load all data from csv files & reconstructs object relationships
    public void loadAllData(String basePath) { 
    

    
        try {
            Client[] tempClients = new Client[1000]; //temporary arrays will need to be changed
            Accommodation[] tempAccom = new Accommodation[1000];
            Transportation[] tempTransport = new Transportation[1000];
            Trip[] tempTrips = new Trip[1000];
        
        int clientCount = ClientFileManager.loadClients(tempClients, basePath + "clients.csv");
        int accommodationCount = AccommodationFileManager.loadAccommodations(tempAccom, basePath + "accommodations.csv");
        int transportationCount = TransportationFileManager.loadTransportation(tempTransport, basePath + "transports.csv");
        int tripCount = TripFileManager.loadTrips(tempTrips, basePath + "trips.csv");

        clients.clear();
        trips.clear();
        transportations.clear();
        accommodations.clear();    

        for (int i = 0; i < clientCount; i++) { 
            clients.add(tempClients[i]); 
            clientRepo.add(tempClients[i]);
        }    

        for (int i = 0; i < accommodationCount; i++) {
            accommodations.add(tempAccom[i]);
            accommodationRepo.add(tempAccom[i]);
        }    
        for (int i = 0; i < transportationCount; i++) { 
            transportations.add(tempTransport[i]);
            transportationRepo.add(tempTransport[i]);
        }    
        for (int i = 0; i < tripCount; i++) {
            trips.add(tempTrips[i]);
            tripRepo.add(tempTrips[i]);
        }

        for (Trip t : trips) {
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
    
    public void saveAllData(String basePath) { // writes all arrays back to the files 
        try {
            ClientFileManager.saveClients(clients.toArray(new Client[0]), clients.size(), basePath + "clients.csv");
            AccommodationFileManager.saveAccommodations(accommodations.toArray(new Accommodation[0]), accommodations.size(), basePath + "accommodations.csv");
            TransportationFileManager.saveTransportation(transportations.toArray(new Transportation[0]), transportations.size(), basePath + "transports.csv");
            TripFileManager.saveTrips(trips.toArray(new Trip[0]), trips.size(), basePath + "trips.csv");

        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }


    


}