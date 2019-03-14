package ch.noseryoung.uk223.domain.Schnuppertag;

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
 * This class holds the endpoints for the entity schnuppertag.
 * 
 * @author Moritz Lauper
 */
@RestController
@RequestMapping("/schnuppertage")
public class SchnuppertagController {
	
	private SchnuppertagService schnuppertagService;
	
	/**
	 * @param schnuppertagService
	 */
	@Autowired
	public SchnuppertagController(SchnuppertagService schnuppertagService) {
		this.schnuppertagService = schnuppertagService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Schnuppertag> getById(@PathVariable Long id) {
		Optional<Schnuppertag> schnuppertag = schnuppertagService.findById(id);
		
		if (schnuppertag.isPresent()) {
			return new ResponseEntity<>(schnuppertag.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping({ "", "/" })
	public ResponseEntity<List<Schnuppertag>> getAll() {
		List<Schnuppertag> schnuppertags = schnuppertagService.findAll();
		
		return new ResponseEntity<>(schnuppertags, HttpStatus.OK);
	}
	
	@PostMapping({ "", "/" })
	public ResponseEntity<Schnuppertag> create(@Valid @RequestBody Schnuppertag schnuppertag) {
		schnuppertagService.save(schnuppertag);
		
		return new ResponseEntity<>(schnuppertag, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Schnuppertag> updateById(@PathVariable Long id, @Valid @RequestBody Schnuppertag schnuppertag) {
		HttpStatus status = ((schnuppertagService.update(schnuppertag, id)) ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(schnuppertag, status);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		schnuppertagService.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
