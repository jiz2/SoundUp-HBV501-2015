package project.service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.SoundClip;
import project.persistence.repositories.SoundClipRepository;

import java.util.List;
import static java.util.UUID.randomUUID;
import javax.servlet.http.HttpSession;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SoundClipService {
    SoundClipRepository scRepo;

    @Autowired
    public SoundClipService(SoundClipRepository scRepo) {
        this.scRepo = scRepo;
    }

	@Transactional(readOnly=true)
    public SoundClip findByUrl(String name) {
        return this.scRepo.findByUrl(name);
    }

    @Transactional(readOnly=true)
    public List<SoundClip> findAllLike(String searchTerm) {
        return this.scRepo.findAllLike(searchTerm.toUpperCase());
    }
	
	public String upload(Model model, HttpSession session, MultipartFile file, boolean isPrivate) throws Exception {
		String url = "";
        // Make sure the file is valid
        String[] type = file.getContentType().split("/");
        if (type[0].equalsIgnoreCase("audio")) {
            //url = file.getOriginalFilename().replaceAll(" ", "_");
			url = randomUUID().toString(); //unique url
        } else {
            throw new Exception("This file type is not accepted.");
        }
		
        // Store the file in the database
        try {
			this.scRepo.save(new SoundClip(file.getOriginalFilename(), type[1], file.getBytes(), url, isPrivate));
        } catch (IOException ioe) {
            throw new Exception("Failed to upload the file. Please try again.");
        }

        return url;
    }
}
