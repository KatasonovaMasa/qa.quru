package tests;

import org.junit.jupiter.api.Test;

public class FillingOutPracticeFormTest extends TestBase {
    @Test
    void successfulLoginTest(){
        String firstname = "Mariya",
            lastname = "Katasonova",
            email = "Mariya.Katasonova@nedra.digit",
            gender = "Female",
            phone = "8902670735",
            subjects = "English",
            hobbies = "Reading",
            address = "Россия, Республика Марий Эл, г. Йошкар-Ола, ул. Первомайская, д.164",
            state = "Haryana",
            city = "Karnal";

        practiceFormPage.openPage()
                .deleteBanerPage()
                .setFirstName(firstname)
                .setLastName(lastname)
                .setEmail(email)
                .setGenderRadio(gender)
                .setUserNumberMobile(phone)
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
                .isResultFormElementPresent("Student Name", firstname + " " + lastname)
                .isResultFormElementPresent("Student Email", email)
                .isResultFormElementPresent("Gender", gender)
                .isResultFormElementPresent("Mobile", phone)
                .isResultFormElementPresent("Date of Birth", "08 January,1989")
                .isResultFormElementPresent("Subjects", subjects)
                .isResultFormElementPresent("Hobbies", hobbies)
                .isResultFormElementPresent("Picture", "QA.gif")
                .isResultFormElementPresent("Address", address)
                .isResultFormElementPresent("State and City", state + " " + city)
                .close();
    }
}
