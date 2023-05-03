package tests.dz_21;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.dz_21.models.User2;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tests.dz_21.helpers.CustomApiListener2.withCustomTemplates;

@Tag("api_reqres")
public class SteamRestApiTest {

    @Test
    @Feature("Апишка для тестов REQRES")
    @Story("Пользователь")
    @Owner("Катасонова Мария")
    @DisplayName("Проверка email у пользователя")
    void checkSingleEmail() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        User2 data = given()
                .filter(withCustomTemplates())
                .log().uri()
                .contentType(ContentType.JSON)
                .queryParam("start", "50")
                .queryParam("term", "Cuphead")
                .queryParam("supportedlang", "russian")
                .queryParam("infinite", "1")
                    .spec(Specs2.request)
                .when()
                    .get("/results/?query")
                .then()
                    .spec(Specs2.responseSpec)
                    .log().body()
                               .extract().as(User2.class);
       assertEquals(1, data.getSuccess());
       assertEquals( 17, data.getTotal_count());
    }

}
