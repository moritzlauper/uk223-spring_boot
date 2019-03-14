package ch.noseryoung.uk223.domain.Schnuppertag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity schnuppertag.
 * 
 * @author Moritz Lauper
 */
@Repository
public interface SchnuppertagRepository extends JpaRepository<Schnuppertag, Long>{
	
}
