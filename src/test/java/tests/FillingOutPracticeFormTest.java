package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPhoto;

public class FillingOutPracticeFormTest {
    PracticeFormPhoto practiceFormPhoto = new PracticeFormPhoto();
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void successfulLoginTest(){
        String firstname = "Mariya",
            lastname = "Katasonova",
            email = "Mariya.Katasonova@nedra.digit",
            gender = "Female",
            phone = "8902670735",
            day = "08",
            month = "January",
            year = "1989",
            subjects = "English",
            hobbies = "Reading",
            upload = "pictures/QA.gif",
            address = "Россия, Республика Марий Эл, г. Йошкар-Ола, ул. Первомайская, д.164",
            state = "Haryana",
            city = "Karnal";

        practiceFormPhoto.openPage()
                .deleteBaner()
                .setFirstName(firstname)
                .setLastName(lastname)
                .setEmail(email)
                .setGenderRadio(gender)
                .setUserNumberMobile(phone)
                .setBirthDay(day, month, year)
                .setSubjectsInput(subjects)
                .setHobbiesCheckbox(hobbies)
                .setUploadFromClasspath(upload)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .submit()
        ;

       //Проверка формы
        practiceFormPhoto.verifyModalAppears()
                .isResultFormElementPresent("Student Name", firstname + " " + lastname)
                .isResultFormElementPresent("Student Email", email)
                .isResultFormElementPresent("Gender", gender)
                .isResultFormElementPresent("Mobile", phone)
                .isResultFormElementPresent("Date of Birth", day + " " +  month + "," + year)
                .isResultFormElementPresent("Subjects", subjects)
                .isResultFormElementPresent("Hobbies", hobbies)
                .isResultFormElementPresent("Picture", "QA.gif")
                .isResultFormElementPresent("Address", address)
                .isResultFormElementPresent("State and City", state + " " + city)
                .close();
    }
}
