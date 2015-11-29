package project.service;

import org.springframework.stereotype.Service;

/**
 * Service class that has methods for String Manipulation
 *
 * DISCLAIMER:  This class is just for demonstration purposes,
 *              something basic as this would be handled where it is needed
 */
@Service
public class WebGenerator {

    /**
     * Generates the url to the uploaded file
     * @param filename name of the uploaded file
     * @return String that is the url
     */
    public String makeUrl(String filename){
    	return "/clip/" + filename;
    }
}
