package ch.noseryoung.uk223.domain.fachrichtung.dto;

public class FachrichtungDTO {
	
	private String name;
	
	public FachrichtungDTO() {}
	
	/**
	 * @param name
	 */
	public FachrichtungDTO(String name) {
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
