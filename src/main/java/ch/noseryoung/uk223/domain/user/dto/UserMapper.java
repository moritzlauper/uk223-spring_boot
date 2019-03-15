package ch.noseryoung.uk223.domain.user.dto;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.noseryoung.uk223.domain.user.User;

@Mapper(
	componentModel = "spring",
	unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {
	
	User fromDTO(UserDTO userDto);
	
	UserDTO toDTO(User user);
	
	List<User> fromDTOs(List<UserDTO> userDtos);
	
	List<UserDTO> toDTOs(List<User> users);
}
