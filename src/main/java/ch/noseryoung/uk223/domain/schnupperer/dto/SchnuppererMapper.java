package ch.noseryoung.uk223.domain.schnupperer.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.noseryoung.uk223.domain.schnupperer.Schnupperer;

@Mapper(
	componentModel = "spring",
	unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface SchnuppererMapper {
	
	Schnupperer fromDTO(SchnuppererDTO schnuppererDto);
	
	SchnuppererDTO toDTO(Schnupperer schnupperer);
	
	List<Schnupperer> fromDTOs(List<SchnuppererDTO> schnuppererDtos);
	
	List<SchnuppererDTO> toDTOs(List<Schnupperer> schnupperer);
}
