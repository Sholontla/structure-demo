package security.service.client.ui.model;

import lombok.Data;

@Data
public class CreateUserResponseModel {
	
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String userId;
}
