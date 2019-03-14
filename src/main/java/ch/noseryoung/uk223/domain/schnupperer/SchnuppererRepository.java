package ch.noseryoung.uk223.domain.schnupperer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity schnupperer.
 * 
 * @author Moritz Lauper
 */
@Repository
public interface SchnuppererRepository extends JpaRepository<Schnupperer, Long>{
	
}
