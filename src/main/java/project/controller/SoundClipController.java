package project.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.SoundClip;
import javax.servlet.http.HttpSession;
import java.util.Base64;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import project.persistence.entities.User;
import project.service.SoundClipService;

@Controller
@RequestMapping("/soundclip")
public class SoundClipController {
    private final SoundClipService soundClipService;

    @Autowired
    public SoundClipController(SoundClipService soundClipService) {
        this.soundClipService = soundClipService;
    }

    @RequestMapping(value = "/play/{name}.{ext}", method = RequestMethod.GET)
    public String findByUrl(Model model, HttpSession session, @PathVariable String name, @PathVariable String ext){
		try {
			System.out.println(name);
			SoundClip sc = this.soundClipService.findByName(name).get(0);
            model.addAttribute("soundclip", sc);
        } catch (Exception e) {
            System.err.println("Could not get clip: " + e.getMessage());
        }
		model.addAttribute("action", "Play");
        return "SoundClip";
    }
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String getUpload(Model model){
		model.addAttribute("action", "Upload");
		return "SoundClip";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String postUpload(Model model, @RequestParam("file") MultipartFile file, @RequestParam("private") boolean isPrivate, HttpSession session) throws IOException{
		if (!file.isEmpty()) {
			String[] type = file.getContentType().split("/");
			if (!type[0].equalsIgnoreCase("audio")) {
				model.addAttribute("err", "Make sure you choose a valid audio file.");
				return "Index";
			}
			try {
				User u = (User) session.getAttribute("user");
				String uploader = null;
				if(u != null && !u.getName().equals("")){
					uploader = u.getName();
				} else {
					isPrivate = false;
				}
				String data = Base64.getEncoder().encodeToString(file.getBytes());
				SoundClip newClip = new SoundClip(file.getOriginalFilename().split("\\.(?=[^\\.]+$)")[0], type[1], data, uploader, isPrivate);
				this.soundClipService.save(newClip);

				model.addAttribute("soundclip", newClip);
			} catch (IOException e) {
				model.addAttribute("err", e.getMessage());
			}
		} else {
			model.addAttribute("err", "Please select a file for upload!");
			return "Index";
		}
		model.addAttribute("action", "Upload");
		return "SoundClip";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String findAllLike(Model model, HttpSession session, @RequestParam("searchTerm") String searchTerm){
		if (searchTerm.equals("")) {
			model.addAttribute("err", "Please type something into the search window.");
		} else {
			List<SoundClip> Soundclips = this.soundClipService.findAllLike(searchTerm);
			model.addAttribute("searchTerm", searchTerm);
			model.addAttribute("soundclips", Soundclips.toArray());
		}
		User u = (User) session.getAttribute("user");
		model.addAttribute("user", u);
		model.addAttribute("action", "Search results");
		return "SoundClip";
	}
}
