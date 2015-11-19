package project.service;

import org.springframework.stereotype.Service;

/**
 * Service class that has methods for String Manipulation
 *
 * DISCLAIMER:  This class is just for demonstration purposes,
 *              something basic as this would be handled where it is needed
 */
@Service
public class DatabaseConnector {

    /**
     * Returns the string that is passed to the method with the First Character in Upper Case
     * @return String
     */
    public String getPathFromUser(){
        String path = "yourPathHere";
    	return path;
    }
}
