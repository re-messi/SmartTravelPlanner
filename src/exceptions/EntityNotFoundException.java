package exceptions;

import client.Client;

//used when searching clients/trips/transportation/accommodations by ID
public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String message) {
        super(message);
    }


    
}
