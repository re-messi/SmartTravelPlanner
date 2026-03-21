package persistence;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import client.Client;


public class ClientFileManager {
    
    public static void saveClients(Client[] clients, int clientCount, String filePath) throws IOException {

        PrintWriter writer = new PrintWriter(new FileWriter(filePath)); 
            
        for (int i = 0; i < clientCount; i++) {
            Client c = clients [i];
            String line = c.getClientId() + ";" +
                          c.getFirstName() + ";" +
                          c.getLastName() + ";" +
                          c.getEmail();
            writer.println(line); 
        }
        writer.close(); 
    }
    

    public static int loadClients(Client[] clients, String filePath) throws IOException {
  Scanner scanner = new Scanner(new File(filePath));
        int count = 0;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            try {
                String[] portion = line.split(";");
                 Client c = new Client(
                      portion[0],                   // CSV ID
                      portion[1],                   // first name
                      portion[2],                   // last name
                      portion[3]                    // email
                    );
                clients[count++] = c;

            } catch (Exception e) {
                ErrorLogger.log("Invalid client data in file: " + line);
            }

}
        scanner.close();
        return count;
}
}