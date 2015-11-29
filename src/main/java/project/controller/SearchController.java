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
import project.service.DatabaseConnector;;

/**
 *
 * @author IceR
 */
@Controller
public class SearchController
{
	DatabaseConnector dbCon;

	@Autowired
	public SearchController(DatabaseConnector dbCon) {
		this.dbCon = dbCon;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String upload(Model model, @RequestParam("srch-term") String searchTerm){
		
		if (searchTerm.equals("")) {
			model.addAttribute("errMsg", "We couldn't find anything!");
		} else {
			String results = dbCon.searchSoundClips(searchTerm);
			model.addAttribute("searchTerm", searchTerm);
			model.addAttribute("results", results);
		}
		
		return "Search";
	}
}
