package driver;

import java.util.Scanner;
import client.Client;
import travel.Accommodation;
import travel.Bus;
import travel.Flight;
import travel.Train;
import travel.Transportation;
import travel.Trip;

public class SmartTravelDriver {
    public static void main(String[] args) {
        System.out.println("Welcome to the SmartTravel Mannaging Program");

        Scanner sc = new Scanner(System.in);
        int userChoice;
        boolean valid = false;

        Client[] clients = new Client[50];
        int clientCount = 0;

        Trip[] trips = new Trip[50];
        int tripCount = 0;

        Transportation[] transportations = new Transportation[50];
        int transportationCount = 0;

        Accommodation[] accommodations = new Accommodation[50];
        int accommodationCount = 0;

        // First option of choosing testing scenario or the menu operations
        do {
            System.out.print("What would you like to do? Please enter the number of the option you desire" +
                "\n 1. See a predefined testing scenario" +
                "\n 2. Access the Menu Operations" +
                "\n Option: ");
            userChoice = sc.nextInt();

            switch (userChoice) {
                case 1: // testing (hardcode)
                    valid = true;
                    break;

                case 2: // main menu (user input)
                    mainMenu:
                    while (true) { // Main menu display and input of user's choice of management
                        System.out.print("\nMain Menu: Select an option" +
                            "\n 1. Client Management" +
                            "\n 2. Trip Management" +
                            "\n 3. Transportation Management" +
                            "\n 4. Accommodation Management" +
                            "\n 5. Additional Operations" +
                            "\n 6. Generate Visualization" +
                            "\n 0. Return to previous menu" +
                            "\n Option: ");
                        userChoice = sc.nextInt();
                        sc.nextLine();

                        switch (userChoice) {
                            case 1: // Client management
                                clientMenu:
                                while (true) { // Switch for each operation of client management
                                    System.out.print("\nWhich operation would you like to perform?" +
                                        "\n 1. Add a client" +
                                        "\n 2. Edit a client" +
                                        "\n 3. Delete a client" +
                                        "\n 4. List all clients" +
                                        "\n 0. Return to Main Menu" +
                                        "\n Operation: ");
                                    userChoice = sc.nextInt();
                                    sc.nextLine();

                                    switch (userChoice) {
                                        case 0:
                                            break clientMenu;

                                        case 1: // Add client
                                            if (clientCount < clients.length) {
                                                Client newClient = new Client();
                                                System.out.print("Enter the first name: ");
                                                String firstName = sc.nextLine();
                                                newClient.setFirstName(firstName);

                                                System.out.print("Enter the last name: ");
                                                String lastName = sc.nextLine();
                                                newClient.setLastName(lastName);

                                                System.out.print("Enter the email: ");
                                                String email = sc.nextLine();
                                                newClient.setEmail(email);

                                                clients[clientCount] = newClient; // store object in array
                                                clientCount++;

                                                System.out.println("New client added.");
                                            } else {
                                                System.out.println("Client list is full.");
                                            }
                                            break;

                                        case 2: // Edit client
                                            if (clientCount == 0) {
                                                System.out.println("No clients to edit.");
                                                break;
                                            }

                                            System.out.print("Enter the Client ID to edit (ex: C1001): ");
                                            String idToEdit = sc.nextLine();

                                            Client clientToEdit = null;

                                            // search for client
                                            for (int i = 0; i < clientCount; i++) {
                                                if (clients[i].getClientId().equals(idToEdit)) {
                                                    clientToEdit = clients[i];
                                                    break;
                                                }
                                            }

                                            if (clientToEdit == null) {
                                                System.out.println("Client not found.");
                                                break;
                                            }

                                            // Edit menu
                                            System.out.println("Editing client:");
                                            System.out.println(clientToEdit);

                                            System.out.print("\nWhat would you like to edit?" +
                                                "\n 1. First name" +
                                                "\n 2. Last name" +
                                                "\n 3. Email" +
                                                "\n Choice: ");
                                            int editChoice = sc.nextInt();
                                            sc.nextLine();

                                            switch (editChoice) {
                                                case 1:
                                                    System.out.print("Enter new first name: ");
                                                    clientToEdit.setFirstName(sc.nextLine());
                                                    break;

                                                case 2:
                                                    System.out.print("Enter new last name: ");
                                                    clientToEdit.setLastName(sc.nextLine());
                                                    break;

                                                case 3:
                                                    System.out.print("Enter new email: ");
                                                    clientToEdit.setEmail(sc.nextLine());
                                                    break;

                                                default:
                                                    System.out.println("Invalid edit option.");
                                            }

                                            System.out.println("Client updated successfully!");
                                            break;

                                        case 3: // Delete client
                                            if (clientCount == 0) {
                                                System.out.println("No clients to delete.");
                                                break;
                                            }

                                            System.out.print("Enter the Client ID to delete (ex: C1001): ");
                                            String idToDelete = sc.nextLine();

                                            int indexToDelete = -1;

                                            // Find client index
                                            for (int i = 0; i < clientCount; i++) {
                                                if (clients[i].getClientId().equals(idToDelete)) {
                                                    indexToDelete = i;
                                                    break;
                                                }
                                            }

                                            if (indexToDelete == -1) {
                                                System.out.println("Client not found.");
                                                break;
                                            }

                                            // Shift left
                                            for (int i = indexToDelete; i < clientCount - 1; i++) {
                                                clients[i] = clients[i + 1];
                                            }

                                            // Clear last slot
                                            clients[clientCount - 1] = null;
                                            clientCount--;

                                            System.out.println("Client deleted successfully.");
                                            break;

                                        case 4: // List all clients
                                            if (clientCount == 0) {
                                                System.out.println("No clients to display.");
                                                break;
                                            }

                                            System.out.println("\n----- Client List -----");

                                            for (int i = 0; i < clientCount; i++) {
                                                System.out.println(clients[i]);
                                                System.out.println("----------------------");
                                            }
                                            break;

                                        default:
                                            System.out.println("You entered a number that is not an available option. Please try again.\n");
                                    }
                                }
                                break;

                            case 2: // Trip management
                                tripMenu:
                                while (true) { // Switch for each operation of trip management
                                    System.out.print("\nWhich operation would you like to perform?" +
                                        "\n 1. Create a trip" +
                                        "\n 2. Edit trip information" +
                                        "\n 3. Cancel a trip" +
                                        "\n 4. List all trips" +
                                        "\n 5. List all trips for a specific client" +
                                        "\n 0. Return to Main Menu" +
                                        "\n Operation: ");
                                    userChoice = sc.nextInt();
                                    sc.nextLine();

                                    switch (userChoice) {
                                        case 0:
                                            break tripMenu;

                                        case 1: // Create trip
                                            if (tripCount >= trips.length) {
                                                System.out.println("Trip list is full. Cannot add more trips.");
                                                break;
                                            }

                                            System.out.print("Enter destination: ");
                                            String destination = sc.nextLine();

                                            System.out.print("Enter duration in days: ");
                                            int durationInDays = sc.nextInt();

                                            System.out.print("Enter base price: ");
                                            double basePrice = sc.nextDouble();
                                            sc.nextLine();

                                            // Select Client
                                            if (clientCount == 0) {
                                                System.out.println("No clients available. Add a client first.");
                                                break;
                                            }

                                            System.out.println("Available clients:");
                                            for (int i = 0; i < clientCount; i++) {
                                                System.out.println(clients[i].getClientId() + ": " + clients[i].getFirstName() + " " + clients[i].getLastName());
                                            }

                                            System.out.print("Enter Client ID for this trip: ");
                                            String clientID = sc.nextLine();

                                            Client selectedClient = null;
                                            for (int i = 0; i < clientCount; i++) {
                                                if (clients[i].getClientId().equalsIgnoreCase(clientID)) {
                                                    selectedClient = clients[i];
                                                    break;
                                                }
                                            }

                                            if (selectedClient == null) {
                                                System.out.println("Client not found. Trip creation cancelled.");
                                                break;
                                            }

                                            // Select Transportation
                                            if (transportationCount == 0) {
                                                System.out.println("No transportation options available. Add transportation first.");
                                                break;
                                            }

                                            System.out.println("Available transportation options:");
                                            for (int i = 0; i < transportationCount; i++) {
                                                System.out.println(i + 1 + ". " + transportations[i].toString());
                                                System.out.println("----------------------");
                                            }

                                            System.out.print("Select transportation number: ");
                                            int transportChoice = sc.nextInt();
                                            sc.nextLine();

                                            if (transportChoice < 1 || transportChoice > transportationCount) {
                                                System.out.println("Invalid selection. Trip creation cancelled.");
                                                break;
                                            }

                                            Transportation selectedTransportation = transportations[transportChoice - 1];

                                            // Select Accommodation
                                            if (accommodationCount == 0) {
                                                System.out.println("No accommodations available. Add accommodation first.");
                                                break;
                                            }

                                            System.out.println("Available accommodations:");
                                            for (int i = 0; i < accommodationCount; i++) {
                                                System.out.println(i + 1 + ". " + accommodations[i].toString());
                                                System.out.println("----------------------");
                                            }

                                            System.out.print("Select accommodation number: ");
                                            int accommodationChoice = sc.nextInt();
                                            sc.nextLine();

                                            if (accommodationChoice < 1 || accommodationChoice > accommodationCount) {
                                                System.out.println("Invalid selection. Trip creation cancelled.");
                                                break;
                                            }

                                            Accommodation selectedAccommodation = accommodations[accommodationChoice - 1];

                                            // Create Trip object
                                            Trip newTrip = new Trip(destination, durationInDays, basePrice, selectedClient, selectedTransportation, selectedAccommodation);
                                            trips[tripCount] = newTrip;
                                            tripCount++;

                                            System.out.println("\nTrip created successfully!");
                                            System.out.println(newTrip);
                                            break;

                                        case 2: // Edit trip information
                                            if (tripCount == 0) {
                                                System.out.println("No trips available to edit.");
                                                break;
                                            }

                                            System.out.print("Enter Trip ID to edit (ex: T2001): ");
                                            String tripIdEdit = sc.nextLine();

                                            Trip tripToEdit = null;
                                            for (int i = 0; i < tripCount; i++) {
                                                if (trips[i].getTripId().equalsIgnoreCase(tripIdEdit)) {
                                                    tripToEdit = trips[i];
                                                    break;
                                                }
                                            }

                                            if (tripToEdit == null) {
                                                System.out.println("Trip not found.");
                                                break;
                                            }

                                            System.out.println("Editing Trip:");
                                            System.out.println(tripToEdit);

                                            System.out.print("\nWhat would you like to edit?" +
                                                "\n 1. Destination" +
                                                "\n 2. Duration" +
                                                "\n 3. Base Price" +
                                                "\n 4. Transportation" +
                                                "\n 5. Accommodation" +
                                                "\n Choice: ");
                                            int editTripChoice = sc.nextInt();
                                            sc.nextLine();

                                            switch (editTripChoice) {
                                                case 1:
                                                    System.out.print("Enter new destination: ");
                                                    tripToEdit.setDestination(sc.nextLine());
                                                    break;

                                                case 2:
                                                    System.out.print("Enter new duration in days: ");
                                                    tripToEdit.setDurationInDays(sc.nextInt());
                                                    sc.nextLine();
                                                    break;

                                                case 3:
                                                    System.out.print("Enter new base price: ");
                                                    tripToEdit.setBasePrice(sc.nextDouble());
                                                    sc.nextLine();
                                                    break;

                                                case 4:
                                                    System.out.println("Select new transportation:");
                                                    for (int i = 0; i < transportationCount; i++) {
                                                        System.out.println(i + 1 + ". " + transportations[i].toString());
                                                    }
                                                    System.out.print("Choice: ");
                                                    int newTransport = sc.nextInt();
                                                    sc.nextLine();
                                                    if (newTransport >= 1 && newTransport <= transportationCount) {
                                                        tripToEdit.setTransportation(transportations[newTransport - 1]);
                                                    } else {
                                                        System.out.println("Invalid selection. Transportation not changed.");
                                                    }
                                                    break;

                                                case 5:
                                                    System.out.println("Select new accommodation:");
                                                    for (int i = 0; i < accommodationCount; i++) {
                                                        System.out.println(i + 1 + ". " + accommodations[i].toString());
                                                    }
                                                    System.out.print("Choice: ");
                                                    int newAccom = sc.nextInt();
                                                    sc.nextLine();
                                                    if (newAccom >= 1 && newAccom <= accommodationCount) {
                                                        tripToEdit.setAccommodation(accommodations[newAccom - 1]);
                                                    } else {
                                                        System.out.println("Invalid selection. Accommodation not changed.");
                                                    }
                                                    break;

                                                default:
                                                    System.out.println("Invalid edit option.");
                                            }
                                            System.out.println("Trip updated successfully!");
                                            break;

                                        case 3: // Cancel a trip
                                            if (tripCount == 0) {
                                                System.out.println("No trips available to cancel.");
                                                break;
                                            }

                                            System.out.print("Enter Trip ID to cancel: ");
                                            String tripIdCancel = sc.nextLine();

                                            int indexToDelete = -1;
                                            for (int i = 0; i < tripCount; i++) {
                                                if (trips[i].getTripId().equalsIgnoreCase(tripIdCancel)) {
                                                    indexToDelete = i;
                                                    break;
                                                }
                                            }

                                            if (indexToDelete == -1) {
                                                System.out.println("Trip not found.");
                                                break;
                                            }

                                            // Shift elements left
                                            for (int i = indexToDelete; i < tripCount - 1; i++) {
                                                trips[i] = trips[i + 1];
                                            }
                                            trips[tripCount - 1] = null;
                                            tripCount--;
                                            System.out.println("Trip cancelled successfully.");
                                            break;

                                        case 4: // List all trips
                                            if (tripCount == 0) {
                                                System.out.println("No trips to display.");
                                            } else {
                                                for (int i = 0; i < tripCount; i++) {
                                                    System.out.println(trips[i]);
                                                    System.out.println("--------------------------");
                                                }
                                            }
                                            break;

                                        case 5: // List all trips for a specific client
                                            if (tripCount == 0) {
                                                System.out.println("No trips to display.");
                                                break;
                                            }

                                            System.out.print("Enter Client ID to see their trips: ");
                                            String clientTripsID = sc.nextLine();

                                            boolean found = false;
                                            for (int i = 0; i < tripCount; i++) {
                                                if (trips[i].getClient().getClientId().equalsIgnoreCase(clientTripsID)) {
                                                    System.out.println(trips[i]);
                                                    System.out.println("--------------------------");
                                                    found = true;
                                                }
                                            }

                                            if (!found) {
                                                System.out.println("No trips found for this client.");
                                            }
                                            break;

                                        default:
                                            System.out.println("You entered a number that is not an available option. Please try again.\n");
                                    }
                                }
                                break;

                            case 3: // Transportation management
                                transportMenu:
                                while (true) { // Switch for each operation of transportation management
                                    System.out.print("\nWhich operation would you like to perform?" +
                                        "\n 1. Add a transportation option" +
                                        "\n 2. Remove a transportation option" +
                                        "\n 3. List transportation options by type (Flight, Train, Bus)" +
                                        "\n 0. Return to Main Menu" +
                                        "\n Operation: ");
                                    userChoice = sc.nextInt();
                                    sc.nextLine();

                                    switch (userChoice) {
                                        case 0:
                                            break transportMenu;

                                        case 1: // Add transportation
                                             if (transportationCount >= transportations.length) {
                                             System.out.println("Transportation list is full.");
                                             break;
                                          }

                                          System.out.print("Select type of transportation (1=Train, 2=Flight, 3=Bus): ");
                                          int typeChoice = sc.nextInt();
                                          sc.nextLine(); // clear buffer

                                          Transportation newTransport = null;

                                          switch (typeChoice) {
                                             case 1: // Train
                                                   System.out.print("Enter company name: ");
                                                   String companyNameT = sc.nextLine();
                                                   System.out.print("Departure city: ");
                                                   String depCityT = sc.nextLine();
                                                   System.out.print("Arrival city: ");
                                                   String arrCityT = sc.nextLine();
                                                   System.out.print("Train type: ");
                                                   String trainType = sc.nextLine();
                                                   System.out.print("Seat class: ");
                                                   String seatClass = sc.nextLine();

                                                   newTransport = new Train(companyNameT, depCityT, arrCityT, trainType, seatClass);
                                                   break;

                                             case 2: // Flight
                                                   System.out.print("Enter company name: ");
                                                   String companyNameF = sc.nextLine();
                                                   System.out.print("Departure city: ");
                                                   String depCityF = sc.nextLine();
                                                   System.out.print("Arrival city: ");
                                                   String arrCityF = sc.nextLine();
                                                   System.out.print("Airline name: ");
                                                   String airline = sc.nextLine();
                                                   System.out.print("Luggage allowance (kg): ");
                                                   double luggage = sc.nextDouble();
                                                   sc.nextLine();

                                                   newTransport = new Flight(companyNameF, depCityF, arrCityF, airline, luggage);
                                                   break;

                                             case 3: // Bus
                                                   System.out.print("Enter company name: ");
                                                   String companyNameB = sc.nextLine();
                                                   System.out.print("Departure city: ");
                                                   String depCityB = sc.nextLine();
                                                   System.out.print("Arrival city: ");
                                                   String arrCityB = sc.nextLine();
                                                   System.out.print("Bus company: ");
                                                   String busCompany = sc.nextLine();
                                                   System.out.print("Number of stops: ");
                                                   int stops = sc.nextInt();
                                                   sc.nextLine();

                                                   newTransport = new Bus(companyNameB, depCityB, arrCityB, busCompany, stops);
                                                   break;

                                             default:
                                                   System.out.println("Invalid transport type.");
                                          }

                                          if (newTransport != null) {
                                             transportations[transportationCount] = newTransport;
                                             transportationCount++;
                                             System.out.println("Transportation added successfully.");
                }
                                            break;

                                        case 2: // Remove transportation
                                            System.out.println("Remove transport not yet implemented.");
                                            break;

                                        case 3: // List by type
                                            System.out.println("List transport by type not yet implemented.");
                                            break;

                                        default:
                                            System.out.println("You entered a number that is not an available option. Please try again.\n");
                                    }
                                }
                                break;

                            case 4: // Accommodation management
                                accomMenu:
                                while (true) { // Switch for each operation of accommodation management
                                    System.out.print("\nWhich operation would you like to perform?" +
                                        "\n 1. Add an accommodation" +
                                        "\n 2. Remove an accommodation" +
                                        "\n 3. List accommodations by type (Hotel, Hostel)" +
                                        "\n 0. Return to Main Menu" +
                                        "\n Operation: ");
                                    userChoice = sc.nextInt();
                                    sc.nextLine();

                                    switch (userChoice) {
                                        case 0:
                                            break accomMenu;

                                        case 1: // Add accommodation
                                            System.out.println("Add accommodation not yet implemented.");
                                            break;

                                        case 2: // Remove accommodation
                                            System.out.println("Remove accommodation not yet implemented.");
                                            break;

                                        case 3: // List by type
                                            System.out.println("List accommodations by type not yet implemented.");
                                            break;

                                        default:
                                            System.out.println("You entered a number that is not an available option. Please try again.\n");
                                    }
                                }
                                break;

                            case 5: // Additional operations
                                addMenu:
                                while (true) { // Switch for each operation of Additional operations
                                    System.out.print("\nWhich operation would you like to perform?" +
                                        "\n 1. Display the most expensive trip" +
                                        "\n 2. Calculate and display the total cost of a trip" +
                                        "\n 3. Create a deep copy of the transportation array" +
                                        "\n 4. Create a deep copy of the accommodation array" +
                                        "\n 0. Return to Main Menu" +
                                        "\n Operation: ");
                                    userChoice = sc.nextInt();
                                    sc.nextLine();

                                    switch (userChoice) {
                                        case 0:
                                            break addMenu;

                                        case 1: // Most expensive
                                            System.out.println("Most expensive trip not yet implemented.");
                                            break;

                                        case 2: // Calculate cost
                                            System.out.println("Calculate total cost not yet implemented.");
                                            break;

                                        case 3: // Deep copy transport
                                            System.out.println("Deep copy transport not yet implemented.");
                                            break;

                                        case 4: // Deep copy accommodation
                                            System.out.println("Deep copy accommodation not yet implemented.");
                                            break;

                                        default:
                                            System.out.println("You entered a number that is not an available option. Please try again.\n");
                                    }
                                }
                                break;

                            case 6: // Generate visualization
                                vizMenu:
                                while (true) { // Switch for each operation of visualization
                                    System.out.print("\nWhich operation would you like to perform?" +
                                        "\n 1. Bar chart (Trip Cost)" +
                                        "\n 2. Pie chart (Trips per destination)" +
                                        "\n 3. Line chart (Duration over time)" +
                                        "\n 0. Return to Main Menu" +
                                        "\n Operation: ");
                                    userChoice = sc.nextInt();
                                    sc.nextLine();

                                    switch (userChoice) {
                                        case 0:
                                            break vizMenu;

                                        case 1: // Bar chart
                                            System.out.println("Bar chart not yet implemented.");
                                            break;

                                        case 2: // Pie chart
                                            System.out.println("Pie chart not yet implemented.");
                                            break;

                                        case 3: // Line chart
                                            System.out.println("Line chart not yet implemented.");
                                            break;

                                        default:
                                            System.out.println("You entered a number that is not an available option. Please try again.\n");
                                    }
                                }
                                break;

                            case 0: // Return to initial menu
                                break mainMenu;

                            default:
                                System.out.println("You entered a number that is not an available option. Please try again.\n");
                        }
                    }
                    break;

                default:
                    System.out.println("You entered a number that is not an available option. Please try again.\n");
            }

        } while (!valid);

        sc.close();
    }
} 