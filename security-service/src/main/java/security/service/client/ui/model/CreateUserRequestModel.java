package security.service.client.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CreateUserRequestModel {
	@NotNull(message="Fist Name can't be Null ..")
	@Size(min=3, message="Can't be les than 3 characters")
	private String firstName;
	@NotNull(message="Last Name can't be Null ..")
	@Size(min=3, message="Can't be les than 3 characters")
	private String lastName;
	@NotNull(message="Username Name can't be Null ..")
	@Size(min=3, message="Can't be les than 3 characters")
	private String userName;
	@NotNull(message="Password can't be Null ..")
	@Size(min=8, message="Can't be les than 8 characters")
	private String password;
	@NotNull(message="Fist Name can't be Null ..")
	@Email
	private String email;
}
