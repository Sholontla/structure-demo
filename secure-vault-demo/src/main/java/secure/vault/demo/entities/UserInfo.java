package secure.vault.demo.entities;

import java.util.Objects;

import lombok.Data;

@Data
public class UserInfo {
    private int number;
    private String userId;
    private String userName;
    private String postcode;
    private String city;
    private String country;

    public UserInfo() {
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserInfo vaultData = (UserInfo) o;
        return number == vaultData.number && Objects.equals(userName, vaultData.userName) && Objects.equals(postcode,
        		vaultData.postcode) && Objects
                .equals(city, vaultData.city) && Objects.equals(country, vaultData.country) && Objects.equals(userId, vaultData.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, userId, postcode, city, country);
    }
}
