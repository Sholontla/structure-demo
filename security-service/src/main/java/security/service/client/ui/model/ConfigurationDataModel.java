package security.service.client.ui.model;

import lombok.Data;

@Data
public class ConfigurationDataModel {
	private String Db;
	private String port;
	private String host;
    private String secureId;
    private String userId; 
    private String user;
    private String driver; 
}
