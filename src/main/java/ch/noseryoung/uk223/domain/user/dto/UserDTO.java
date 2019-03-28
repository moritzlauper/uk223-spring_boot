package ch.noseryoung.uk223.domain.user.dto;

import ch.noseryoung.uk223.domain.address.dto.AddressDTO;

public class UserDTO {

	private Long id;

	private String firstName;
	
	private String lastName;
	
	private String email;

	private AddressDTO address;

	public UserDTO() {}

	public UserDTO(Long id, String firstName, String lastName, String email, AddressDTO address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}
}
