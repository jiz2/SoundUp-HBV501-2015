package project.service;

import org.springframework.stereotype.Service;

import project.service.WebGenerator;

/**
 * Service class that has methods for Uploading
 *
 * DISCLAIMER:  This class is just for demonstration purposes,
 *              something basic as this would be handled where it is needed
 */
@Service
public class Uploader {
	
	private path;
	private webgen;

    /**
     * Sets the local URI of the file for upload
     * @param local URI of the file to be uploaded
     * @return nothing
     */
    public void setPath(String localPath){
        this.path = localPath;
    }
	
	/**
     * Uploads the file with preentered path
     * @param model Model to pass result arguments
     * @return nothing
     */
    public void upload(Model model){
    	
    }
}
