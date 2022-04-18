package security.service.client.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import security.service.client.data.DataEntity;
import security.service.client.shared.UserDto;

public interface ISecurityService extends UserDetailsService{
	UserDto createUser(UserDto userDetails);
	UserDto getUserDetailsByEmail(String email);
	UserDto getUserById(String userId);
	public List<DataEntity> dataList();
	UserDto getAsyncByUser(String userId);
	
}
