package ch.noseryoung.uk223.domain.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Moritz Lauper
 */
@Entity
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "street_number")
	private String street_number;
	
	@Column(name = "zip")
	private String zip;
	
	@Column(name = "city")
	private String city;
	
	public Address() {}
	
	/**
	 * @param street
	 * @param street_number
	 * @param zip
	 * @param city
	 */
	public Address(String street, String street_number, String zip, String city) {
		this.street = street;
		this.street_number = street_number;
		this.zip = zip;
		this.city = city;
	}
	
	/**
	 * @param id
	 * @param street
	 * @param street_number
	 * @param zip
	 * @param city
	 */
	public Address(Long id, String street, String street_number, String zip, String city) {
		this.id = id;
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
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
}
