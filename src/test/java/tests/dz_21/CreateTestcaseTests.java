package tests.dz_21;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import com.google.inject.Inject;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import pages.RegistrationPage;
import tests.dz_21.models.CreateTestCaseBody;
import tests.dz_21.models.CreateTestCaseResponse;
import tests.form.TestBase;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;


@Tag("api_allure")
@Feature("Апишка для тестов Allure")
@Story("Тест кейс")
@Owner("Катасонова Мария")
@DisplayName("Тесты в allure")
public class CreateTestcaseTests extends TestBase {

    @Inject
    private AllureSteps allureSteps;

    RegistrationPage registrationPage = new RegistrationPage();
    static String login = "allure8",
            password = "allure8",
            projectId = "2188";

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://allure.autotests.cloud";
        Configuration.holdBrowserOpen = true;

        RestAssured.baseURI = "https://allure.autotests.cloud";
    }


    @Test
    @Feature("Апишка для тестов Allure")
    @Story("Тест кейс")
    @Owner("Катасонова Мария")
    @DisplayName("Создание тест кейса")
    void createWitApiOnlyUiTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Faker faker = new Faker();
        String testCaseName = faker.name().fullName();

        CreateTestCaseBody testCaseBody = new CreateTestCaseBody();
        testCaseBody.setName(testCaseName);

        CreateTestCaseResponse createTestCaseResponse = step("Create testcase", () ->
                given()
                        .log().all()
                        .header("X-XSRF-TOKEN", "91590414-274a-4cfa-bb89-9ef757a606aa")
                        .cookies("XSRF-TOKEN", "91590414-274a-4cfa-bb89-9ef757a606aa",
                                "ALLURE_TESTOPS_SESSION", "97d5ca43-e032-4458-a78e-9b048f745c6e")
                        .contentType("application/json;charset=UTF-8")
                        .body(testCaseBody)
                        .queryParam("projectId", projectId)
                        .when()
                        .post("/api/rs/testcasetree/leaf")
                        .then()
                        .log().status()
                        .log().body()
                        .statusCode(200)
                        .extract().as(CreateTestCaseResponse.class)
        );

        step("Verify testcase name", () -> {

        open("/favicon.ico");

        Cookie authorizationCookie = new Cookie("ALLURE_TESTOPS_SESSION", "97d5ca43-e032-4458-a78e-9b048f745c6e");
        getWebDriver().manage().addCookie(authorizationCookie);

        Integer testCaseId = createTestCaseResponse.getId();

        String testCaseUrl = format( "/project/%s/test-cases/%s", projectId, testCaseId);

        open(testCaseUrl + "?treeId=0");
            $x("//*[contains(@class, 'Menu__trigger')]").click();
            $x("//span[text()='Rename test case']").click();
            String name = String.valueOf($(byName("name")).setValue("name"));
            $x("//*[contains(@class, 'Modal__content')]//*[@name='submit']").click();
            withText(name);

        });





    }

    @Test
    @Feature("Апишка для тестов Allure")
    @Story("Тест кейс")
    @Owner("Катасонова Мария")
    @DisplayName("Редактирование тест кейса")
    void editeWitApiOnlyUiTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Faker faker = new Faker();
        String testCaseName = faker.name().fullName();

        CreateTestCaseBody testCaseBody = new CreateTestCaseBody();
        testCaseBody.setName(testCaseName);

        CreateTestCaseResponse createTestCaseResponse = step("Create testcase", () ->
                given()
                        .log().all()
                        .header("X-XSRF-TOKEN", "91590414-274a-4cfa-bb89-9ef757a606aa")
                        .cookies("XSRF-TOKEN", "91590414-274a-4cfa-bb89-9ef757a606aa",
                                "ALLURE_TESTOPS_SESSION", "dce276c1-dbed-44fd-ac4c-0eb41166e73b")
                        .contentType("application/json;charset=UTF-8")
                        .body(testCaseBody)
                        .queryParam("projectId", projectId)
                        .when()
                        .post("/api/rs/testcasetree/leaf")
                        .then()
                        .log().status()
                        .log().body()
                        .statusCode(200)
                        .extract().as(CreateTestCaseResponse.class)
        );

        step("Verify testcase name", () -> {
            open("/favicon.ico");

            Cookie authorizationCookie = new Cookie("ALLURE_TESTOPS_SESSION", "dce276c1-dbed-44fd-ac4c-0eb41166e73b");
            getWebDriver().manage().addCookie(authorizationCookie);

            Integer testCaseId = createTestCaseResponse.getId();
            String testCaseUrl = format( "/project/%s/test-cases/%s", projectId, testCaseId);

            open(testCaseUrl);
            registrationPage.takeScreenshot();
        });


    }

}
