package configurations.db.model;

import lombok.Data;

@Data
public class ConfigDbModel {
	private String Db;
	private String port;
	private String host;
    private String secureId;
    private String userId; 
    private String user;
    private String driver; 
}


