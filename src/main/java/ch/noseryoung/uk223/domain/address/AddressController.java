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

import ch.noseryoung.uk223.domain.address.Address;
import ch.noseryoung.uk223.domain.address.AddressService;
import ch.noseryoung.uk223.domain.address.dto.AddressDTO;
import ch.noseryoung.uk223.domain.address.dto.AddressMapper;

/**
 * This class holds the endpoints for the entity address.
 * 
 * @author Moritz Lauper
 */
@RestController
@RequestMapping("/addresses")
public class AddressController {
	
private AddressService addressService;
	
	private AddressMapper addressMapper;
	
	/**
	 * @param addressService
	 */
	@Autowired
	public AddressController(AddressService addressService, AddressMapper addressMapper) {
		this.addressService = addressService;
		this.addressMapper = addressMapper;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AddressDTO> getById(@PathVariable Long id) {
		Optional<Address> address = addressService.findById(id);
		
		if (address.isPresent()) {
			return new ResponseEntity<>(addressMapper.toDTO(address.get()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping({ "", "/" })
	public ResponseEntity<List<AddressDTO>> getAll() {
		List<Address> addresss = addressService.findAll();
		
		return new ResponseEntity<>(addressMapper.toDTOs(addresss), HttpStatus.OK);
	}
	
	@PostMapping({ "", "/" })
	public ResponseEntity<AddressDTO> create(@Valid @RequestBody Address address) {
		addressService.save(address);
		
		return new ResponseEntity<>(addressMapper.toDTO(address), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AddressDTO> updateById(@PathVariable Long id, @Valid @RequestBody AddressDTO addressDto) {
		HttpStatus status = ((addressService.update(addressMapper.fromDTO(addressDto), id)) ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(addressDto, status);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		addressService.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
