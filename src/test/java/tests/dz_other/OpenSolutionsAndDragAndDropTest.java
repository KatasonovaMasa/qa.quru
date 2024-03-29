package tests.dz_other;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import tests.form.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
@Tag("github")
public class OpenSolutionsAndDragAndDropTest extends TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void openSolutions() {
        open("https://github.com/");
        $x("//button[@aria-label='Toggle navigation']//span[@class='Button-label']").click();
        $(".header-menu-wrapper").$(byText("Solutions")).click();
        $x("//a[contains(text(),'Enterprise')]").hover().click();
        $(".enterprise-hero").shouldHave(text("Build like the best"));
    }

 //   @Disabled("Я не понимаю почему не работает")
    @Test
    @Disabled
    @Owner("Катасонова Мария")
    @DisplayName("Не работает медот Action.Selenide")
    void dragAndDropTestActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement a = $("#column-a");
        SelenideElement b = $("#column-b");
        actions().dragAndDrop(a,b).build().perform();
        $("#column-a").shouldHave(text("A"));
     }

    @Test
    void dragAndDropTestNoActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
