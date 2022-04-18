package secure.vault.demo.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Data;

import org.bson.types.ObjectId;

import java.util.Date;
import java.util.Objects;

@Data
@JsonInclude(Include.NON_NULL)
public class DataVault {

    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String hostName;
    private String userName;
    private String password;
    private int port;
    private String driver;
    private UserInfo userInfo;
    private Date createdAt = new Date();
    private Boolean active;




    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DataVault person = (DataVault) o;
        return port == person.port && Objects.equals(id, person.id) && Objects.equals(userName,
                                                                                    person.userName) && Objects.equals(password,
                                                                                                                        person.password) && Objects
                .equals(hostName, person.hostName) && Objects.equals(createdAt, person.createdAt) && Objects.equals(active,
                                                                                                                  person.active) && Objects.equals(driver, person.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, port, hostName, createdAt, active, driver);
    }

}