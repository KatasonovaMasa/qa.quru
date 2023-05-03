package tests.dz_21.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData2 {
    private User2 data;

    public User2 getData() {
        return data;
    }

    public void setData(User2 data) {
        this.data = data;
    }
}