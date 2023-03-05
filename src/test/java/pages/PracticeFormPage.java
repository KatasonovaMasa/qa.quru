package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final ResultsModal resultsModal = new ResultsModal();
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderRadio = $("#gender-radio-2");
    private final SelenideElement userNumber = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesCheckbox = $("#hobbiesWrapper");
    private final SelenideElement uploadFromClasspath = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement state = $("#state");
    private final SelenideElement city = $("#city");
    private final SelenideElement submit = $("#submit");
    private final SelenideElement close = $("#closeLargeModal");

    String upload = "pictures/QA.gif";

    public PracticeFormPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPage deleteBanerPage(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }


    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public PracticeFormPage setGenderRadio(String gender) {
        genderRadio.sendKeys(" ");
        return this;
    }
    public PracticeFormPage setUserNumberMobile(String value) {
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
        uploadFromClasspath.uploadFromClasspath(upload);
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
    public PracticeFormPage isResultFormElementPresent(String key, String value) {
        resultsModal.verifyResult(key, value);
        return this;
    }

    public PracticeFormPage close() {
        close.click();
        return this;
    }
}
