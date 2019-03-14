package ch.noseryoung.uk223.domain.fachrichtung;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity fachrichtung.
 * 
 * @author Moritz Lauper
 */
@Repository
public interface FachrichtungRepository extends JpaRepository<Fachrichtung, Long>{
	
}
