package tests.dz_11;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.internal.shadowed.jackson.annotation.JacksonInject;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.GithubPage;
import steps.IssueSteps;
import tests.form.TestBase;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
@Tag("github")
public class IssueTest extends TestBase {
    @BeforeEach
    void setup() {
        Selenide.open("https://github.com/");
        Configuration.pageLoadStrategy = "eager";
    }
    @JacksonInject
    IssueSteps issueSteps = new IssueSteps();
    private static final int ISSUE = 4;
    GithubPage githubPage = new GithubPage();

    @Test
    @Feature("Issue в репозитории")
    @Story("Проверки Issue")
    @Owner("Катасонова Мария")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing guru", url = "https://github.com")
    @DisplayName("Проверка Issue с помощью Selenide")
    public void testIssueSearchSelenide() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        githubPage.openPage();//        Открываем главную страницу
        $("[aria-label=\"Search GitHub\"]").setValue("KatasonovaMasa/qa.quru").pressEnter();//   Ищем репозиторий KatasonovaMasa/qa.quru
        $(linkText("KatasonovaMasa/qa.quru")).click();//        Кликаем по ссылке репозитория qa.quru
        $("#issues-tab").click();//        Открываем таб Issues
        $(withText("#"+ISSUE)).shouldHave(Condition.exist);//        Проверяем наличие Issue с номером #4
        issueSteps.takeScreenshot();//      Делаем скриншот
         }

    @Test
    @Feature("Issue в репозитории")
    @Story("Проверки Issue")
    @Owner("Катасонова Мария")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing guru", url = "https://github.com")
    @DisplayName("Проверка Issue с помощью Lambda")
    public void testIssueSearchLambda(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
            githubPage.openPage();
        });
        step("Ищем репозиторий {githubPage.searhRepo}", () -> {
            $("[aria-label=\"Search GitHub\"]").setValue("KatasonovaMasa/qa.quru").pressEnter();
        });
        step("Кликаем по ссылке репозитория qa.quru", () -> {
            $(linkText("KatasonovaMasa/qa.quru")).click();
        });
        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue с номером #4", () -> {
            $(withText("#"+ISSUE)).shouldHave(Condition.exist);
        });
        step("Делаем скриншот", () ->{
            issueSteps.takeScreenshot();
        });

    }

    @Test
    @Feature("Issue в репозитории")
    @Story("Проверки Issue")
    @Owner("Катасонова Мария")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing guru", url = "https://github.com")
    @DisplayName("Проверка Issue с помощью Steps")
    public void testIssueSearchSteps () {
        SelenideLogger.addListener("allure", new AllureSelenide());
        IssueSteps issueSteps = new IssueSteps();
        issueSteps.open();//                Открываем главную страницу
        issueSteps.searhRepo();//           Ищем репозиторий KatasonovaMasa/qa.quru
        issueSteps.clickRepositori();//     Кликаем по ссылке репозитория qa.quru
        issueSteps.openTabIssue();//        Открываем таб Issues
        issueSteps.visibulIssue();//        Проверяем наличие Issue с номером #4
        issueSteps.takeScreenshot();//      Делаем скриншот
    }
}
