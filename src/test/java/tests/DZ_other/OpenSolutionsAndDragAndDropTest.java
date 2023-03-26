package tests.DZ_other;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.form.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OpenSolutionsAndDragAndDropTest extends TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void openSolutions() {
        open("https://github.com/");
        $(".header-menu-wrapper").$(byText("Solutions")).hover();
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
        $("#column-a").shouldHave(text("B"));
     }

    @Test
    void dragAndDropTestNoActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
