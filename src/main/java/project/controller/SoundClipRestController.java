package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.SoundClip;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import project.persistence.entities.SoundResult;
import project.service.SoundClipService;

@RestController
@RequestMapping("/rest/api/soundclip")
public class SoundClipRestController {
    private final SoundClipService soundClipService;

    @Autowired
    public SoundClipRestController(SoundClipService soundClipService) {
        this.soundClipService = soundClipService;
    }
	
	@RequestMapping(value = "/crud/", method = RequestMethod.GET)
    public ResponseEntity<List<SoundResult>> findAllSoundClips() {

        List<SoundClip> soundClips = soundClipService.findAll();
        //HttpStatus.NO_CONTENT
        if(soundClips.isEmpty()) return new ResponseEntity<List<SoundResult>>(HttpStatus.NOT_FOUND);

        // Convert SoundClips into their light-weight counterpart SoundResults
        List <SoundResult> soundResults = new ArrayList<SoundResult>();
        for (SoundClip sc: soundClips) soundResults.add(new SoundResult(sc));

        return new ResponseEntity<List<SoundResult>>(soundResults, HttpStatus.OK);
    }

    @RequestMapping(value = "/crud/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<SoundResult>> findSoundClip(@PathVariable("name") String name) {

        List<SoundClip> soundClips = soundClipService.findAllLike(name);
        //HttpStatus.NO_CONTENT
        if(soundClips.isEmpty()) return new ResponseEntity<List<SoundResult>>(HttpStatus.NOT_FOUND);

        // Convert SoundClips into their light-weight counterpart SoundResults
        List <SoundResult> soundResults = new ArrayList<SoundResult>();
        for (SoundClip sc: soundClips) soundResults.add(new SoundResult(sc));

        return new ResponseEntity<List<SoundResult>>(soundResults, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/crud/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SoundClip> findSoundClip(@PathVariable("id") long id) {
        System.out.println("Fetching SoundClip with id " + id);
        SoundClip soundClip = soundClipService.findById(id);
        if (soundClip == null) {
            System.out.println("SoundClip with id " + id + " not found");
            return new ResponseEntity<SoundClip>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SoundClip>(soundClip, HttpStatus.OK);
    }

    @RequestMapping(value = "/crud/", method = RequestMethod.POST)
    public ResponseEntity<Void> createSoundClip(@RequestBody SoundClip soundClip, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating SoundClip " + soundClip.getName());
        if (soundClipService.exists(soundClip.getName())) {
            System.out.println("A SoundClip with name " + soundClip.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        soundClipService.save(soundClip);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/soundClip/{id}").buildAndExpand(soundClip.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.ACCEPTED);
    }

//    @RequestMapping(value = "/crud/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<SoundClip> updateSoundClip(@PathVariable("id") long id, @RequestBody SoundClip soundClip) {
//        System.out.println("Updating SoundClip " + id);
//
//        SoundClip currentSoundClip = soundClipService.findById(id);
//
//        if (currentSoundClip==null) {
//            System.out.println("SoundClip with id " + id + " not found");
//            return new ResponseEntity<SoundClip>(HttpStatus.NOT_FOUND);
//        }
//
//        currentSoundClip.setName(soundClip.getName());
//
//        soundClipService.save(currentSoundClip);
//        return new ResponseEntity<SoundClip>(currentSoundClip, HttpStatus.OK);
//    }
 
//    @RequestMapping(value = "/crud/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<SoundClip> deleteSoundClip(@PathVariable("id") long id) {
//        System.out.println("Fetching & Deleting SoundClip with id " + id);
//
//        SoundClip soundClip = soundClipService.findById(id);
//        if (soundClip == null) {
//            System.out.println("Unable to delete. SoundClip with id " + id + " not found");
//            return new ResponseEntity<SoundClip>(HttpStatus.NOT_FOUND);
//        }
//
//        soundClipService.delete(soundClip);
//        return new ResponseEntity<SoundClip>(HttpStatus.NO_CONTENT);
//    }
 
//    @RequestMapping(value = "/crud/", method = RequestMethod.DELETE)
//    public ResponseEntity<SoundClip> deleteAllSoundClips() {
//        System.out.println("Deleting All SoundClips");
//        soundClipService.deleteAll();
//        return new ResponseEntity<SoundClip>(HttpStatus.NO_CONTENT);
//    }
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<SoundClip> findAllLike(@RequestParam("searchTerm") String searchTerm){
		return this.soundClipService.findAllLike(searchTerm);
	}
}
