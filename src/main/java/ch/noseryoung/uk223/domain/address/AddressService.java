package ch.noseryoung.uk223.domain.address;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Address> findById(Long id) {
		Optional<Address> address = addressRepository.findById(id);
		return address;
	}
	
	public List<Address> findAll() {
		List<Address> addresss = addressRepository.findAll();
		return addresss;
	}
	
	public void save(Address address) {
		addressRepository.save(address);
	}
	
	public boolean update(Address address, Long id) {
		Optional<Address> currentAddress = addressRepository.findById(id);
		if (currentAddress.isPresent()) {
			address.setId(id);
		} else {
			return false;
		}
		
		addressRepository.save(address);
		return true;
	}
	
	public void deleteById(Long id) {
		addressRepository.deleteById(id);
	}
	
}
