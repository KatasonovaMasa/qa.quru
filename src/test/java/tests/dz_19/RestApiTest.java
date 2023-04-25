package tests.dz_19;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.dz_19.lombok.LombokUserData;
import tests.dz_19.models.UserData;
import tests.dz_19.models.UserSupport;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.dz_18_19_Api.Specs.*;

@Tag("api_reqres")
public class RestApiTest {

    @Test
    void checkSingleEmail() {
        UserData data = given()
                    .spec(Specs.request)
                .when()
                    .get("/users/2")
                .then()
                    .spec(Specs.responseSpec)
                    .log().body()
                    .extract().as(UserData.class);
        assertEquals("janet.weaver@reqres.in", data.getData().getEmail());
    }

    @Test
    void checkTextSupport() {
        UserSupport support = given()
                    .spec(Specs.request)
                .when()
                    .get("/users?page=2")
                .then()
                    .spec(Specs.responseSpec)
                    .log().body()
                    .extract().as(UserSupport.class);
        assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!", support.getSupport().getText());
    }

    @Test
    void checkSingleUserId() {
        UserData data = given()
                    .spec(Specs.request)
                .when()
                    .get("/users/2")
                .then()
                    .spec(Specs.responseSpec)
                    .log().body()
                    .extract().as(UserData.class);
        assertEquals(2, data.getData().getId());
    }

    @Test
    void checkSingleIdLombok() {
        LombokUserData data = given()
                    .spec(Specs.request)
                .when()
                    .get("/users/2")
                .then()
                    .spec(Specs.responseSpec)
                    .log().body()
                    .extract().as(LombokUserData.class);
        assertEquals(2, data.getUser().getId());
    }


    @Test
    public void checkSingleEmailGroovy() {
        given()
                    .spec(Specs.request)
                .when()
                    .get("/users")
                .then()
                    .log().body()
                    .body("data.findAll{it.email =~/.*?@reqres.in/}.email.flatten()",
                        hasItem("janet.weaver@reqres.in"));
    }

    @Test
    public void checkSingleNameGroovy() {
        given()
                    .spec(Specs.request)
                .when()
                    .get("/users2")
                .then()
                    .log().body()
                    .body("data.findAll{it.name =~/./}.name.flatten()",
                        hasItem("fuchsia rose"));
    }

    @Test
    public void deleteUserTest() {
        given()
                    .spec(Specs.request)
                .when()
                    .delete("/users2")
                    .then()
                .spec(responseDelete);
    }

    @Test
    void checkSingleEmailLombok() {
        LombokUserData data = given()
                .spec(Specs.request)
                .when()
                .get("/users/2")
                .then()
                .spec(Specs.responseSpec)
                .log().body()
                .extract().as(LombokUserData.class);
        assertEquals("janet.weaver@reqres.in", data.getUser().getEmail());
    }

    @Test
    public void createUsers() {
        String body = "{ \"name\": \"Katija\", " +
                "\"job\": \"leader\" }";
        given()
                    .spec(Specs.request)
                    .body(body)
                .when()
                    .post("/users")
                .then()
                    .log().body()
                    .spec(responseSuccessAdd)
                    .body("name", is("Katija"));
    }

    @Test
    public void updateUsers() {
        String body = "{ \"name\": \"Masa\", " +
                "\"job\": \"leader\" }";
        given()
                .spec(Specs.request)
                .body(body)
                .when()
                .post("/users/2")
                .then()
                .log().body()
                .spec(responseSuccessAdd)
                .body("name", is("Masa"));
    }

    @Test
    public void loginSuccess() {
        String body = "{ \"email\": \"eve.holt@reqres.in\", " +
                "\"password\": \"cityslicka\" }";
        given()
                .spec(Specs.request)
                .body(body)
                .when()
                .post("/login")
                .then()
                .log().body()
                .spec(responseSpec)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void unsuccessLogin() {
        given()
                .spec(Specs.request)
                .when()
                .post("/login")
                .then()
                .log().body()
                .spec(responseUnsuccess)
                .body("error", is("Missing email or username"));
    }

    @Test
    public void registerUnsuccess() {
        String body = "{ \"email\": \"sydney@fife\"}";
        given()
                .spec(Specs.request)
                .body(body)
                .when()
                .post("/register")
                .then()
                .log().body()
                .spec(responseUnsuccess)
                .body("error", is("Missing password"));
    }
}
