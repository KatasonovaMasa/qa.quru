package pages.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import generators.StudentDataGenerator;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import model.StudentData;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class RegistrationStudentSteps {
    RegistrationPage registrationPage = new RegistrationPage();
    StudentData newStudentData = StudentDataGenerator.getRandomStudent();
    Faker faker = new Faker();

    @Step("Заполнение полей формы регистрации")
    public void fillingOutTheForm(){
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
        registrationPage.takeScreenshot();
    }
    @Step("Проверка регистрации")
    public void successfulLogin(){
        SelenideLogger.addListener("allure", new AllureSelenide());
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
