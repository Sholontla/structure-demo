package security.service.client.data;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import feign.*;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import security.service.client.controller.SecurityController;
import security.service.client.ui.model.AsyncClientModel;
import security.service.client.ui.model.ConfigurationDataModel;
import security.service.client.ui.model.DummyDataClient;

@FeignClient(name = "demo-async-ws")
public interface IDemoAsyncClient {
	Logger logger = LoggerFactory.getLogger(IDemoAsyncClient.class);
	@GetMapping("/async/test/async/{id}")
	@Retry(name = "demo-async-ws")
	@CircuitBreaker(name = "demo-async-ws", fallbackMethod = "getAsyncFallBack")
	public List<AsyncClientModel> getDemoAsync(@PathVariable String id);

	default List<AsyncClientModel> getAsyncFallBack(String id, Throwable exception){
		logger.info("Parameter: " + id);
		logger.info(exception.getMessage());
		logger.info(id, exception.getCause());
		return new ArrayList<>();
	}

}