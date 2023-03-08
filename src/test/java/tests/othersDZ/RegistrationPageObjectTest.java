package tests.othersDZ;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationPageObjectTest {
    RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void successfulLoginTest(){

//        practiceFormPage.openPage()
//                .deleteBanner()
//                .setFirstName(firstname)
//                .setLastName(lastname)
//                .setEmail(email)
//                .setGenderRadio(gender)
//                .setUserNumberMobile(phone)
//                .setBirthDay(day, month, year)
//                .setSubjectsInput(subjects)
//                .setHobbiesCheckbox(hobbies)
//                .setUploadFromClasspath(upload)
//                .setCurrentAddress(address)
//                .setState(state)
//                .setCity(city)
//                .submit();
//
//       //Проверка формы
//        practiceFormPage.verifyModalAppears()
//                .isResultFormElementPresent("Student Name", firstname + " " + lastname)
//                .isResultFormElementPresent("Student Email", email)
//                .isResultFormElementPresent("Gender", gender)
//                .isResultFormElementPresent("Mobile", phone)
//                .isResultFormElementPresent("Date of Birth", day + " " +  month + "," + year)
//                .isResultFormElementPresent("Subjects", subjects)
//                .isResultFormElementPresent("Hobbies", hobbies)
//                .isResultFormElementPresent("Picture", "QA.gif")
//                .isResultFormElementPresent("Address", address)
//                .isResultFormElementPresent("State and City", state + " " + city)
//                .close();
    }
}
