package project.service;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.SoundClip;
import project.persistence.repositories.SoundClipRepository;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service("soundClipService")
@Transactional
public class SoundClipService {
    SoundClipRepository scRepo;

    @Autowired
    public SoundClipService(SoundClipRepository scRepo) {
        this.scRepo = scRepo;
    }

	public SoundClip save(SoundClip sc){
		return this.scRepo.save(sc);
	}

	public long count(){
		return this.scRepo.count();
	}

	public void delete(SoundClip sc){
		this.scRepo.delete(sc);
	}

	public void deleteAll(){
		this.scRepo.deleteAll();
	}

	public List<SoundClip> findAll(){
		return this.scRepo.findAll();
	}

	public SoundClip findById(long id){
		return this.scRepo.findById(id);
	}
	
	public List<SoundClip> findByName(String s){
		return this.scRepo.findByName(s);
	}
	
	public List<SoundClip> findByExt(String s){
		return this.scRepo.findByExt(s);
	}
	
	public List<SoundClip> findByUploader(String s) {
        return this.scRepo.findByUploader(s);
    }
	
	public List<SoundClip> findByIsPrivate(String s){
		return this.scRepo.findByIsPrivate(s);
	}
	
	public List<SoundClip> findAllLike(String s) {
		return this.scRepo.findAllLike(s.toUpperCase());
	}

	public boolean exists(String name) {
		return !findByName(name).isEmpty();
	}
}
