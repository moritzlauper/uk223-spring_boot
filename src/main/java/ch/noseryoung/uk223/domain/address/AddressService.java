package ch.noseryoung.uk223.domain.address;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class holds all data access related methods targeted towards the
 * entity address.
 * 
 * @author Moritz Lauper
 */
@Service
public class AddressService {
	
	private AddressRepository addressRepository;
	
	/**
	 * @param addressRepository
	 */
	@Autowired
	public AddressService(AddressRepository addressRepository) {
		this.addressRepository = addressRepository;
	}
	
	public Optional<Address> findById(Long id) {
		Optional<Address> address = addressRepository.findById(id);
		return address;
	}
	
	public List<Address> findAll() {
		List<Address> addresses = addressRepository.findAll();
		return addresses;
	}
	
	public void save(Address address) {
		addressRepository.save(address);
	}
	
	public void update(Address newAddress, Long id) throws NoSuchElementException {
		Optional<Address> currentAddress = addressRepository.findById(id);
		if (currentAddress.isPresent()) {
			newAddress.setId(id);
			addressRepository.save(newAddress);
		} else {
		    throw new NoSuchElementException(String.format("No address with given id '%d' found", id));
		}
	}
	
	public void deleteById(Long id) {
		addressRepository.deleteById(id);
	}
	
}
