package ch.noseryoung.uk223.domain.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity user.
 * 
 * @author Moritz Lauper
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	
}
