package ch.noseryoung.uk223.domain.standort;

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
@Table(name = "standort")
public class Standort {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	public Standort() {} 

	/**
	 * @param id
	 */
	public Standort(Long id) {
		this.id = id;
	}

	/**
	 * @param id
	 * @param name
	 */
	public Standort(Long id, String name) {
		this.id = id;
		this.name = name;
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

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
