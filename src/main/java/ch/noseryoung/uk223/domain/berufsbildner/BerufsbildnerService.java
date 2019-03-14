package ch.noseryoung.uk223.domain.berufsbildner;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * This class holds all data access related methods targeted towards the
 * entity berufsbildner.
 * 
 * @author Moritz Lauper
 */
@Service
public class BerufsbildnerService {
	
	private BerufsbildnerRepository berufsbildnerRepository;
	
	public Optional<Berufsbildner> findById(Long id) {
		Optional<Berufsbildner> berufsbildner = berufsbildnerRepository.findById(id);
		return berufsbildner;
	}
	
	public List<Berufsbildner> findAll() {
		List<Berufsbildner> berufsbildners = berufsbildnerRepository.findAll();
		return berufsbildners;
	}
	
	public void save(Berufsbildner berufsbildner) {
		berufsbildnerRepository.save(berufsbildner);
	}
	
	public boolean update(Berufsbildner berufsbildner, Long id) {
		Optional<Berufsbildner> currentBerufsbildner = berufsbildnerRepository.findById(id);
		if (currentBerufsbildner.isPresent()) {
			berufsbildner.setId(id);
		} else {
			return false;
		}
		
		berufsbildnerRepository.save(berufsbildner);
		return true;
	}
	
	public void deleteById(Long id) {
		berufsbildnerRepository.deleteById(id);
	}
	
}
