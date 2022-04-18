package security.service.client.security;

public class ObfuscationService {
	
	public static String returnObfuscation(String data, String replaceStrings) {
		
		String obfuscationProcess = data.replaceAll(data, replaceStrings);
		return obfuscationProcess;
	}
        

}
