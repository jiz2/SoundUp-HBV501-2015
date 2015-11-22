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
     * Returns the string that is passed to the method with the First Character in Upper Case
     * @param soundURI String to have its first character converted to Upper Case
     * @return String
     */
    public String makeUrl(String soundURI){
    	String url = "This is a fake Url to \'" + soundURI + "\'";
    	return url;
    }
}
