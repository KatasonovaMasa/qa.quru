package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.inject.Inject;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.SportmasterSteps;

import static io.qameta.allure.Allure.step;


public class OpenSportmasterTest {
    @Inject
    private SportmasterSteps sportmasterSteps;

    @BeforeEach
    void setup() {
       Selenide.open("http://ya.ru");
        Configuration.browserSize = "1920x1080";
    //    Configuration.baseUrl = "http://ya.ru";
    }

    @Test
    @Owner("Катасонова Мария")
    @DisplayName("Успешная авторизация")
    @Feature("Форма регистарции")
    @Story("Авторизация на сайте")
    @Disabled("Тот же тест")
    void searchSportmaster(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Ввести в поиск 'спортмастер'", () ->{
            sportmasterSteps.searchYa();
        });
        step("Нажать кнопку 'Найти'", () ->{
            sportmasterSteps.findButton();
        });
        step("Убедиться что в списке результатов есть нужный сайт", () ->{
            sportmasterSteps.makeSureSportmaster();
        });
//        step("Открыть поисковую страницу браузера", () ->{
//
//        });
    }




}
