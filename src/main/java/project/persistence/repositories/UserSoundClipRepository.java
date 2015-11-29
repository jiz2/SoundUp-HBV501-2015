package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import project.persistence.entities.UserSoundClip;

import java.util.List;

/**
 * By extending the {@link JpaRepository} we have access to powerful methods.
 * For detailed information, see:
 * http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 * http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
 *
 */
public interface UserSoundClipRepository extends JpaRepository<UserSoundClip, Long> {

    UserSoundClip save(UserSoundClip userSoundClip);

    void delete(UserSoundClip userSoundClip);

    List<UserSoundClip> findAll();

    // Instead of the method findAllReverseOrder() in SoundClipService.java,
    // We could have used this method by adding the words
    // ByOrderByIdDesc, which mean: Order By Id in a Descending order
    //
    List<UserSoundClip> findAllByOrderByIdDesc();

    UserSoundClip findOne(Long id);

    List<UserSoundClip> findByName(String name);
}
