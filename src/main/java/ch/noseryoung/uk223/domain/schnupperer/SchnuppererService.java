package ch.noseryoung.uk223.domain.schnupperer;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * This class holds all data access related methods targeted towards the
 * entity schnupperer.
 * 
 * @author Moritz Lauper
 */
@Service
public class SchnuppererService {
	
	private SchnuppererRepository schnuppererRepository;
	
	public Optional<Schnupperer> findById(Long id) {
		Optional<Schnupperer> schnupperer = schnuppererRepository.findById(id);
		return schnupperer;
	}
	
	public List<Schnupperer> findAll() {
		List<Schnupperer> schnupperers = schnuppererRepository.findAll();
		return schnupperers;
	}
	
	public void save(Schnupperer schnupperer) {
		schnuppererRepository.save(schnupperer);
	}
	
	public boolean update(Schnupperer schnupperer, Long id) {
		Optional<Schnupperer> currentSchnupperer = schnuppererRepository.findById(id);
		if (currentSchnupperer.isPresent()) {
			schnupperer.setId(id);
		} else {
			return false;
		}
		
		schnuppererRepository.save(schnupperer);
		return true;
	}
	
	public void deleteById(Long id) {
		schnuppererRepository.deleteById(id);
	}
	
}
