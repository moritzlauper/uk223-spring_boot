package ch.noseryoung.uk223.domain.fachrichtung.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.noseryoung.uk223.domain.fachrichtung.Fachrichtung;

@Mapper(
	componentModel = "spring",
	unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface FachrichtungMapper {
	
	Fachrichtung fromDTO(FachrichtungDTO fachrichtungDto);
	
	FachrichtungDTO toDTO(Fachrichtung fachrichtung);
	
	List<Fachrichtung> fromDTOs(List<FachrichtungDTO> fachrichtungDtos);
	
	List<FachrichtungDTO> toDTOs(List<Fachrichtung> fachrichtungen);
}
