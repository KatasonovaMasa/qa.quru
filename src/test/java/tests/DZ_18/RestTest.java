package tests.DZ_18;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.core.Is.is;

@Tag("api_reqres")
public class RestTest {
    @Test
    void checkSingleEmail() {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .body("email", is("janet.weaver@reqres.in"));
    }
    @Test
    void checkListUsers() {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .body("page", is(2))
                .body("support.text", is("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }
    @Test
    void checkSingleUserId() {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .body("data.id", is(2));
    }

    @Test
    void checkListResource() {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemes/status-scheme-responce-unknown.json"));
    }
    @Test
    void checkSingleResource() {
        given()
                .log().uri()
                .when()
                .get("https://reqres.in/api/unknown/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("support.url", is("https://reqres.in/#support-heading"))
                .body(matchesJsonSchemaInClasspath("schemes/status-scheme-responce.json"));
    }
}
