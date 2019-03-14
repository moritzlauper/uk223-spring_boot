package ch.noseryoung.uk223.domain.fachrichtung;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * This class holds all data access related methods targeted towards the
 * entity fachrichtung.
 * 
 * @author Moritz Lauper
 */
@Service
public class FachrichtungService {
	
	private FachrichtungRepository fachrichtungRepository;
	
	public Optional<Fachrichtung> findById(Long id) {
		Optional<Fachrichtung> fachrichtung = fachrichtungRepository.findById(id);
		return fachrichtung;
	}
	
	public List<Fachrichtung> findAll() {
		List<Fachrichtung> fachrichtungs = fachrichtungRepository.findAll();
		return fachrichtungs;
	}
	
	public void save(Fachrichtung fachrichtung) {
		fachrichtungRepository.save(fachrichtung);
	}
	
	public boolean update(Fachrichtung fachrichtung, Long id) {
		Optional<Fachrichtung> currentFachrichtung = fachrichtungRepository.findById(id);
		if (currentFachrichtung.isPresent()) {
			fachrichtung.setId(id);
		} else {
			return false;
		}
		
		fachrichtungRepository.save(fachrichtung);
		return true;
	}
	
	public void deleteById(Long id) {
		fachrichtungRepository.deleteById(id);
	}
	
}
