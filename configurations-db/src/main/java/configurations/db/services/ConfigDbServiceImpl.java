package configurations.db.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import configurations.db.entity.ConfigDbEntity;

@Service
public class ConfigDbServiceImpl implements ICondigDbServices{

		 @Override
		    public List<ConfigDbEntity> getConfigDb(String userId) {
		        List<ConfigDbEntity> returnValue = new ArrayList<>();
		        ConfigDbEntity dataSecureEntity = new ConfigDbEntity();
		        dataSecureEntity.setSecureId("Id1");
		        dataSecureEntity.setUserId(userId);
		        dataSecureEntity.setDb("Postgre Sql");
		        dataSecureEntity.setPort("5432");
		        dataSecureEntity.setHost("localhost");
		        dataSecureEntity.setUser("testingpostgre");
		        dataSecureEntity.setDriver("jdbc:postgresql://:/");
		        
		        ConfigDbEntity dataSecureEntity2 = new ConfigDbEntity();
		        dataSecureEntity2.setSecureId("Id2");
		        dataSecureEntity2.setUserId(userId);
		        dataSecureEntity2.setDb("Mongo DB");
		        dataSecureEntity2.setPort("5707");
		        dataSecureEntity2.setHost("localhost");
		        dataSecureEntity2.setUser("testingmongo");
		        dataSecureEntity2.setDriver("mongodb://:@:");
		        
		        returnValue.add(dataSecureEntity);
		        returnValue.add(dataSecureEntity2);
		        
		        return returnValue;
		        
		  }
	}