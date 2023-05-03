package tests.dz_21;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import pages.RegistrationPage;
import tests.dz_21.models.CreateTestCaseBody;
import tests.dz_21.models.CreateTestCaseResponse;
import tests.form.TestBase;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;


@Tag("api_allure")
public class CreateTestcaseTests extends TestBase {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://allure.autotests.cloud";
    }
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
    void createWitApiOnlyTest() {
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

        step("Verify testcase name", () ->
                assertThat(createTestCaseResponse.getName()).isEqualTo(testCaseName));

    }
    @Test
    void createWitApiOnlyUiTest() {
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
        });
    }

    @Test
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
