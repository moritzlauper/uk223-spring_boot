package ch.noseryoung.uk223.domain.address.dto;

public class AddressDTO {
	
	private String street;
	
	private String street_number;
	
	private String zip;
	
	private String city;
	
	public AddressDTO() {}
	
	/**
	 * @param street
	 * @param street_number
	 * @param zip
	 * @param city
	 */
	public AddressDTO(String street, String street_number, String zip, String city) {
		this.street = street;
		this.street_number = street_number;
		this.zip = zip;
		this.city = city;
	}
	
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * @return the street_number
	 */
	public String getStreet_number() {
		return street_number;
	}
	
	/**
	 * @param street_number the street_number to set
	 */
	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}
	
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
}
