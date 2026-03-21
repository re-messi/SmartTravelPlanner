package persistence;

import travel.Accommodation;
import travel.Hostel;
import travel.Hotel;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import exceptions.InvalidAccommodationDataException;
import java.io.File;

public class AccommodationFileManager {

public static void saveAccommodations(Accommodation[] accommodations, int accommodationCount, String filePath) throws IOException {
    PrintWriter writer = new PrintWriter(new FileWriter(filePath));

    for (int i = 0; i < accommodationCount; i++) {
        Accommodation a = accommodations[i];
        String line = "";

        // Polymorphism to detect type and append type-specific attribute
        if (a instanceof Hotel) {
            Hotel h = (Hotel) a;
            line = "HOTEL;" + h.getAccommodationID() + ";" +
                   h.getName() + ";" +
                   h.getLocation() + ";" +
                   h.getPricePerNight() + ";" +
                   h.getStarRating();
        } else if (a instanceof Hostel) {
            Hostel h = (Hostel) a;
            line = "HOSTEL;" + h.getAccommodationID() + ";" +
                   h.getName() + ";" +
                   h.getLocation() + ";" +
                   h.getPricePerNight() + ";" +
                   h.getSharedBedsPerRoom();
        }

        writer.println(line);
    }

    writer.close();
}
    
    public static int loadAccommodations(Accommodation[] accommodations, String filePath) throws IOException {
        Scanner scanner = new Scanner(new File(filePath));
        int count = 0;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            try {
               String[] portion = line.split(";");
                Accommodation a = null;

                if (portion[0].equals("HOTEL")) {
                    a = new Hotel(
                        portion[1],                   // CSV ID
                        portion[2],                   // name
                        portion[3],                   // location
                        Double.parseDouble(portion[4]), // price per night
                        Integer.parseInt(portion[5])   // star rating
                    );

                } else if (portion[0].equals("HOSTEL")) {
                    a = new Hostel(
                        portion[1],                   // CSV ID
                        portion[2],                   // name
                        portion[3],                   // location
                        Double.parseDouble(portion[4]), // price per night
                        Integer.parseInt(portion[5])   // shared beds per room
                    );

                } else {
                    throw new InvalidAccommodationDataException("Unknown accommodation type: " + portion[0]);
                }

                accommodations[count++] = a;

            } catch (Exception e) {
                // Log invalid line and skip
                ErrorLogger.log("Invalid accommodation data in file: " + line);
            }
        }

        scanner.close();
        return count;
    }
}