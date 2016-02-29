package project.controller;

import com.google.gson.Gson;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.SoundClip;
import javax.servlet.http.HttpSession;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import project.service.SoundClipService;

@RestController
public class SoundClipRestController {
    SoundClipService scService;
	private final String RESTAPIURL = "/rest/api";

    @Autowired
    public SoundClipRestController(SoundClipService scService) {
        this.scService = scService;
    }

    @RequestMapping(value = RESTAPIURL+"/soundclip/play/{url}", method = RequestMethod.GET)
    public String findByUrl(Model model, HttpSession session, @PathVariable String url){
		try {
			SoundClip sc = this.scService.findByUrl(url);
            return sc.getBase64Str();
        } catch (Exception e) {
            System.err.println("Could not get clip: " + e.getMessage());
        }
        return "Play";
    }

	@RequestMapping(value = RESTAPIURL+"/soundclip/upload", method = RequestMethod.POST)
	public String upload(Model model, @RequestParam("file") MultipartFile file, @RequestParam("private") boolean isPrivate, HttpSession session){
		String url = "";
		if (!file.isEmpty()) {
			try {
				url = this.scService.upload(model, session, file, isPrivate);
				//this.scService.findByUrl(url)
				return url;
			} catch (Exception e) {
				return e.getMessage();
			}
		} else {
			return "Please select a file for upload!";
		}
	}
	
	@RequestMapping(value = RESTAPIURL+"/soundclip/search", method = RequestMethod.GET)
	public String findAllLike(Model model, @RequestParam("searchTerm") String searchTerm){
		if (searchTerm.equals("")) {
			return "Please type something into the search window.";
		} else {
			List<SoundClip> scList = this.scService.findAllLike(searchTerm);
			scList = new ArrayList<SoundClip>(scList);
			return new Gson().toJson(scList);
		}
	}
}
