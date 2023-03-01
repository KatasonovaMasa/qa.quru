import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


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

//      Открыть форму авторизации
        open("https://qa.guru/cms/system/login");

//      Ввести адрес электронной почты
        $("[name=email]").setValue("Mariya.Katasonova@nedra.digital");
//      Ввести пароль
        $("[name=password]").setValue("b&D32ap+3Q");
//       Нажать на кнопку "Войти"
        $(".btn-success").click();
//       Нажать на кнопку "Личный кабинет"
        $(".main-header__login").click();

//      Проверить успешную авторизацию
        $(".logined-form").shouldHave(text("Мария"));
    }

}
