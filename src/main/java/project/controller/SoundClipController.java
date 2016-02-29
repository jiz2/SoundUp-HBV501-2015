package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.SoundClip;
import javax.servlet.http.HttpSession;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import project.service.SoundClipService;

@Controller
public class SoundClipController {
    SoundClipService scService;

    @Autowired
    public SoundClipController(SoundClipService scService) {
        this.scService = scService;
    }

    @RequestMapping(value = "/soundclip/play/{url}", method = RequestMethod.GET)
    public String findByUrl(Model model, HttpSession session, @PathVariable String url){
		try {
			SoundClip sc = this.scService.findByUrl(url);
            model.addAttribute("soundclip", sc);
        } catch (Exception e) {
            System.err.println("Could not get clip: " + e.getMessage());
        }
		model.addAttribute("action", "Play");
        return "SoundClip";
    }
	
	@RequestMapping(value = "/soundclip/upload", method = RequestMethod.GET)
	public String upload(Model model){
		model.addAttribute("action", "Success");
		return "SoundClip";
	}

	@RequestMapping(value = "/soundclip/upload", method = RequestMethod.POST)
	public String upload(Model model, @RequestParam("file") MultipartFile file, @RequestParam("private") boolean isPrivate, HttpSession session){
		String url = "";
		if (!file.isEmpty()) {
			try {
				url = this.scService.upload(model, session, file, isPrivate);
			} catch (Exception e) {
				model.addAttribute("err", e.getMessage());
			}
		} else {
			model.addAttribute("err", "Please select a file for upload!");
		}
		model.addAttribute("soundclip", this.scService.findByUrl(url));
		model.addAttribute("action", "Success");
		return "SoundClip";
	}
	
	@RequestMapping(value = "/soundclip/search", method = RequestMethod.GET)
	public String findAllLike(Model model, @RequestParam("searchTerm") String searchTerm){
		if (searchTerm.equals("")) {
			model.addAttribute("err", "Please type something into the search window.");
		} else {
			List<SoundClip> Soundclips = this.scService.findAllLike(searchTerm);
			model.addAttribute("searchTerm", searchTerm);
			model.addAttribute("soundclips", Soundclips.toArray());
		}
		model.addAttribute("action", "Search results");
		return "SoundClip";
	}
}
