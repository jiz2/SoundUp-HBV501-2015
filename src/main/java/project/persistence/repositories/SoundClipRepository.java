package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.SoundClip;

import java.util.List;

/**
 * By extending the {@link JpaRepository} we have access to powerful methods.
 * For detailed information, see:
 * http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 * http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
 *
 */
public interface SoundClipRepository extends JpaRepository<SoundClip, Long> {

    SoundClip save(SoundClip soundClip);

	@Query("SELECT s FROM SoundClip s WHERE s.url = ?1")
	SoundClip findByUrl(String url);
	
	@Query("SELECT s FROM SoundClip s WHERE UPPER(s.name) LIKE %?1%")
	List<SoundClip> findAllLike(String search);
}
