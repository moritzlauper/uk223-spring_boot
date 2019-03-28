package ch.noseryoung.uk223.domain.address;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import ch.noseryoung.uk223.domain.address.dto.AddressDTO;
import ch.noseryoung.uk223.domain.address.dto.AddressMapper;
import ch.noseryoung.uk223.domain.address.validation.AddressValidator;

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
	
	private AddressValidator addressValidator;
	
	/**
	 * @param addressService
	 */
	@Autowired
	public AddressController(AddressService addressService, AddressMapper addressMapper, AddressValidator addressValidator) {
		this.addressService = addressService;
		this.addressMapper = addressMapper;
		this.addressValidator = addressValidator;
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.addValidators(addressValidator);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AddressDTO> getById(@PathVariable Long id) {
		Optional<Address> address = addressService.findById(id);
		
		return new ResponseEntity<>(addressMapper.toDTO(address.get()), HttpStatus.OK);
	}
	
	@GetMapping({ "", "/" })
	public ResponseEntity<List<AddressDTO>> getAll() {
		List<Address> addresses = addressService.findAll();
		
		return new ResponseEntity<>(addressMapper.toDTOs(addresses), HttpStatus.OK);
	}
	
	@PostMapping({ "", "/" })
	public ResponseEntity<AddressDTO> create(@Valid @RequestBody AddressDTO addressDto) {
	    var address = addressMapper.fromDTO(addressDto);
		addressService.save(address);
		
		return new ResponseEntity<>(addressMapper.toDTO(address), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AddressDTO> updateById(@PathVariable Long id, @Valid @RequestBody AddressDTO addressDto) {
		addressService.update(addressMapper.fromDTO(addressDto), id);
		
		return new ResponseEntity<>(addressDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		addressService.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
