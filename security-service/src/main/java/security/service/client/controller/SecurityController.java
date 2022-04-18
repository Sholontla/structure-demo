package security.service.client.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import security.service.client.data.DataEntity;
import security.service.client.security.EncryptionAES;
import security.service.client.security.ObfuscationService;
import security.service.client.service.SecurityServiceImpl;
import security.service.client.service.ISecurityService;
import security.service.client.shared.UserDto;
import security.service.client.ui.model.CreateUserRequestModel;
import security.service.client.ui.model.CreateUserResponseModel;
import security.service.client.ui.model.UserResponseModel;

@Slf4j
@RestController
@RequestMapping("/security")
public class SecurityController {
	
	@Autowired
    private SecurityServiceImpl serviceImpl;
	
	@Autowired
	private Environment env;
	@Autowired
	ISecurityService usersService;
	
	@GetMapping("/status/check")
	public String status() {
		String port = env.getProperty("local.server.port");
		String tokenString = env.getProperty("token.secret");
		return "Testing Status Check Security ............. " + "\r\n" +  " " + "PORT: " + " " + port + "\r\n" + "Swagger: " + "http://localhost:" + 
		port + "/swagger-ui/index.html" + "\r\n" + tokenString;
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML},
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}
			)
	public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetail) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userDetail, UserDto.class);
		UserDto createdUser = usersService.createUser(userDto);
		CreateUserResponseModel returnValue = modelMapper.map(createdUser, CreateUserResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}
	
    @GetMapping(value="/{userId}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ResponseEntity<UserResponseModel> getUsers(@PathVariable("userId") String userId) {
       
        UserDto userDto = usersService.getUserById(userId); 
        UserResponseModel returnValue = new ModelMapper().map(userDto, UserResponseModel.class);
        
        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }
    
    @GetMapping(value="/async/{userId}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ResponseEntity<UserResponseModel> getUsersDemoAsync(@PathVariable("userId") String userId) {
       
        UserDto userDto = usersService.getAsyncByUser(userId); 
        UserResponseModel returnValue = new ModelMapper().map(userDto, UserResponseModel.class);
        
        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }


    @GetMapping(value="/encryption", produces = {MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML})
    public List<DataEntity> encryptData(){
    	long start = System.currentTimeMillis();
    	List<DataEntity> data = serviceImpl.dataList();
		data.stream()
		.map(dataStream -> EncryptionAES.encrypt(dataStream.getFirstName(), dataStream.getFirstName()))
		.forEach(System.out::println);
        log.info("Executing Controller Encryption INFO DONE AND CORRECT ....................");
    	long finish = System.currentTimeMillis();
    	long timeElapsed = finish - start;
    	System.out.println("Time taking to Encryption data: " + " " +  timeElapsed);
        return data;
      
    }
    
    @GetMapping(value="/obfuscation", produces = {MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML})
    public List<DataEntity> obfuscationData(){
    	long start = System.currentTimeMillis();
    	List<DataEntity> data = serviceImpl.dataList();
		data.stream()
		.map(dataStream -> ObfuscationService.returnObfuscation(dataStream.getEmail(), "Obfuscation security replace data can be change by any 'Value'"))
		.forEach(System.out::println);
        log.info("Executing Controller Obfuscation INFO DONE AND CORRECT ....................");
    	long finish = System.currentTimeMillis();
    	long timeElapsed = finish - start;
    	System.out.println("Time taking to Obfuscate data: " + " " +  timeElapsed);
        return data; 
    }
    
    
}
