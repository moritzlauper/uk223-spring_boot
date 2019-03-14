package ch.noseryoung.uk223.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity user.
 * 
 * @author Moritz Lauper
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
