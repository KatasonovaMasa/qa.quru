package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsModal resultsModal = new ResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadio = $("#gender-radio-2"),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesCheckbox = $("#hobbiesWrapper"),
            uploadFromClasspath = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            submit = $("#submit"),

            close = $("#closeLargeModal");

    public PracticeFormPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPage setFirstNameInput(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastNameInput(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setEmailInput(String value) {
        emailInput.setValue(value);
        return this;
    }

    public PracticeFormPage setGenderRadio(String gender) {
        genderRadio.sendKeys(" ");
        return this;
    }
    public PracticeFormPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public PracticeFormPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage setHobbiesCheckbox(String hobbies) {
        hobbiesCheckbox.$(byText("Reading")).click();
        return this;
    }

    public PracticeFormPage setUploadFromClasspath() {
        uploadFromClasspath.uploadFromClasspath("pictures/QA.gif");
        return this;
    }

    public PracticeFormPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }
    public PracticeFormPage setState(String value) {
        state.click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
      //  $("#react-select-3-option-2").click();
        return this;
    }

    public PracticeFormPage setCity(String value) {
        city.click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        return this;
    }

    public PracticeFormPage setSubmit() {
        submit.click();
        return this;
    }
    public PracticeFormPage verifyModalAppears() {
        resultsModal.verifyModalAppears();
        return this;
    }
    public PracticeFormPage verifyResult(String key, String value) {
        resultsModal.verifyResult(key, value);
        return this;
    }

    public PracticeFormPage close() {
        close.click();
        return this;
    }
}
