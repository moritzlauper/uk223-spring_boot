package ch.noseryoung.uk223.domain.Schnuppertag;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ch.noseryoung.uk223.domain.berufsbildner.Berufsbildner;
import ch.noseryoung.uk223.domain.fachrichtung.Fachrichtung;
import ch.noseryoung.uk223.domain.schnupperer.Schnupperer;
import ch.noseryoung.uk223.domain.standort.Standort;

/**
 * @author Moritz Lauper
 */
@Entity
@Table(name = "schnuppertag")
public class Schnuppertag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "start")
	private LocalDate start;
	
	@Column(name = "end")
	private LocalDate end;
	
	@ManyToOne
	@JoinColumn(name = "standort_id")
	private Standort standort;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "schnuppertag_schnupperer",
		joinColumns = @JoinColumn(name = "schnuppertag_id"),
		inverseJoinColumns = @JoinColumn(name = "schnupperer_id")
	)
	private Set<Schnupperer> schnupperer;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "schnuppertag_berufsbildner",
		joinColumns = @JoinColumn(name = "schnuppertag_id"),
		inverseJoinColumns = @JoinColumn(name = "berufsbildner_id")
	)
	private Set<Berufsbildner> berufsbildner;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "schnuppertag_fachrichtung",
		joinColumns = @JoinColumn(name = "schnuppertag_id"),
		inverseJoinColumns = @JoinColumn(name = "fachrichtung_id")
	)
	private Set<Fachrichtung> fachrichtung;
	
	public Schnuppertag() {}
	
	/**
	 * @param start
	 * @param end
	 * @param standort
	 * @param schnupperer
	 * @param berufsbildner
	 * @param fachrichtung
	 */
	public Schnuppertag(
			LocalDate start, LocalDate end, Standort standort, Set<Schnupperer> schnupperer, Set<Berufsbildner> berufsbildner,
			Set<Fachrichtung> fachrichtung
	) {
		this.start = start;
		this.end = end;
		this.standort = standort;
		this.schnupperer = schnupperer;
		this.berufsbildner = berufsbildner;
		this.fachrichtung = fachrichtung;
	}
	
	/**
	 * @param id
	 * @param start
	 * @param end
	 * @param standort
	 * @param schnupperer
	 * @param berufsbildner
	 * @param fachrichtung
	 */
	public Schnuppertag(
			Long id, LocalDate start, LocalDate end, Standort standort, Set<Schnupperer> schnupperer,
			Set<Berufsbildner> berufsbildner, Set<Fachrichtung> fachrichtung
	) {
		this.id = id;
		this.start = start;
		this.end = end;
		this.standort = standort;
		this.schnupperer = schnupperer;
		this.berufsbildner = berufsbildner;
		this.fachrichtung = fachrichtung;
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
	public Standort getStandort() {
		return standort;
	}
	
	/**
	 * @param standort the standort to set
	 */
	public void setStandort(Standort standort) {
		this.standort = standort;
	}
	
	/**
	 * @return the schnupperer
	 */
	public Set<Schnupperer> getSchnupperer() {
		return schnupperer;
	}
	
	/**
	 * @param schnupperer the schnupperer to set
	 */
	public void setSchnupperer(Set<Schnupperer> schnupperer) {
		this.schnupperer = schnupperer;
	}
	
	/**
	 * @return the berufsbildner
	 */
	public Set<Berufsbildner> getBerufsbildner() {
		return berufsbildner;
	}
	
	/**
	 * @param berufsbildner the berufsbildner to set
	 */
	public void setBerufsbildner(Set<Berufsbildner> berufsbildner) {
		this.berufsbildner = berufsbildner;
	}
	
	/**
	 * @return the fachrichtung
	 */
	public Set<Fachrichtung> getFachrichtung() {
		return fachrichtung;
	}
	
	/**
	 * @param fachrichtung the fachrichtung to set
	 */
	public void setFachrichtung(Set<Fachrichtung> fachrichtung) {
		this.fachrichtung = fachrichtung;
	}
	
}
