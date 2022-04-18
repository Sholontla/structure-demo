package secure.vault.demo.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import secure.vault.demo.entities.DataVault;
import secure.vault.demo.entities.TestingEntity;

@Repository
public interface IDataVaultRepository {

    DataVault save(DataVault person);

    DataVault findOne(String id);
    
    DataVault findDriver(String driver);
    
    DataVault findByDriver(String driver);
    
    long delete(String id);

    DataVault update(DataVault person);

    List<TestingEntity> getTesting(String userId);
}


