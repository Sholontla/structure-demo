package security.service.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import security.service.client.data.DataEntity;
@Repository
public interface DataRepository  extends JpaRepository<DataEntity, Long>{
	List<DataEntity> findByGroup(Integer group);
}
