package configurations.db.services;

import java.util.List;

import configurations.db.entity.ConfigDbEntity;


public interface ICondigDbServices {
	List<ConfigDbEntity> getConfigDb(String userId);
}
