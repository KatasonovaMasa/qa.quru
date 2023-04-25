package tests.dz_19;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
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
    @Feature("Апишка для тестов REQRES")
    @Story("Пользователь")
    @Owner("Катасонова Мария")
    @DisplayName("Проверка email у пользователя")
    void checkSingleEmail() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        UserData data = given()
                .filter(new AllureRestAssured())
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
    @Feature("Апишка для тестов REQRES")
    @Story("Пользователь")
    @Owner("Катасонова Мария")
    @DisplayName("Проверка id у пользователя")
    void checkSingleUserId() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        UserData data = given()
                .filter(new AllureRestAssured())
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
    @Feature("Апишка для тестов REQRES")
    @Story("Пользователь")
    @Owner("Катасонова Мария")
    @DisplayName("Проверка email у еще одного пользователя")
    void checkSingleEmailLombok() {
        LombokUserData data = given()
                .filter(new AllureRestAssured())
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
    @Feature("Апишка для тестов REQRES")
    @Story("Пользователь")
    @Owner("Катасонова Мария")
    @DisplayName("Проверка редактирования имени у пользователя")
    public void updateUsers() {
        String body = "{ \"name\": \"Masa\", " +
                "\"job\": \"leader\" }";
        given()
                .filter(new AllureRestAssured())
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
    @Feature("Апишка для тестов REQRES")
    @Story("Пользователь")
    @Owner("Катасонова Мария")
    @DisplayName("Удаление пользователя")
    public void deleteUserTest() {
        given()
                .filter(new AllureRestAssured())
                    .spec(Specs.request)
                .when()
                    .delete("/users2")
                .then()
                .spec(responseDelete);
    }

    @Test
    @Feature("Апишка для тестов REQRES")
    @Story("Пользователь")
    @Owner("Катасонова Мария")
    @DisplayName("Создание пользователя")
    public void createUsers() {
        String body = "{ \"name\": \"Katija\", " +
                "\"job\": \"leader\" }";
        given()
                .filter(new AllureRestAssured())
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
    @Feature("Апишка для тестов REQRES")
    @Story("Список пользователей")
    @Owner("Катасонова Мария")
    @DisplayName("Проверка что в списке пользователей есть выбранный email")
    public void checkSingleNameGroovy() {
        given()
                .filter(new AllureRestAssured())
                .spec(Specs.request)
                .when()
                .get("/users2")
                .then()
                .log().body()
                .body("data.findAll{it.name =~/./}.name.flatten()",
                        hasItem("fuchsia rose"));
    }
    @Test
    @Feature("Апишка для тестов REQRES")
    @Story("Список пользователей")
    @Owner("Катасонова Мария")
    @DisplayName("Проверка что в списке пользователей есть выбранный email")
    public void checkSingleEmailGroovy() {
        given()
                .filter(new AllureRestAssured())
                .spec(Specs.request)
                .when()
                .get("/users")
                .then()
                .log().body()
                .body("data.findAll{it.email =~/.*?@reqres.in/}.email.flatten()",
                        hasItem("janet.weaver@reqres.in"));
    }

    @Test
    @Feature("Апишка для тестов REQRES")
    @Story("Авторизация")
    @Owner("Катасонова Мария")
    @DisplayName("Авторизация по логину")
    public void loginSuccess() {
        String body = "{ \"email\": \"eve.holt@reqres.in\", " +
                "\"password\": \"cityslicka\" }";
        given()
                .filter(new AllureRestAssured())
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
    @Feature("Апишка для тестов REQRES")
    @Story("Авторизация")
    @Owner("Катасонова Мария")
    @DisplayName("Авторизация по логину")
    public void unsuccessLogin() {
        given()
                .filter(new AllureRestAssured())
                    .spec(Specs.request)
                .when()
                    .post("/login")
                .then()
                    .log().body()
                    .spec(responseUnsuccess)
                    .body("error", is("Missing email or username"));
    }

    @Test
    @Feature("Апишка для тестов REQRES")
    @Story("Регистрация")
    @Owner("Катасонова Мария")
    @DisplayName("Ошибка при авторизации")
    public void registerUnsuccess() {
        String body = "{ \"email\": \"sydney@fife\"}";
        given()
                .filter(new AllureRestAssured())
                    .spec(Specs.request)
                    .body(body)
                .when()
                    .post("/register")
                .then()
                    .log().body()
                    .spec(responseUnsuccess)
                    .body("error", is("Missing password"));
    }

    @Test
    @Feature("Апишка для тестов REQRES")
    @Story("Список пользователей")
    @Owner("Катасонова Мария")
    @DisplayName("Проверка текста в теле json")
    void checkTextSupport() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        UserSupport support = given()
                .filter(new AllureRestAssured())
                .spec(Specs.request)
                .when()
                .get("/users?page=2")
                .then()
                .spec(Specs.responseSpec)
                .log().body()
                .extract().as(UserSupport.class);
        assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!", support.getSupport().getText());
    }
}
