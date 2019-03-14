package ch.noseryoung.uk223.domain.berufsbildner;

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
 * This class holds the endpoints for the entity berufsbildner.
 * 
 * @author Moritz Lauper
 */
@RestController
@RequestMapping("/berufsbildner")
public class BerufsbildnerController {
	
	private BerufsbildnerService berufsbildnerService;
	
	/**
	 * @param berufsbildnerService
	 */
	@Autowired
	public BerufsbildnerController(BerufsbildnerService berufsbildnerService) {
		this.berufsbildnerService = berufsbildnerService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Berufsbildner> getById(@PathVariable Long id) {
		Optional<Berufsbildner> berufsbildner = berufsbildnerService.findById(id);
		
		if (berufsbildner.isPresent()) {
			return new ResponseEntity<>(berufsbildner.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping({ "", "/" })
	public ResponseEntity<List<Berufsbildner>> getAll() {
		List<Berufsbildner> berufsbildners = berufsbildnerService.findAll();
		
		return new ResponseEntity<>(berufsbildners, HttpStatus.OK);
	}
	
	@PostMapping({ "", "/" })
	public ResponseEntity<Berufsbildner> create(@Valid @RequestBody Berufsbildner berufsbildner) {
		berufsbildnerService.save(berufsbildner);
		
		return new ResponseEntity<>(berufsbildner, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Berufsbildner> updateById(@PathVariable Long id, @Valid @RequestBody Berufsbildner berufsbildner) {
		HttpStatus status = ((berufsbildnerService.update(berufsbildner, id)) ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(berufsbildner, status);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		berufsbildnerService.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
