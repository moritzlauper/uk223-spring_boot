package ch.noseryoung.uk223.domain.berufsbildner.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.noseryoung.uk223.domain.berufsbildner.Berufsbildner;

@Mapper(
	componentModel = "spring",
	unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface BerufsbildnerMapper {
	
	Berufsbildner fromDTO(BerufsbildnerDTO berufsbildnerDto);
	
	BerufsbildnerDTO toDTO(Berufsbildner berufsbildner);
	
	List<Berufsbildner> fromDTOs(List<BerufsbildnerDTO> berufsbildnerDtos);
	
	List<BerufsbildnerDTO> toDTOs(List<Berufsbildner> berufsbildner);
}
