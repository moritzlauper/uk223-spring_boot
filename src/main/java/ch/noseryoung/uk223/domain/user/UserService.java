package ch.noseryoung.uk223.domain.user;

import java.util.List;
import java.util.NoSuchElementException;
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
	
	public void update(User newUser, Long id) throws NoSuchElementException {
		Optional<User> currentUser = userRepository.findById(id);
		if (currentUser.isPresent()) {
			newUser.setId(id);
			userRepository.save(newUser);
		} else {
			throw new NoSuchElementException(String.format("No user with given id '%d' found", id));
		}
	}
	
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	
}
