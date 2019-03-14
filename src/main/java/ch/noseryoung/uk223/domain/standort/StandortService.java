package ch.noseryoung.uk223.domain.standort;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * This class holds all data access related methods targeted towards the
 * entity standort.
 * 
 * @author Moritz Lauper
 */
@Service
public class StandortService {
	
	private StandortRepository standortRepository;
	
	public Optional<Standort> findById(Long id) {
		Optional<Standort> standort = standortRepository.findById(id);
		return standort;
	}
	
	public List<Standort> findAll() {
		List<Standort> standorts = standortRepository.findAll();
		return standorts;
	}
	
	public void save(Standort standort) {
		standortRepository.save(standort);
	}
	
	public boolean update(Standort standort, Long id) {
		Optional<Standort> currentStandort = standortRepository.findById(id);
		if (currentStandort.isPresent()) {
			standort.setId(id);
		} else {
			return false;
		}
		
		standortRepository.save(standort);
		return true;
	}
	
	public void deleteById(Long id) {
		standortRepository.deleteById(id);
	}
	
}
