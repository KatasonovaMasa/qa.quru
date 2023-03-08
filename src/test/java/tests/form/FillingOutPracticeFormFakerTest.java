package tests.form;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static utils.RandomUtils.*;

public class FillingOutPracticeFormFakerTest {
    Faker faker = new Faker();
    PracticeFormPage practiceFormPage = new PracticeFormPage();
 
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void successfulLoginTest() {
        String firstname = faker.name().firstName(),
                lastname = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                gender = getRandomItemFromArray(genders),
                phone = "8" + faker.number().numberBetween(100000000, 999999999),
                day = "08",
                month = "January",
                year = "1989",
                subject = getRandomItemFromArray(subjects),
                hobbies = getRandomItemFromArray(hobbiess),
                upload = "pictures/QA.gif",
                address = faker.address().fullAddress(),
                state = "NCR",
                city = getRandomItemFromArray(citys);

        practiceFormPage.openPage()
                .deleteBanner()
                .setFirstName(firstname)
                .setLastName(lastname)
                .setEmail(email)
                .setGenderRadio(gender)
                .setUserNumberMobile(phone)
                .setBirthDay(day, month, year)
                .setSubjectsInput(subject)
                .setHobbiesCheckbox(hobbies)
                .setUploadFromClasspath(upload)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .submit();

        //Проверка формы
        practiceFormPage.verifyModalAppears()
                .isResultFormElementPresent("Student Name", firstname + " " + lastname)
                .isResultFormElementPresent("Student Email", email)
                .isResultFormElementPresent("Gender", gender)
                .isResultFormElementPresent("Mobile", phone)
                .isResultFormElementPresent("Date of Birth", day + " " + month + "," + year)
                .isResultFormElementPresent("Subjects", subject)
                .isResultFormElementPresent("Hobbies", hobbies)
                .isResultFormElementPresent("Picture", "QA.gif")
                .isResultFormElementPresent("Address", address)
                .isResultFormElementPresent("State and City", state + " " + city)
                .close();
    }
}
