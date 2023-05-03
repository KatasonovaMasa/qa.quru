package tests.dz_21.models;

public class LoginResponsePojoModel {
    //    { "token": "QpwL5tke4Pnpja7X4" }

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // for classic Pojo model
//    @Override
//    public String toString() {
//        return "{\"token=\"" + token + "\"}";QpwL5tke4Pnpja7X4
//    }
}
