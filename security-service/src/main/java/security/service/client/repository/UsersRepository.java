package security.service.client.repository;

import org.springframework.data.repository.CrudRepository;

import security.service.client.data.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Long>{
	UserEntity findByEmail(String email);
	UserEntity findByUserId(String userId);
	
}
