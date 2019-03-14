package ch.noseryoung.uk223.domain.standort.dto;

public class StandortDTO {
	
	private String name;
	
	public StandortDTO() {}
	
	/**
	 * @param name
	 */
	public StandortDTO(String name) {
		this.name = name;
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
