package configurations.db.entity;

import lombok.Data;

@Data
public class ConfigDbEntity {
	private long id;
	private String Db;
	private String port;
	private String host;
    private String secureId;
    private String userId; 
    private String user;
    private String driver; 
}
