package tests.form;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import generators.StudentDataGenerator;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import model.StudentData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


@Tag("demoqa")
public class RegistrationPageObjectFakerTest extends TestBase{
    Faker faker = new Faker();
    RegistrationPage registrationPage = new RegistrationPage();


 
//    @BeforeAll
//    static void beforeAll() {
//        Configuration.browserSize = "1920x1080";
//        Configuration.baseUrl = "https://demoqa.com";
//    }
    @Test
    @DisplayName("Registration new student")
    @Feature("Сайт gemoga")
    @Story("Регистрация на сайте нового студента")
    @Owner("Катасонова Мария")
    public void successfulLoginTest() {
        StudentData newStudentData = StudentDataGenerator.getRandomStudent();
        SelenideLogger.addListener("allure", new AllureSelenide());

        registrationPage.openPage()
                .setFirstName(newStudentData.getFirstName())
                .setLastName(newStudentData.getLastName())
                .setEmail(newStudentData.getEmail())
                .setGender(newStudentData.getGender())
                .setNumberPhone(newStudentData.getPhone())
                .setBirthDay(newStudentData.getBirtDay(),
                        newStudentData.getBirtMonth(),
                        newStudentData.getBirtYear())
                .setSubjects(newStudentData.getSubject())
                .setHobbies(newStudentData.getHobby())
                .setPhoto(newStudentData.getPhoto())
                .setAddress(newStudentData.getCurrAddress())
                .setState(newStudentData.getState())
                .setCity(newStudentData.getCity())
                .submitStudentForm();

        //Проверка формы
        registrationPage.verifyModalAppears()
                .isResultFormElementPresent("Student Name", newStudentData.getFirstName() + " " + newStudentData.getLastName())
                .isResultFormElementPresent("Student Email", newStudentData.getEmail())
                .isResultFormElementPresent("Gender", newStudentData.getGender())
                .isResultFormElementPresent("Mobile", newStudentData.getPhone())
                .isResultFormElementPresent("Date of Birth", newStudentData.getBirtDay() + " " + newStudentData.getBirtMonth() + "," + newStudentData.getBirtYear())
                .isResultFormElementPresent("Subjects", newStudentData.getSubject())
                .isResultFormElementPresent("Hobbies", newStudentData.getHobby())
                .isResultFormElementPresent("Picture", newStudentData.getPhoto().getName())
                .isResultFormElementPresent("Address", newStudentData.getCurrAddress())
                .isResultFormElementPresent("State and City", newStudentData.getState() + " " + newStudentData.getCity())
                .closeTable();
                registrationPage.takeScreenshot();
    }
}
