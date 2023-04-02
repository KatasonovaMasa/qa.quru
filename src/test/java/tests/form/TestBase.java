package tests.form;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import help.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.remote = "https://user1:1234@" + System.getProperty("selenoid_url", "selenoid.autotests.cloud/wd/hub"); //запускает автотесты не локально а через selenoid
        Configuration.baseUrl = System.getProperty("baseurl", "https://demoqa.com");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browser_version", "100.0");//нельзя ставить версию больше чем на selenoid
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");


        //конфиг что бы добавилось enableVNC - это мы включаем что бы было окошко в окошке в Selenoid
        //, enableVideo - вкл.запись видео происходит + ниже есть настройка Attach.addVideo(); // ЗАПИСЬ ВИДЕО
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enaenableVNC", true,
                "enableVideo", true
        ));
//        capabilities.setCapability("enableVNC", true); //тоже самое что и верхние две строчки
//        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    //Перед каждым тестом записываем шаги с step-ы что бы если мы развернули их видно было что где прошло или упало
    @BeforeEach
    void addListener(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    // добавляется сценарий теста как в IDEA (шаги)
    // + в build.gradle добавили сначало зависимость "io.qameta.allure:allure-selenide:2.13.6"

    //Перед этими настройками добавили файл в дирректорию java/helpers название файла Attach c методами
    @AfterAll
    static void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
