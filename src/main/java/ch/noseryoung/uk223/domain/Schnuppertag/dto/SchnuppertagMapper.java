package ch.noseryoung.uk223.domain.Schnuppertag.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.noseryoung.uk223.domain.Schnuppertag.Schnuppertag;

@Mapper(
	componentModel = "spring",
	unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface SchnuppertagMapper {
	
	Schnuppertag fromDTO(SchnuppertagDTO schnuppertagDto);
	
	SchnuppertagDTO toDTO(Schnuppertag schnuppertag);
	
	List<Schnuppertag> fromDTOs(List<SchnuppertagDTO> schnuppertagDtos);
	
	List<SchnuppertagDTO> toDTOs(List<Schnuppertag> schnuppertage);
}
