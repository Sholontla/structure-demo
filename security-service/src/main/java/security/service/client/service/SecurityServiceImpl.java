package security.service.client.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import security.service.client.data.ConfigurationDataBaseClient;
import security.service.client.data.DataEntity;
import security.service.client.data.IDemoAsyncClient;
import security.service.client.data.UserEntity;
import security.service.client.repository.DataRepository;
import security.service.client.repository.UsersRepository;
import security.service.client.shared.UserDto;
import security.service.client.ui.model.AsyncClientModel;
import security.service.client.ui.model.ConfigurationDataModel;

@Service
public class SecurityServiceImpl implements ISecurityService {
	
	DataRepository dataRepository; 
	UsersRepository usersRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	ConfigurationDataBaseClient iConfigDb;
	IDemoAsyncClient iDemoAsyncClient;
	Environment environment;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	public SecurityServiceImpl(UsersRepository usersRepository, 
			BCryptPasswordEncoder bCryptPasswordEncoder, 
			ConfigurationDataBaseClient iSecureVaultDemo){
		this.usersRepository = usersRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.iConfigDb = iSecureVaultDemo;
		
	}
	
	@Override
	public UserDto createUser(UserDto userDetails) {
		
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));  
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		usersRepository.save(userEntity);
		UserDto returnValue = modelMapper.map(userDetails, UserDto.class);
		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = usersRepository.findByEmail(username);
		
		if(userEntity == null) throw new UsernameNotFoundException(username);
		
		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), true, true, true, true, new ArrayList<>());
	}

	@Override
	public UserDto getUserDetailsByEmail(String email) {
		UserEntity userEntity = usersRepository.findByEmail(email);
		if(userEntity == null) throw new UsernameNotFoundException(email);
		
		return new ModelMapper().map(userEntity, UserDto.class);
	}


	    @Override
	    @Transactional(readOnly = true)
	    public List<DataEntity> dataList() {
	        return (List<DataEntity>) dataRepository.findAll();   
	}
	    
		@Override
		public UserDto getUserById(String userId) {
	        UserEntity userEntity = usersRepository.findByUserId(userId);     
	        if(userEntity == null) throw new UsernameNotFoundException("User Not Found");     
	        UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);
	        logger.info("Before Configurations BD .................................");
	        List<ConfigurationDataModel> resultConfigDb = iConfigDb.getDataConfigDb(userId);
	        logger.info("After Configurations BD .............");
	        userDto.setConfigDb(resultConfigDb);
	        return userDto;
		}

		@Override
		public UserDto getAsyncByUser(String userId) {
	        UserEntity userEntity = usersRepository.findByUserId(userId);     
	        if(userEntity == null) throw new UsernameNotFoundException("User Not Found");     
	        UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);
	        logger.info("Before Async .................................");
	        List<AsyncClientModel> dataDemoAsync = iDemoAsyncClient.getDemoAsync(userId);
	        logger.info("After Async .............");
	        userDto.setAsyncTest(dataDemoAsync);
	        return userDto;
		}
		
	}

