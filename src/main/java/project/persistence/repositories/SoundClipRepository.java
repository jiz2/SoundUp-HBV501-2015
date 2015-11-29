package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.SoundClip;

import java.util.List;
import org.springframework.data.repository.query.Param;

/**
 * By extending the {@link JpaRepository} we have access to powerful methods.
 * For detailed information, see:
 * http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 * http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
 *
 */
public interface SoundClipRepository extends JpaRepository<SoundClip, Long> {

    SoundClip save(SoundClip soundClip);

    void delete(SoundClip soundClip);

    List<SoundClip> findAll();

    // Instead of the method findAllReverseOrder() in SoundClipService.java,
    // We could have used this method by adding the words
    // ByOrderByIdDesc, which mean: Order By Id in a Descending order
    //
    List<SoundClip> findAllByOrderByIdDesc();

    SoundClip findOne(Long id);

    List<SoundClip> findByName(String name);
	
	@Query("SELECT data FROM soundclip WHERE name LIKE %:search%")
	List<SoundClip> findAllLike(@Param("search") String search);
}
