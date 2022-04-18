package security.service.client.repository;


import org.springframework.data.repository.CrudRepository;

import security.service.client.data.DataEntity;

public interface DataRepository  extends CrudRepository<DataEntity, Long>{
	
}