package tests.othersDZ;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OpenSelenideSoftAssertionsJunitTest {
        @BeforeAll
        static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

        @Test
        void openSelenideSoftAssertionsJunitTest(){
        //Откойте страницу Selenide в Github
        open("https://github.com/");
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