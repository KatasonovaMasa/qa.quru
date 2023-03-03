import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.ENTER;

public class WritePracticeForm {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successfulLoginTest(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        //Name
        $("#firstName").setValue("Mariya");
        $("#lastName").setValue("Katasonova");
        //Email
        $("#userEmail").setValue("Mariya.Katasonova@nedra.digit");
        //Gender
        $("#gender-radio-2").sendKeys(" ");
        //Mobile
        $("#userNumber").setValue("8902670735");
        //Date of Birrth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("January")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("1989")).click();
        $("[aria-label='Choose Sunday, January 8th, 1989']").click();
        //Subjects
        $("#subjectsInput").setValue("English").pressEnter();
        //Hobbies
        $("#hobbies-checkbox-2").sendKeys(" ");
        //Picture
        $("#uploadPicture").uploadFromClasspath("pictures/QA.gif");
        //Current Address
        $("#currentAddress").setValue("Россия, Республика Марий Эл, г. Йошкар-Ола, ул. Первомайская, д.164");
        //State and City
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        //submit
        $("#submit").pressEnter();
       //Проверка формы
        $(".modal-content").shouldHave(text("Thanks for submitting the form"),
                text("Mariya Katasonova"), text("Mariya.Katasonova@nedra.digit"), text("Female"), text("8902670735"), text("08 January,1989"),
                text("English"), text("Reading"), text("QA.gif"), text("Россия, Республика Марий Эл, г. Йошкар-Ола, ул. Первомайская, д.164"),
                text("Haryana Karnal"));
        $("#closeLargeModal").click();
    }
}
