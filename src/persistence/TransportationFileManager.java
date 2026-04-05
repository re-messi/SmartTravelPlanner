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
                    b.getPrice() + ";" + 
                    b.getNumberofStops() ;
        } else if (t instanceof Flight){
            Flight f = (Flight) t;
            line = "FLIGHT;" + f.getTransportId() + ";" +
                    f.getCompanyName() + ";" + 
                    f.getDepartureCity() + ";" + 
                    f.getArrivalCity() + ";" + 
                    f.getPrice() + ";" + 
                    f.getLuggageAllowanceKg();
        } else if (t instanceof Train){
            Train tr = (Train) t;
            line = "TRAIN;" + tr.getTransportId() + ";" +
                    tr.getCompanyName() + ";" + 
                    tr.getDepartureCity() + ";" + 
                    tr.getArrivalCity() + ";" + 
                    tr.getPrice()+ ";" + 
                    tr.getTrainType();
                    tr.getSeatClass();
        }
         writer.println(line);
        }
        writer.close();
    }

    public static int loadTransportation(Transportation[] transportations, String filePath) throws IOException {
         Scanner scanner = new Scanner(new File(filePath));
        int count = 0;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            try {
               String[] portion = line.split(";");
               Transportation t = null;

               if (portion[0].equals("BUS")){
                t = new Bus(
                     portion[1],                   
                     portion[2],                   
                     portion[3],
                     portion[4],
                     Double.parseDouble(portion[5]),
                     Integer.parseInt(portion[6]) 
                );
               } else if (portion[0].equals("FLIGHT")){
                t = new Flight(
                     portion[1],                   
                     portion[2],                   
                     portion[3],
                     portion[4],
                     Double.parseDouble(portion[5]),
                     Double.parseDouble(portion[6])
                );
               } else if (portion[0].equals("TRAIN")){
                t = new Train(
                     portion[1],                   
                     portion[2],                   
                     portion[3],
                     portion[4],
                     Double.parseDouble(portion[5]),
                     portion[6],
                     portion[7]
                );
               } else {
                throw new InvalidTransportDataException("Unknown transportation type: " + portion[0]);
               }

               transportations[count++] = t;
    
         } catch (Exception e) {
                // Log invalid line and skip
                ErrorLogger.log("Invalid transportation data in file: " + line);
            }
        }

        scanner.close();
        return count;
    
}
}
