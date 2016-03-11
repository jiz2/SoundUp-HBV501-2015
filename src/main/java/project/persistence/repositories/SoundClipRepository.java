package project.persistence.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.SoundClip;

public interface SoundClipRepository extends JpaRepository<SoundClip, Long> {

	List<SoundClip> findByName(String s);
	List<SoundClip> findByExt(String s);
	SoundClip findByUrl(String url);
	List<SoundClip> findByUploader(String s);
	List<SoundClip> findByIsPrivate(String s);
	
	@Query("SELECT s FROM SoundClip s WHERE UPPER(s.name) LIKE %?1%")
	List<SoundClip> findAllLike(String search);
}
