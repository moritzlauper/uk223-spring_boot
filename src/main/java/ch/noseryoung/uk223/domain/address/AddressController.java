package ch.noseryoung.uk223.domain.address;

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
 * This class holds the endpoints for the entity address.
 * 
 * @author Moritz Lauper
 */
@RestController
@RequestMapping("/addresses")
public class AddressController {
	
	private AddressService addressService;
	
	/**
	 * @param addressService
	 */
	@Autowired
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Address> getById(@PathVariable Long id) {
		Optional<Address> address = addressService.findById(id);
		
		if (address.isPresent()) {
			return new ResponseEntity<>(address.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping({ "", "/" })
	public ResponseEntity<List<Address>> getAll() {
		List<Address> addresss = addressService.findAll();
		
		return new ResponseEntity<>(addresss, HttpStatus.OK);
	}
	
	@PostMapping({ "", "/" })
	public ResponseEntity<Address> create(@Valid @RequestBody Address address) {
		addressService.save(address);
		
		return new ResponseEntity<>(address, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Address> updateById(@PathVariable Long id, @Valid @RequestBody Address address) {
		HttpStatus status = ((addressService.update(address, id)) ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(address, status);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		addressService.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
