package ch.noseryoung.uk223.domain.user;

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

import ch.noseryoung.uk223.domain.user.dto.UserDTO;
import ch.noseryoung.uk223.domain.user.dto.UserMapper;

/**
 * This class holds the endpoints for the entity user.
 * 
 * @author Moritz Lauper
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	
	private UserMapper userMapper;
	
	/**
	 * @param userService
	 */
	@Autowired
	public UserController(UserService userService, UserMapper userMapper) {
		this.userService = userService;
		this.userMapper = userMapper;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
		Optional<User> user = userService.findById(id);
		
		if (user.isPresent()) {
			return new ResponseEntity<>(userMapper.toDTO(user.get()), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping({ "", "/" })
	public ResponseEntity<List<UserDTO>> getAll() {
		List<User> users = userService.findAll();
		
		return new ResponseEntity<>(userMapper.toDTOs(users), HttpStatus.OK);
	}
	
	@PostMapping({ "", "/" })
	public ResponseEntity<UserDTO> create(@Valid @RequestBody User user) {
		userService.save(user);
		
		return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateById(@PathVariable Long id, @Valid @RequestBody UserDTO userDto) {
		HttpStatus status = ((userService.update(userMapper.fromDTO(userDto), id)) ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(userDto, status);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		userService.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
