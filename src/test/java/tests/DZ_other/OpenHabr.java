package tests.DZ_other;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OpenHabr {

    @BeforeEach
    void setup() {
        Selenide.open("https://habr.com/ru/all/");
    }

    static Stream<Arguments> searchResultsShouldBeGreaterThan10() {
        return Stream.of(
                Arguments.of("Selenide"),
                Arguments.of("Allure")
        );
    }
    @Disabled
    @MethodSource
    @ValueSource(strings = {"Selenide", "Allure"})
    @ParameterizedTest(name = "В поисковой выдаче яндекса должно отображаться 10 резултатов по запросу {0}")
    @Tags({
            @Tag("BLOCKER"),
            @Tag("WEB")
    })
    void searchResultsShouldBeGreaterThan10(String testData) {
        $("#text").setValue(testData);
        $("button[type='submit']").click();
        $$("li.serp-item").shouldHave(sizeGreaterThanOrEqual(10));
    }

    @Disabled
    @CsvSource(value = {
            "Selenide,         лаконичные и стабильные UI тесты на Java",
            "Allure framework, Allure Framework · GitHub",
    })
//  @CsvFileSource(resources = "/testdata/firstSearchResultsShouldContainExpectedText.csv")
    @ParameterizedTest(name = "В первом результате выдачи для {0} должен отображаться текст {1}")
    @Tags({
            @Tag("BLOCKER"),
            @Tag("WEB")
    })
    void firstSearchResultsShouldContainExpectedText(String testData, String expectedText) {
        $("#text").setValue(testData);
        $("button[type='submit']").click();
        $$("li.serp-item").first().shouldHave(Condition.text(expectedText));
    }

    @Disabled
    @Test
    void photoSearchTest() {
        $(".search3__icon-camera svg").click();
        // etc
    }
}

