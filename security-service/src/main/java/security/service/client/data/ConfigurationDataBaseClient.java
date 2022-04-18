package security.service.client.data;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import security.service.client.ui.model.ConfigurationDataModel;


@FeignClient(name = "configurations-db-ws")
public interface ConfigurationDataBaseClient {
	Logger logger = LoggerFactory.getLogger(ConfigurationDataBaseClient.class);
	@GetMapping("/config/db/user/{id}")
	@Retry(name = "configurations-db-ws")
	@CircuitBreaker(name = "configurations-db-ws", fallbackMethod = "getConfigDbFallBack")
	public List<ConfigurationDataModel> getDataConfigDb(@PathVariable String id);
	
	default List<ConfigurationDataModel> getConfigDbFallBack(String id, Throwable exception){
		logger.info("Parameter: " + id);
		logger.info(exception.getMessage());
		logger.info(id, exception.getCause());
		return new ArrayList<>();
	}
}
