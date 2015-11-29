/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import project.persistence.entities.SoundClip;
import project.service.DatabaseConnector;
import project.service.Searcher;

/**
 *
 * @author IceR
 */
@Controller
public class SearchController
{
	Searcher searcher;
	
	@Autowired
	public SearchController(Searcher searcher) {
	   this.searcher = searcher;
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Model model){
		searcher.setSearchTerm("");
		searcher.search(model);

		return "Search";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(Model model, @RequestParam("term") String searchTerm){
		if (!searchTerm.equals("")) {
			searcher.setSearchTerm(searchTerm);
			searcher.search(model);
		} else {
			model.addAttribute("errMsg", "Please type something into the search window.");
		}

		return "Search";
	}
}
