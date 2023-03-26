package tests.DZ_other;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

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
    void openGitHubPagesTest(String testData, String expectedText){
        $("[aria-label=\"Search GitHub\"]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue(testData).click();
        $("#wiki-content").shouldHave(Condition.text(expectedText)).click();
    }
    @ValueSource(strings ={
            "SoftAssertions", "Snippets"
        }
    )
    @ParameterizedTest
    @DisplayName("Открытие на гитхабе страниц {0} должен отображаться текст {0}")
    @Tags({
            @Tag("BLOCKER"),
            @Tag("WEB")
    })
    void openGitHubPagesTest2(String testData){
        $("[aria-label=\"Search GitHub\"]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue(testData).click();
        $("#wiki-content").shouldHave(text(testData));
    }
    static Stream<String> argumentsStream() {
        return Stream.of("SoftAssertions", "Snippets");
    }
    @MethodSource("argumentsStream")
    @ParameterizedTest(name = "Открытие на гитхабе страниц {0} должен отображаться текст {0}")
    @Tags({
            @Tag("BLOCKER"),
            @Tag("WEB")
    })
    void openGitHubPagesTest3(String testData) {
        $("[aria-label=\"Search GitHub\"]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue(testData).click();
        $("#wiki-content").shouldHave(text(testData));
    }
}