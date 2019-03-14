package ch.noseryoung.uk223.domain.berufsbildner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity berufsbildner.
 * 
 * @author Moritz Lauper
 */
@Repository
public interface BerufsbildnerRepository extends JpaRepository<Berufsbildner, Long>{
	
}
