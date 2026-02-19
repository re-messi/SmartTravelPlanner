package driver;

import java.util.Scanner;

public class SmartTravelDriver {
    public static void main(String[] args) {

    System.out.println("Welcome to the SmartTravel Mannaging Program");

    Scanner sc = new Scanner(System.in);
    int userChoice; 
    boolean valid = false;
    
    do {
    System.out.print("What would you like to do? Please enter the number of the option you desire" +
    "\n 1. See predefined testing scenario" +
    "\n 2. Access the Menu Operations\n");
    userChoice = sc.nextInt();
     
        switch (userChoice) {
            case 1:
                valid = true;
                break;

            case 2: 
                valid = true;
                break;

            default: 
            System.out.println("You entered a number that is not an available option. Please try again.");
         }

    
    } while (!valid);



    sc.close();
  }
} 