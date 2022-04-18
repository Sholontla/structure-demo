package security.service.client.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="testingUsers")
public class UserEntity implements Serializable{
	
	private static final long serialVersionUID = -5590005081855601874L;
	@Id
	@GeneratedValue
	private long id;
	@Column(name="fake_names", nullable=false, length=50)
	private String firstName;
	@Column(name="fake_last_names", nullable=false, length=50)
	private String lastName;
	@Column(name="fake_user_names", nullable=false, length=50, unique=true)
	private String userName;
	@Column(name="fake_emails", nullable=false, length=200, unique=true)
	private String email;
	@Column(name="index", nullable=false, unique=true)
	private String userId;
	@Column(name="fake_encrypted_password", nullable=false, unique=true)
	private String encryptedPassword;
	
	
	
}

