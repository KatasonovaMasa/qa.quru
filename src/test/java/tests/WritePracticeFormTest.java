package tests;

import org.junit.jupiter.api.Test;

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
                .deleteBanerPage()
                .setFirstName(username)
                .setLastName(lastname)
                .setEmail(email)
                .setGenderRadio(gender)
                .setUserNumberMobile(number)
                .setBirthDate("08", "January", "1989")
                .setSubjectsInput(subjects)
                .setHobbiesCheckbox(hobbies)
                .setUploadFromClasspath()
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .submit()
        ;

       //Проверка формы
        practiceFormPage.verifyModalAppears()
                .isResultFormElementPresent("Student Name", username + " " + lastname)
                .isResultFormElementPresent("Student Email", email)
                .isResultFormElementPresent("Gender", gender)
                .isResultFormElementPresent("Mobile", number)
                .isResultFormElementPresent("Date of Birth", "08 January,1989")
                .isResultFormElementPresent("Subjects", subjects)
                .isResultFormElementPresent("Hobbies", hobbies)
                .isResultFormElementPresent("Picture", picture)
                .isResultFormElementPresent("Address", address)
                .isResultFormElementPresent("State and City", state + " " + city)
                .close();
    }
}
