/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import project.persistence.entities.SoundClip;

/**
 *
 * @author IceR
 */
@Service
public class Searcher
{
    // Instance Variables
    private String search;
    DatabaseConnector dbCon;
    
    // Dependency Injection
    @Autowired
    public Searcher(DatabaseConnector dbCon) {
        this.dbCon = dbCon;
    }

    /**
    * Sets the search term that we are searching for.
    * @param search the search term.
    * @return nothing
    */
    public void setSearchTerm(String search) {
		this.search = search;
    }

    /**
    * Searches for all existing sound clips that contain the search term.
    * @param model Model to pass result arguments
    * @return nothing
    */
    public void search(Model model) {
		List<SoundClip> results = dbCon.searchSoundClips(search);

        // Now let's add the attributes to the model
		model.addAttribute("searchTerm", search);
        model.addAttribute("results", results);

        // Reset name
        search = new String();
    }
}
