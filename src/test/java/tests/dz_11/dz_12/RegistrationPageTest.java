package tests.dz_11.dz_12;

import com.codeborne.selenide.logevents.SelenideLogger;
import generators.StudentDataGenerator;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import models.StudentData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import steps.RegistrationStudentSteps;
import tests.form.TestBase;


@Tag("demoqa")
public class RegistrationPageTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationStudentSteps registrationStudentSteps = new RegistrationStudentSteps();

    @Test
    @Feature("Форма регистарции студентов")
    @Story("Регистрация на сайте нового студента по steps")
    @Owner("Катасонова Мария")
    @DisplayName("Проверка регистрации нового студента")
    public void registrationFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        registrationStudentSteps.fillingOutTheForm();//заполняем форму регистрации
        registrationStudentSteps.successfulLogin();//проверка удачной регистрации
}

    @Test
    @DisplayName("Проверка регистрации нового студента")
    @Feature("Форма регистарции студентов")
    @Story("Регистрация на сайте нового студента")
    @Owner("Катасонова Мария")
    public void successfulLoginTest() {
        StudentData newStudentData = StudentDataGenerator.getRandomStudent();
        SelenideLogger.addListener("allure", new AllureSelenide());
        //Заполнение формы
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
