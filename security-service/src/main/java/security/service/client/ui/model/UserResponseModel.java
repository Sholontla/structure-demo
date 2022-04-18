package security.service.client.ui.model;


import java.util.List;

import lombok.Data;

@Data
public class UserResponseModel {

    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private List<ConfigurationDataModel> configDb;
    private List< AsyncClientModel> asyncTest;
    

}