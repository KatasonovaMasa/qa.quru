package tests.DZ_other;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.RegistrationResultsModal;

import java.io.File;

public class RegistrationPageObjectTest {
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    File photo = new File("src/test/resources/pictures/QA.gif");
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void successfulLoginTest(){
        String day = "8",
               month = "January",
               year = "1989";


        registrationPage.openPage()
                .setFirstName("Мария")
                .setLastName("Катасонова")
                .setEmail("katas@guru.com")
                .setGender("Female")
                .setNumberPhone("7305925458")
 //               .setBirthDay(day, month, year)
                .setSubjects("English")
                .setHobbies("Reading")
                .setPhoto(photo)
                .setAddress("221b Baker St, Marylebone, London")
                .setState("Haryana")
                .setCity("Karnal")
                .submitStudentForm();

       //Проверка формы
        registrationPage.verifyModalAppears()
                .isResultFormElementPresent("Student Name", "Мария Катасонова")
                .isResultFormElementPresent("Student Email", "katas@guru.com")
                .isResultFormElementPresent("Gender", "Female")
                .isResultFormElementPresent("Mobile", "7305925458")
   //             .isResultFormElementPresent("Date of Birth", day + " " + month + " " + year)
                .isResultFormElementPresent("Subjects", "English")
                .isResultFormElementPresent("Hobbies", "Reading")
                .isResultFormElementPresent("Picture", "QA.gif")
                .isResultFormElementPresent("Address", "221b Baker St, Marylebone, London")
                .isResultFormElementPresent("State and City", "Haryana Karnal");
        registrationResultsModal.closeResultTable();
    }
}
