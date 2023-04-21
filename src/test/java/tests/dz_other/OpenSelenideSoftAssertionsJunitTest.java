package tests.dz_other;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.form.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
@Tag("github")
public class OpenSelenideSoftAssertionsJunitTest extends TestBase {
        @BeforeAll
        static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

        @Test
        void openSelenideSoftAssertionsJunitTest(){
        //Откойте страницу Selenide в Github
        open("https://github.com/");
        $x("//button[@aria-label='Toggle navigation']//span[@class='Button-label']\n").click();
        $("[aria-label=\"Search GitHub\"]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        //Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("[id='wiki-pages-filter']").setValue("SoftAssertions").pressEnter();
        $x("//a[text()='SoftAssertions']").shouldHave(text("SoftAssertions"));
        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $x("//a[contains(text(),'SoftAssertions')]").click();
        $("[id=\"wiki-content\"]").shouldHave(text("Using JUnit5 extend test class:")).click();
    }
}