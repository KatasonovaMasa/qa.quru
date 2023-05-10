package tests.dz_21;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class AllureSteps {

    @Step("Create new test case with name [{name}]")
    public String createNewTestCase() {
        $(byName("name")).setValue("name").pressEnter();
        return null;
    }
}
