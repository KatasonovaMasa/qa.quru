package tests.form;

import help.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1900x1080";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "100";//нельзя ставить версию больше чем на selenoid
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub"; //запускает автотесты не локально а через selenoid

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enaenableVNC", true,
                "enableVideo", true
        ));
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterAll
    static void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
