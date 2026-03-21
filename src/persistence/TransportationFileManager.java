package persistence;

import travel.Transportation;
import travel.Train;
import travel.Bus;
import travel.Flight;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import exceptions.InvalidTransportDataException;

public class TransportationFileManager {

    public static void saveTransportation(Transportation[] transportations, int transportationCount, String filePath) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(filePath));

        for (int i = 0; i < transportationCount; i++) {
        Transportation t = transportations[i];
        String line = "";

        if (t instanceof Bus){
            Bus b = (Bus) t;
            line = "BUS;" + b.getTransportId() + ";" +
                    b.getCompanyName() + ";" + 
                    b.getDepartureCity() + ";" + 
                    b.getArrivalCity() + ";" + 
                    b.getBusCompany() + ";" + 
                    b.getNumberofStops() ;
        } else if (t instanceof Flight){
            Flight f = (Flight) t;
            line = "FLIGHT;" + f.getTransportId() + ";" +
                    f.getCompanyName() + ";" + 
                    f.getDepartureCity() + ";" + 
                    f.getArrivalCity() + ";" + 
                    f.getAirlineName() + ";" + 
                    f.getLuggageAllowanceKg();
        } else if (t instanceof Train){
            Train tr = (Train) t;
            line = "TRAIN;" + tr.getTransportId() + ";" +
                    tr.getCompanyName() + ";" + 
                    tr.getDepartureCity() + ";" + 
                    tr.getArrivalCity() + ";" + 
                    tr.getTrainType() + ";" + 
                    tr.getSeatClass();
        }
         writer.println(line);
        }
        writer.close();
    }

    public static int loadTransportation(Transportation[] transportations, String filePath) throws IOException {
        // Code to load transportation data from a file and return the count
        return 0; // Placeholder return value
    }
    
}
