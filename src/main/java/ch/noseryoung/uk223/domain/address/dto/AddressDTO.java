package ch.noseryoung.uk223.domain.address.dto;

public class AddressDTO {

	private Long id;

	private String street;
	
	private String street_number;
	
	private String zip;
	
	private String city;
	
	public AddressDTO() {}

	public AddressDTO(Long id, String street, String street_number, String zip, String city) {
		this.id = id;
		this.street = street;
		this.street_number = street_number;
		this.zip = zip;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet_number() {
		return street_number;
	}

	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
