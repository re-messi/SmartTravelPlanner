package persistence;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class ErrorLogger {

    public static void log(String message){
PrintWriter write =null; 

try { 
    write = new PrintWriter(new FileWriter("output/logs/errors.txt", true));
    write.println(message);
     write.close();
} catch (IOException e) {
    System.out.println("Problem occured while writing to the file: ");
    }
    
}
}
