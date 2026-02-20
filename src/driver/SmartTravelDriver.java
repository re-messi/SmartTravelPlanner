package driver;

import java.util.Scanner;

public class SmartTravelDriver {
    public static void main(String[] args) {

    System.out.println("Welcome to the SmartTravel Mannaging Program");

    Scanner sc = new Scanner(System.in);
    int userChoice; 
    boolean valid = false;

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

            case 2: // main menu (user input))
                valid = true;
                valid = false;
    
                    do { // Main menu display and input of user's choice of management
                    System.out.print("\nMain Menu: Select an option" + 
                     "\n 1. Client Management" + 
                     "\n 2. Trip Management" + 
                     "\n 3. Transportation Management" + 
                     "\n 4. Accommodation Management" + 
                     "\n 5. Additional Operations" +
                     "\n 6. Generate Visualization" + 
                     "\n Option: ");
                     userChoice = sc.nextInt(); 

                         switch (userChoice){
                             case 1: // Client management
                                 valid = true;
                                 valid = false;
    
                                    do { //Switch for each operation of client management
                                    System.out.print("\nWhich operation would you like to perform?" + 
                                    "\n 1. Add a client" + 
                                    "\n 2. Edit a client" + 
                                    "\n 3. Delete a client" + 
                                    "\n 4. List all clients" + 
                                    "\n Operation: ");
                                    userChoice = sc.nextInt(); 
                                        switch (userChoice){
                                             case 1:
                                                valid = true;
                                             break;
                                            
                                             case 2: 
                                                valid = true;
                                                break;

                                             case 3: 
                                                valid = true;
                                                break;
                                        
                                             case 4: 
                                                valid = true;
                                                break;
                                             default: 
                                                System.out.println("You entered a number that is not an available option. Please try again.\n");
                                                            } 
                                                    }while (!valid);
                                 break;
                    
                             case 2: // Trip management
                                 valid = true;
                                 valid = false;
    
                                    do { // Switch for each operation of trip management
                                    System.out.print("\nWhich operation would you like to perform?" + 
                                    "\n 1. Create a trip" + 
                                    "\n 2. Edit trip information" + 
                                    "\n 3. Cancel a trip" + 
                                    "\n 4. List all trips" + 
                                    "\n 5. List all trips for a specific client" +
                                    "\n Operation: ");
                                    userChoice = sc.nextInt(); 
                                        switch (userChoice){
                                             case 1:
                                                valid = true;
                                                break;
                                            
                                             case 2: 
                                                valid = true;
                                                break;

                                             case 3: 
                                                valid = true;
                                                break;
                                        
                                             case 4: 
                                                valid = true;
                                                break;

                                             case 5: 
                                                valid = true;
                                                break;
                                             default: 
                                                System.out.println("You entered a number that is not an available option. Please try again.\n");
                                                            } 
                                                    }while (!valid);
                                 break;

                             case 3: // Transportation management
                                 valid = true;
                                 valid = false;
    
                                    do { // Switch for each operation of transportation management
                                    System.out.print("\nWhich operation would you like to perform?" + 
                                    "\n 1. Add a transportation option" + 
                                    "\n 2. Remove a transportation option" + 
                                    "\n 3. List transportation options by type (Flight, Train, Bus)" +
                                    "\n Operation: ");
                                    userChoice = sc.nextInt(); 
                                        switch (userChoice){
                                             case 1:
                                                valid = true;
                                                break;
                                            
                                             case 2: 
                                                valid = true;
                                                break;

                                             case 3: 
                                                valid = true;
                                                break;
                                        
                                             default: 
                                                System.out.println("You entered a number that is not an available option. Please try again.\n");
                                                            } 
                                                    }while (!valid);
                                 break;
                        
                             case 4: // Accommodation management
                                 valid = true;
                                 valid = false;
    
                                    do { // Switch for each operation of accommodation management
                                    System.out.print("\nWhich operation would you like to perform?" + 
                                    "\n 1. Add an accommodation" + 
                                    "\n 2. Remove an accommodation" + 
                                    "\n 3. List accommodations by type (Hotel, Hostel)" +
                                    "\n Operation: ");
                                    userChoice = sc.nextInt(); 
                                        switch (userChoice){
                                             case 1:
                                                valid = true;
                                                break;
                                            
                                             case 2: 
                                                valid = true;
                                                break;

                                             case 3: 
                                                valid = true;
                                                break;
                                        
                                             default: 
                                                System.out.println("You entered a number that is not an available option. Please try again.\n");
                                                            } 
                                                    }while (!valid);
                                 break;
                        
                             case 5: // Additional operations
                                 valid = true;
                                 valid = false;
    
                                    do { // Switch for each operation of Additional operations
                                    System.out.print("\nWhich operation would you like to perform?" + 
                                    "\n 1. Display the most expensive trip" + 
                                    "\n 2. Calculate and display the total cost of a trip" + 
                                    "\n 3. Create a deep copy of the transportation array" + 
                                    "\n 4. Create a deep copy of the accommodation array" + 
                                    "\n Operation: ");
                                    userChoice = sc.nextInt(); 
                                        switch (userChoice){
                                             case 1:
                                                valid = true;
                                                 break;
                                            
                                             case 2: 
                                                valid = true;
                                                break;

                                             case 3: 
                                                valid = true;
                                                break;
                                        
                                             case 4: 
                                                valid = true;
                                                break;

                                             default: 
                                                System.out.println("You entered a number that is not an available option. Please try again.\n");
                                                            } 
                                                    }while (!valid);
                                break;
                        
                             case 6: // Generate visualization 
                                 valid = true;
                                 valid = false;
    
                                    do { // Switch for each operation of visualization 
                                    System.out.print("\nWhich operation would you like to perform?" + 
                                    "\n 1. Bar chart (Trip Cost)" + 
                                    "\n 2. Pie chart (Trips per destination)" + 
                                    "\n 3. Line chart (Duration over time)" + 
                                    "\n Operation: ");
                                    userChoice = sc.nextInt(); 
                                        switch (userChoice){
                                             case 1:
                                                valid = true;
                                                 break;
                                            
                                             case 2: 
                                                valid = true;
                                                break;

                                             case 3: 
                                                valid = true;
                                                break;
 
                                             default: 
                                                System.out.println("You entered a number that is not an available option. Please try again.\n");
                                                            } 
                                                    }while (!valid);
                                break;

                             default: 
                                System.out.println("You entered a number that is not an available option. Please try again.\n");
                            }
                    } while (!valid);
                break;

            default: 
            System.out.println("You entered a number that is not an available option. Please try again.\n");
         }

    
    } while (!valid);



    sc.close();
  }
} 