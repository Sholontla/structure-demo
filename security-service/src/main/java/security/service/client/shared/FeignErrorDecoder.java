package security.service.client.shared;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class FeignErrorDecoder implements ErrorDecoder{
	
	//Environment environment;

	//@Autowired
	//public FeignErrorDecoder(Environment environment) {
		//this.environment = environment;
	//}
	
	@Override
	public Exception decode(String methodKey, Response response) {
		switch (response.status()) {
		case 400:
			break;
		case 404:{
			if(methodKey.contains("getAlbums"))
			return new ResponseStatusException(HttpStatus.valueOf(response.status()),
					"data.demo.vault.exception.not-found");
			break;
		}
		default:
			return new Exception(response.reason());
		}
		return null;
	}

}