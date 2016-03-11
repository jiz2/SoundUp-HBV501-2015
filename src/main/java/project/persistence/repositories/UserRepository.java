package project.persistence.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByName(String name);
	
	@Query("SELECT s FROM User s WHERE UPPER(s.name) LIKE %?1%")
	List<User> findAllLike(String search);
}