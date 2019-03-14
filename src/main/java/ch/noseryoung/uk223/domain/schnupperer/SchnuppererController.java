package ch.noseryoung.uk223.domain.schnupperer;

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
 * This class holds the endpoints for the entity schnupperer.
 * 
 * @author Moritz Lauper
 */
@RestController
@RequestMapping("/schnupperer")
public class SchnuppererController {
	
	private SchnuppererService schnuppererService;
	
	/**
	 * @param schnuppererService
	 */
	@Autowired
	public SchnuppererController(SchnuppererService schnuppererService) {
		this.schnuppererService = schnuppererService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Schnupperer> getById(@PathVariable Long id) {
		Optional<Schnupperer> schnupperer = schnuppererService.findById(id);
		
		if (schnupperer.isPresent()) {
			return new ResponseEntity<>(schnupperer.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping({ "", "/" })
	public ResponseEntity<List<Schnupperer>> getAll() {
		List<Schnupperer> schnupperers = schnuppererService.findAll();
		
		return new ResponseEntity<>(schnupperers, HttpStatus.OK);
	}
	
	@PostMapping({ "", "/" })
	public ResponseEntity<Schnupperer> create(@Valid @RequestBody Schnupperer schnupperer) {
		schnuppererService.save(schnupperer);
		
		return new ResponseEntity<>(schnupperer, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Schnupperer> updateById(@PathVariable Long id, @Valid @RequestBody Schnupperer schnupperer) {
		HttpStatus status = ((schnuppererService.update(schnupperer, id)) ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(schnupperer, status);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		schnuppererService.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
