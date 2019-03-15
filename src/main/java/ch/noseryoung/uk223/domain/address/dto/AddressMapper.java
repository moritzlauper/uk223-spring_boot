package ch.noseryoung.uk223.domain.address.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.noseryoung.uk223.domain.address.Address;

@Mapper(
	componentModel = "spring",
	unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface AddressMapper {
	
	Address fromDTO(AddressDTO addressDto);
	
	AddressDTO toDTO(Address address);
	
	List<Address> fromDTOs(List<AddressDTO> addressDtos);
	
	List<AddressDTO> toDTOs(List<Address> addresses);
}
