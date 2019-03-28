package ch.noseryoung.uk223.domain.user;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.noseryoung.cecile.webContext.domain.authority.Authority;
import ch.noseryoung.uk223.domain.user.dto.UserDTO;
import ch.noseryoung.uk223.domain.user.dto.UserMapper;
import ch.noseryoung.uk223.domain.user.validation.UserValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * This class holds the endpoints for the entity user.
 * 
 * @author Moritz Lauper
 */
@RestController
@RequestMapping("/users")
@Api(
		value = "UserController"
	)
public class UserController {
	
	private UserService userService;
	
	private UserMapper userMapper;
	
	private UserValidator userValidator;
	
	/**
	 * @param userService
	 */
	@Autowired
	public UserController(UserService userService, UserMapper userMapper, UserValidator userValidator) {
		this.userService = userService;
		this.userMapper = userMapper;
		this.userValidator = userValidator;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.addValidators(userValidator);
	}
	
	@ApiOperation(
			value = "This endpoint returns the user with the given id.",
			response = UserDTO.class
		)
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
		Optional<User> user = userService.findById(id);
		
		return new ResponseEntity<>(userMapper.toDTO(user.get()), HttpStatus.OK);
	}
	
	@ApiOperation(
			value = "This endpoint returns all users.",
			response = UserDTO.class
		)
	@GetMapping({ "", "/" })
	public ResponseEntity<List<UserDTO>> getAll() {
		List<User> users = userService.findAll();
		
		return new ResponseEntity<>(userMapper.toDTOs(users), HttpStatus.OK);
	}
	
	@ApiOperation(
			value = "This endpoint creates a user.",
			response = UserDTO.class
		)
	@PostMapping({ "", "/" })
	public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO userDto) {
		var user = userMapper.fromDTO(userDto);
		userService.save(user);
		
		return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.CREATED);
	}
	
	@ApiOperation(
			value = "This endpoint updates the user with the given id.",
			response = UserDTO.class
		)
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updateById(@PathVariable Long id, @Valid @RequestBody UserDTO userDto) {
		userService.update(userMapper.fromDTO(userDto), id);
		
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
	
	@ApiOperation(
			value = "This endpoint deletes the user with the given id.",
			response = UserDTO.class
		)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		userService.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
