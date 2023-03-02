import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
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
        $x("//*[@id='dateOfBirthInput']").click();
        $(".react-datepicker__month-select").click();
        $x("//option[contains(text(),'January')]").click();
        $(".react-datepicker__year-select").click();
        $x("//option[contains(text(),'1989')]").click();
        $("[aria-label='Choose Sunday, January 8th, 1989']").click();
        //Subjects
        $("#subjectsInput").setValue("English").sendKeys(ENTER);
        //Hobbies
        $("#hobbies-checkbox-2").sendKeys(" ");
        //Picture
        File fileToUpload = new File("src/test/resources/pictures/QA.gif");
        $("#uploadPicture").uploadFile(fileToUpload);
        //Current Address
        $("#currentAddress").setValue("Россия, Республика Марий Эл, г. Йошкар-Ола, ул. Первомайская, д.164");
        //State and City
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        //submit
        $("#submit").sendKeys(ENTER);

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Mariya Katasonova']").shouldBe(visible);
        $x("//td[text()='Mariya.Katasonova@nedra.digit']").shouldBe(visible);
        $x("//td[text()='Female']").shouldBe(visible);
        $x("//td[text()='8902670735']").shouldBe(visible);
        $x("//td[text()='08 January,1989']").shouldBe(visible);
        $x("//td[text()='English']").shouldBe(visible);
        $x("//td[text()='Reading']").shouldBe(visible);
        $x("//td[text()='QA.gif']").shouldBe(visible);
        $x("//td[contains(text(), 'Россия, Республика Марий Эл, г. Йошкар-Ола, ул. Первомайская, д.164')]").shouldBe(visible);
        $x("//td[text()='Haryana Karnal']").shouldBe(visible);
        $x("//button[text()=\"Close\"]").click();
    }
}
