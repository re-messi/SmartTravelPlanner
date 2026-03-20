package persistence;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import client.Client;


public class ClientFileManager {
    
    public static void saveClients(Client[] clients, int clientCount, String filePath) throws IOException {

        PrintWriter writer = new PrintWriter(new FileWriter(filePath, true)); // Why not put name of the file directly instead of filePath? 
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
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int count = 0; 

        while ((line = reader.readLine()) !=null){
            try {
                String[] portion = line.split(";");

                Client c = new Client (portion[0], portion[1], portion[2], portion[3]); // Problem pcq la parameter takes 4 strings mais constructor de client prend 3 strings et un clientID generated automatically
                clients[count++] = c;
            } catch (Exception e){
                ErrorLogger.log("Invalid client data in file: " + line);
            }
        }
        reader.close();
        return count;
    }

}
