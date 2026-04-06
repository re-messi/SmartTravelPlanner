package service;
import interfaces.CsvPersistable;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import client.Client;
import travel.Accommodation;
import travel.Hostel;
import travel.Hotel;
import travel.Transportation;
import travel.Bus;
import travel.Flight;
import travel.Train;
import travel.Trip;
import persistence.*;
import exceptions.*;

//-----------------------------------------------------
// Assignment 3 - COMP 249
// Written by: Rebecca Messier (40338041) and Taminda Ait Ouazzou (40344517)
//
// GenericFileManager is a generic utility class that handles
// CSV file reading and writing for any type that implements
// CsvPersistable.
// It replaces the four separate A2 file managers:
//   - ClientFileManager
//   - TripFileManager
//   - AccommodationFileManager
//   - TransportationFileManager
// save() converts each object to a CSV row via toCsvRow()
// load() reads each line and reconstructs the correct object
// type via fromCsvRow()
//-----------------------------------------------------

public class GenericFileManager<T extends CsvPersistable> {

    
    public static <T extends CsvPersistable> void save(List<T> items, String filepath) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filepath));

            for (T item : items) { // Enhenced for-loop (for-each loop)
                writer.println(item.toCsvRow()); // every class guarantees this via CsvPersistable
            }

            writer.close();

        } catch (IOException e) {
            ErrorLogger.log("GenericFileManager save error: " + e.getMessage());
        }
    }

    

    public static <T extends CsvPersistable> List<T> load(String filepath, Class<T> clazz) {
        List<T> result = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filepath));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue; // skip blank lines

                try {
                    T obj = null;

                    // Switch on the class name to call the right fromCsvRow()
                    switch (clazz.getSimpleName()) {

                        case "Client":
                            obj = (T) Client.fromCsvRow(line);
                            break;

                        case "Trip":
                            obj = (T) Trip.fromCsvRow(line);
                            break;

                        case "Accommodation":
                            // First word of the line tells us HOTEL or HOSTEL
                            String accomType = line.split(";")[0];
                            if (accomType.equals("HOTEL")) {
                                obj = (T) Hotel.fromCsvRow(line);
                            } else if (accomType.equals("HOSTEL")) {
                                obj = (T) Hostel.fromCsvRow(line);
                            } else {
                                throw new InvalidAccommodationDataException(
                                    "Unknown accommodation type: " + accomType);
                            }
                            break;

                        case "Transportation":
                            // First word of the line tells us BUS, FLIGHT, or TRAIN
                            String transportType = line.split(";")[0];
                            if (transportType.equals("BUS")) {
                                obj = (T) Bus.fromCsvRow(line);
                            } else if (transportType.equals("FLIGHT")) {
                                obj = (T) Flight.fromCsvRow(line);
                            } else if (transportType.equals("TRAIN")) {
                                obj = (T) Train.fromCsvRow(line);
                            } else {
                                throw new InvalidTransportDataException(
                                    "Unknown transport type: " + transportType);
                            }
                            break;

                        default:
                            ErrorLogger.log("GenericFileManager: unknown class " + clazz.getSimpleName());
                            break;
                    }

                    if (obj != null) {
                        result.add(obj);
                    }

                } catch (Exception e) {
                    ErrorLogger.log("GenericFileManager load error on line: " + line + " | " + e.getMessage());
                }
            }

            scanner.close();

        } catch (IOException e) {
            ErrorLogger.log("GenericFileManager file error: " + e.getMessage());
        }

        return result;
    }
}