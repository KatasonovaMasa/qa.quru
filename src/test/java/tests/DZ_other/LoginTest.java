package tests.DZ_other;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.form.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("qa_quru")
public class LoginTest extends TestBase {

    @Test
    @Owner("Катасонова Мария")
    @DisplayName("Успешная авторизация")
    @Feature("Форма регистарции")
    @Story("Авторизация на сайте")
    @Disabled("Тот же тест")
    void successfulLoginTest(){
        open("https://qa.guru/cms/system/login");
        $("[name=email]").setValue("qagurubot@gmail.com");
        $("[name=password]").setValue("qagurupassword");
        $(".btn-success").click();
        $(".main-header__login").click();
        $(".logined-form").shouldHave(text("QA_GURU_BOT"));
    }
    @Test
    @Owner("Катасонова Мария")
    @DisplayName("Успешная авторизация с комментариями")
    @Feature("Форма регистарции")
    @Story("Авторизация на сайте")
    void successfulLoginWithCommentsTest(){
//        Открыть форму авторизации
        open("https://qa.guru/cms/system/login");
//        Ввести адрес электронной почты
        $("[name=email]").setValue("qagurubot@gmail.com");
//        Ввести пароль
        $("[name=password]").setValue("qagurupassword");
//        Нажать кнопку "Войти"
        $(".btn-success").click();
//        Нажать на кнопку "Личный кабинет"
        $(".main-header__login").click();
//        Проверить успешную авторизацию
        $(".logined-form").shouldHave(text("QA_GURU_BOT"));
}
    @Test
    public void exitTest(){
        $("button[text='Сменить пользователя']");
    }
}
