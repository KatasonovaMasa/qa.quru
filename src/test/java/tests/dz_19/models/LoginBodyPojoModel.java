package tests.dz_19.models;

public class LoginBodyPojoModel {
    private String email, password;
    //    "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\" }"

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // for classic Pojo model
//    @Override
//    public String toString() {
//        return "{\"email\": \"" + email + "\", \"password\":\"" + password + "\"}";
//    }
}
