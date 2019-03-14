package ch.noseryoung.uk223.domain.standort;

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
 * This class holds the endpoints for the entity standort.
 * 
 * @author Moritz Lauper
 */
@RestController
@RequestMapping("/standorte")
public class StandortController {
	
	private StandortService standortService;
	
	/**
	 * @param standortService
	 */
	@Autowired
	public StandortController(StandortService standortService) {
		this.standortService = standortService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Standort> getById(@PathVariable Long id) {
		Optional<Standort> standort = standortService.findById(id);
		
		if (standort.isPresent()) {
			return new ResponseEntity<>(standort.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping({ "", "/" })
	public ResponseEntity<List<Standort>> getAll() {
		List<Standort> standorts = standortService.findAll();
		
		return new ResponseEntity<>(standorts, HttpStatus.OK);
	}
	
	@PostMapping({ "", "/" })
	public ResponseEntity<Standort> create(@Valid @RequestBody Standort standort) {
		standortService.save(standort);
		
		return new ResponseEntity<>(standort, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Standort> updateById(@PathVariable Long id, @Valid @RequestBody Standort standort) {
		HttpStatus status = ((standortService.update(standort, id)) ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(standort, status);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		standortService.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
