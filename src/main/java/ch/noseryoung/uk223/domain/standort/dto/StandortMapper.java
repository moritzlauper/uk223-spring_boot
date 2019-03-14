package ch.noseryoung.uk223.domain.standort.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.noseryoung.uk223.domain.standort.Standort;

@Mapper(
	componentModel = "spring",
	unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface StandortMapper {
	
	Standort fromDTO(StandortDTO standortDto);
	
	StandortDTO toDTO(Standort standort);
	
	List<Standort> fromDTOs(List<StandortDTO> standortDtos);
	
	List<StandortDTO> toDTOs(List<Standort> standorte);
}
