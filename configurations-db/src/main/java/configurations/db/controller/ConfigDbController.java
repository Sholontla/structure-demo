package configurations.db.controller;

import org.springframework.web.bind.annotation.RestController;

import configurations.db.entity.ConfigDbEntity;
import configurations.db.model.ConfigDbModel;
import configurations.db.services.ICondigDbServices;

import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/config/db/user/{id}")
public class ConfigDbController {
	
	@Autowired
	private Environment env;
	@Autowired	
	ICondigDbServices configDbService;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	    @GetMapping(produces = { 
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE})
	    public List<ConfigDbModel> userConfigDb(@PathVariable String id) {
	        List<ConfigDbModel> returnValue = new ArrayList<>();
	        
	        List<ConfigDbEntity> configDbEntities = configDbService.getConfigDb(id);
	        
	        if(configDbEntities == null || configDbEntities.isEmpty())
	        {
	            return returnValue;
	        }
	        
	        Type listType = new TypeToken<List<ConfigDbModel>>(){}.getType();
	 
	        returnValue = new ModelMapper().map(configDbEntities, listType);
	        logger.info("Returning: " + returnValue.size() + "Data Base - Configurations ");
	        return returnValue;
	    }
}
