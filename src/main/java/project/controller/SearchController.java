/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author IceR
 */
@Controller
public class SearchController
{
	
	@Autowired
	public SearchController() {
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String upload(Model model, @RequestParam("searchTerm") String searchTerm){
		if (!searchTerm.equals("")) {
			searcher.setSearchTerm(searchTerm);
			searcher.search(model);
		} else {
			model.addAttribute("errMsg", "Please type a search term into the search field");
		}

		return "Search";
	}
}
