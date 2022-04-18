package security.service.client.shared;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import security.service.client.ui.model.AsyncClientModel;
import security.service.client.ui.model.ConfigurationDataModel;
@Data
public class UserDto implements Serializable{
	
	private static final long serialVersionUID = 4284688615450833078L;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private String userId;
	private String encryptedPassword;
	private List<ConfigurationDataModel> configDb;
	private List<AsyncClientModel> asyncTest;
}








