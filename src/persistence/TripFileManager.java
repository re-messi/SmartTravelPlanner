package persistence;

import travel.Trip;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TripFileManager {

public static void saveTrips(Trip[] trips, int tripCount, String filePath) throws IOException{
    PrintWriter writer = new PrintWriter(new FileWriter(filePath));

    for (int i = 0; i < tripCount; i++) {
        Trip t = trips[i];

        String clientId = (t.getClient() == null) ? "" : t.getClient().getClientId();
        String accommodationId = (t.getAccommodation() == null) ? "" : t.getAccommodation().getAccommodationID();
        String transportId = (t.getTransportation() == null) ? "" : t.getTransportation().getTransportId();

        String line = t.getTripId() + ";" +
                      clientId + ";" +
                      accommodationId + ";" +
                      transportId + ";" +
                      t.getDestination() + ";" +
                      t.getDurationInDays() + ";" +
                      t.getBasePrice();

        writer.println(line);
    }

    writer.close();
}

public static int loadTrips(Trip[] trips, String filePath) throws IOException{
    Scanner scanner = new Scanner(new File(filePath));
    int count = 0;

    while (scanner.hasNextLine()) {
        String line = scanner.nextLine();

        try {
            String[] portion = line.split(";");

            String tripId = portion[0];
            String clientId = portion[1];
            String accommodationId = portion[2];
            String transportId = portion[3];
            String destination = portion[4];
            int duration = Integer.parseInt(portion[5]);
            double basePrice = Double.parseDouble(portion[6]);

            Trip t = new Trip(tripId, destination, duration, basePrice);

            t.setTempIds(clientId, accommodationId, transportId);

            trips[count++] = t;

        } catch (Exception e) {
            ErrorLogger.log("Invalid trip data in file: " + line);
        }
    }

    scanner.close();
    return count;
}
}