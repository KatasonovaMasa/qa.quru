package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WritePracticeFormTest extends TestBase {


    @Test
    void successfulLoginTest(){
        String username = "Mariya",
            lastname = "Katasonova",
            email = "Mariya.Katasonova@nedra.digit",
            gender = "Female",
            number = "8902670735",
            subjects = "English",
            hobbies = "Reading",
            picture = "QA.gif",
            address = "Россия, Республика Марий Эл, г. Йошкар-Ола, ул. Первомайская, д.164",
            state = "Haryana",
            city = "Karnal";

        practiceFormPage.openPage()
                .setFirstNameInput(username)
                .setLastNameInput(lastname)
                .setEmailInput(email)
                .setGenderRadio(gender)
                .setUserNumber(number)
                .setBirthDate("08", "January", "1989")
                .setSubjectsInput(subjects)
                .setHobbiesCheckbox(hobbies)
                .setUploadFromClasspath()
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .setSubmit()
        ;

       //Проверка формы
        practiceFormPage.verifyModalAppears()
                .verifyResult("Student Name", username + " " + lastname)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", number)
                .verifyResult("Date of Birth", "08 January,1989")
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", picture)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city)
                .close();
    }
}
