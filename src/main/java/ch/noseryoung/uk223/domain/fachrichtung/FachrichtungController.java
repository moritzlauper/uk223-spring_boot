package ch.noseryoung.uk223.domain.fachrichtung;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class holds the endpoints for the entity fachrichtung.
 * 
 * @author Moritz Lauper
 */
@RestController
@RequestMapping("/fachrichtungen")
public class FachrichtungController {
	
	private FachrichtungService fachrichtungService;
	
	/**
	 * @param fachrichtungService
	 */
	@Autowired
	public FachrichtungController(FachrichtungService fachrichtungService) {
		this.fachrichtungService = fachrichtungService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Fachrichtung> getById(@PathVariable Long id) {
		Optional<Fachrichtung> fachrichtung = fachrichtungService.findById(id);
		
		if (fachrichtung.isPresent()) {
			return new ResponseEntity<>(fachrichtung.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping({ "", "/" })
	public ResponseEntity<List<Fachrichtung>> getAll() {
		List<Fachrichtung> fachrichtungs = fachrichtungService.findAll();
		
		return new ResponseEntity<>(fachrichtungs, HttpStatus.OK);
	}
	
	@PostMapping({ "", "/" })
	public ResponseEntity<Fachrichtung> create(@Valid @RequestBody Fachrichtung fachrichtung) {
		fachrichtungService.save(fachrichtung);
		
		return new ResponseEntity<>(fachrichtung, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Fachrichtung> updateById(@PathVariable Long id, @Valid @RequestBody Fachrichtung fachrichtung) {
		HttpStatus status = ((fachrichtungService.update(fachrichtung, id)) ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(fachrichtung, status);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		fachrichtungService.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
