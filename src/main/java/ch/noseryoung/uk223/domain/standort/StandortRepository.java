package ch.noseryoung.uk223.domain.standort;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity standort.
 * 
 * @author Moritz Lauper
 */
@Repository
public interface StandortRepository extends JpaRepository<Standort, Long>{
	
}
