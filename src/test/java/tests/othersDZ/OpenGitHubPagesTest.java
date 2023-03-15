package tests.othersDZ;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OpenGitHubPagesTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void setup() {
        Selenide.open("https://github.com/");
    }

    @CsvSource(value = {
            "SoftAssertions, SoftAssertions",
            "Snippets, Snippets"
        }
    )
    @ParameterizedTest(name = "Открытие на гитхабе страниц {0} должен отображаться текст {1}")
    @Tags({
            @Tag("BLOCKER"),
            @Tag("WEB")
    })

    void OpenGitHubPagesTest(String testData, String expectedText){
        //Откойте страницу Selenide в Github
        //    open("https://github.com/");
        $("[aria-label=\"Search GitHub\"]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        //Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        //Откройте страницу {0}, проверьте что внутри есть пример кода для JUnit5
        $("[id='wiki-pages-filter']").setValue(testData).click();
        $("[id=\"wiki-content\"]").shouldHave(Condition.text(expectedText)).click();
    }
}