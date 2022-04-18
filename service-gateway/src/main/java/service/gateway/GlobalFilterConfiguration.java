package service.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import reactor.core.publisher.Mono;

@Configuration
public class GlobalFilterConfiguration {
	
	final Logger logger = LoggerFactory.getLogger(GlobalFilterConfiguration.class);
	

	@Bean
	@Order(1)
	public GlobalFilter secondPreFilter() {
		return (exchange, chain) -> {
			logger.info("Second Pre Global Filter Executed ...............");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				logger.info("Third Post Filter Executed ................");
			}));
		};
	}
	
	@Bean
	@Order(2)
	public GlobalFilter thirdPreFilter() {
		return (exchange, chain) -> {
			logger.info("Third Pre Global Filter Executed ...............");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				logger.info("Second Post Filter Executed ................");
			}));
		};
	}

	@Bean
	@Order(3)
	public GlobalFilter fourthPreFilter() {
		return (exchange, chain) -> {
			logger.info("Fourth Pre Global Filter Executed ...............");
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				logger.info("First Post Filter Executed ................");
			}));
		};
	}
	
	
}
