package ch.noseryoung.uk223.domain.Schnuppertag.dto;

import java.time.LocalDate;
import java.util.List;

import ch.noseryoung.uk223.domain.berufsbildner.dto.BerufsbildnerDTO;
import ch.noseryoung.uk223.domain.standort.dto.StandortDTO;

public class SchnuppertagDTO {
	
	private LocalDate start;
	
	private LocalDate end;
	
	private StandortDTO standort;
	
	private List<BerufsbildnerDTO> berufsbilder;
	
	public SchnuppertagDTO() {}
	
	/**
	 * @param start
	 * @param end
	 * @param standort
	 * @param berufsbilder
	 */
	public SchnuppertagDTO(LocalDate start, LocalDate end, StandortDTO standort, List<BerufsbildnerDTO> berufsbilder) {
		this.start = start;
		this.end = end;
		this.standort = standort;
		this.berufsbilder = berufsbilder;
	}
	
	/**
	 * @return the start
	 */
	public LocalDate getStart() {
		return start;
	}
	
	/**
	 * @param start the start to set
	 */
	public void setStart(LocalDate start) {
		this.start = start;
	}
	
	/**
	 * @return the end
	 */
	public LocalDate getEnd() {
		return end;
	}
	
	/**
	 * @param end the end to set
	 */
	public void setEnd(LocalDate end) {
		this.end = end;
	}
	
	/**
	 * @return the standort
	 */
	public StandortDTO getStandort() {
		return standort;
	}
	
	/**
	 * @param standort the standort to set
	 */
	public void setStandort(StandortDTO standort) {
		this.standort = standort;
	}
	
	/**
	 * @return the berufsbilder
	 */
	public List<BerufsbildnerDTO> getBerufsbilder() {
		return berufsbilder;
	}
	
	/**
	 * @param berufsbilder the berufsbilder to set
	 */
	public void setBerufsbilder(List<BerufsbildnerDTO> berufsbilder) {
		this.berufsbilder = berufsbilder;
	}
	
}
