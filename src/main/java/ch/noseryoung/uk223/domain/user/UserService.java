package ch.noseryoung.uk223.domain.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class holds all data access related methods targeted towards the
 * entity user.
 * 
 * @author Moritz Lauper
 */
@Service
public class UserService {
	
	private UserRepository userRepository;
	
	/**
	 * @param userRepository
	 */
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Optional<User> findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}
	
	public List<User> findAll() {
		List<User> users = userRepository.findAll();
		return users;
	}
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public boolean update(User user, Long id) {
		Optional<User> currentUser = userRepository.findById(id);
		if (currentUser.isPresent()) {
			user.setId(id);
		} else {
			return false;
		}
		
		userRepository.save(user);
		return true;
	}
	
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	
}
