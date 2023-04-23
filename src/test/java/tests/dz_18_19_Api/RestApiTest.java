package tests.dz_18_19_Api;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.dz_18_19_Api.lombok.LombokUserData;
import tests.dz_18_19_Api.models.UserData;
import tests.dz_18_19_Api.models.UserSupport;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
