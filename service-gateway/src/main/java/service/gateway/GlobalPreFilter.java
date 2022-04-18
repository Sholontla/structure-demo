package service.gateway;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;

import reactor.core.publisher.Mono;

@Component
public class GlobalPreFilter implements GlobalFilter, Ordered{
	
	final Logger logger = LoggerFactory.getLogger(GlobalPreFilter.class);
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain){
		logger.info("Logging basics, Global PreFilter Api GateWay ..................");
		
		String requestPath = exchange.getRequest().getPath().toString();
		logger.info("Requested Path ................. :" + requestPath);
		
		HttpHeaders httpHeaders =  exchange.getRequest().getHeaders();
		Set<String> heatherNames = httpHeaders.keySet();
		heatherNames.forEach((heatherName) -> {
			String heatherValue = httpHeaders.getFirst(heatherName);
			logger.info("Heather Value ............... :" + heatherValue);

		});
		
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		
		return 0;
	}
}
