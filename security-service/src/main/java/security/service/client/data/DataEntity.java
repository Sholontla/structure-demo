package security.service.client.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="usersTest")
public class DataEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="columns")
	private Long id;
	@Column(name="fake_names")
	private String firstName;
	@Column(name="fake_last_names")
	private String lastName;
	@Column(name="fake_user_names")
	private String userName;
	@Column(name="fake_emails")
	private String email;
	@Column(name="fake_encrypted_password")
	private String encryptedPassword;
	
}
