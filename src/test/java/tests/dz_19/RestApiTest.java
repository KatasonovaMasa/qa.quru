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
import tests.dz_19.models.*;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
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
        SelenideLogger.addListener("allure", new AllureSelenide());
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
        SelenideLogger.addListener("allure", new AllureSelenide());
        AvtorisationBodyPojoModel data = new AvtorisationBodyPojoModel();
        data.setName("Masa");
        data.setJob("QA");
        AvtorisationResponsePojoModel response = given()
                .filter(new AllureRestAssured())
                .spec(Specs.request)
                .body(data)
                .when()
                .post("/users/2")
                .then()
                .log().body()
                .spec(responseSuccessAdd)
                .extract().as(AvtorisationResponsePojoModel.class);
        assertThat(response.getName()).isEqualTo("Masa");
        assertThat(response.getJob()).isEqualTo("QA");
    }

    @Test
    @Feature("Апишка для тестов REQRES")
    @Story("Пользователь")
    @Owner("Катасонова Мария")
    @DisplayName("Удаление пользователя")
    public void deleteUserTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
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
        SelenideLogger.addListener("allure", new AllureSelenide());
        AvtorisationBodyPojoModel data = new AvtorisationBodyPojoModel();
        data.setName("Katija");
        data.setJob("leader");
        AvtorisationResponsePojoModel response = given()
                .filter(new AllureRestAssured())
                    .spec(Specs.request)
                    .body(data)
                .when()
                    .post("/users")
                .then()
                    .log().body()
                    .spec(responseSuccessAdd)
                .extract().as(AvtorisationResponsePojoModel.class);
        assertThat(response.getName()).isEqualTo("Katija");
        assertThat(response.getJob()).isEqualTo("leader");
    }
    @Test
    @Feature("Апишка для тестов REQRES")
    @Story("Список пользователей")
    @Owner("Катасонова Мария")
    @DisplayName("Проверка что в списке пользователей есть выбранный email")
    public void checkSingleNameGroovy() {
        SelenideLogger.addListener("allure", new AllureSelenide());
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
        SelenideLogger.addListener("allure", new AllureSelenide());
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
        SelenideLogger.addListener("allure", new AllureSelenide());
        LoginBodyPojoModel data = new LoginBodyPojoModel();
        data.setEmail("eve.holt@reqres.in");
        data.setPassword("cityslicka");
        LoginResponsePojoModel response  = given()
                .filter(new AllureRestAssured())
                    .spec(Specs.request)
                    .body(data)
                .when()
                    .post("/login")
                .then()
                    .log().body()
                    .spec(responseSpec)
                    .extract().as(LoginResponsePojoModel.class);
        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Test
    @Feature("Апишка для тестов REQRES")
    @Story("Авторизация")
    @Owner("Катасонова Мария")
    @DisplayName("Авторизация по логину")
    public void unsuccessLogin() {
        SelenideLogger.addListener("allure", new AllureSelenide());
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
        SelenideLogger.addListener("allure", new AllureSelenide());
        LoginBodyPojoModel data = new LoginBodyPojoModel();
        data.setEmail("sydney@fife");
        given()
                .filter(new AllureRestAssured())
                    .spec(Specs.request)
                    .body(data)
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
