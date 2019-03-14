package ch.noseryoung.uk223.domain.Schnuppertag;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

/**
 * This class holds all data access related methods targeted towards the
 * entity schnuppertag.
 * 
 * @author Moritz Lauper
 */
@Service
public class SchnuppertagService {
	
	private SchnuppertagRepository schnuppertagRepository;
	
	public Optional<Schnuppertag> findById(Long id) {
		Optional<Schnuppertag> schnuppertag = schnuppertagRepository.findById(id);
		return schnuppertag;
	}
	
	public List<Schnuppertag> findAll() {
		List<Schnuppertag> schnuppertags = schnuppertagRepository.findAll();
		return schnuppertags;
	}
	
	public void save(Schnuppertag schnuppertag) {
		schnuppertagRepository.save(schnuppertag);
	}
	
	public boolean update(Schnuppertag schnuppertag, Long id) {
		Optional<Schnuppertag> currentSchnuppertag = schnuppertagRepository.findById(id);
		if (currentSchnuppertag.isPresent()) {
			schnuppertag.setId(id);
		} else {
			return false;
		}
		
		schnuppertagRepository.save(schnuppertag);
		return true;
	}
	
	public void deleteById(Long id) {
		schnuppertagRepository.deleteById(id);
	}
	
}
