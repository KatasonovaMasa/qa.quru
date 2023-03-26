package tests.DZ_other;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginTest {
    @Test
    void successfulLoginTest(){
        open("https://qa.guru/cms/system/login");
        $("[name=email]").setValue("Mariya.Katasonova@nedra.digital");
        $("[name=password]").setValue("b&D32ap+3Q");
        $(".btn-success").click();
        $(".main-header__login").click();
        $(".logined-form").shouldHave(text("Мария"));
    }
    @Test
    void successfulLoginWithCommentsTest(){

        open("https://qa.guru/cms/system/login");
        $("[name=email]").setValue("Mariya.Katasonova@nedra.digital");
        $("[name=password]").setValue("b&D32ap+3Q");
        $(".btn-success").click();
        $(".main-header__login").click();
        $(".logined-form").shouldHave(text("Мария"));
    }

}
