package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.GithubPage;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class IssueSteps {
    GithubPage githubPage = new GithubPage();

    @Step("Открываем главную страницу")
    public void open(){
        githubPage.openPage();
    }
    @Step("Ищем репозиторий {githubPage.searhRepo}")
    public void searhRepo() {
        $("[aria-label=\"Search GitHub\"]").setValue("KatasonovaMasa/qa.quru").pressEnter();;
    }
    @Step("Кликаем по ссылке репозитория qa.quru")
    public void clickRepositori() {
        $(linkText("KatasonovaMasa/qa.quru")).click();
    }
    @Step("Открываем таб Issues")
    public void openTabIssue() {
        $("#issues-tab").click();;
    }
    @Step("Проверяем наличие Issue с номером #4")
    public void visibulIssue() {
        $(withText("#4")).shouldHave(Condition.exist);
    }
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

   }
