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
    private final SelenideElement genderRadio = $("#genterWrapper");
    private final SelenideElement userNumber = $("#userNumber");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesCheckbox = $("#hobbiesWrapper");
    private final SelenideElement uploadFromClasspath = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement state = $("#state");
    private final SelenideElement city = $("#city");
    private final SelenideElement submit = $("#submit");
    private final SelenideElement close = $("#closeLargeModal");

    public PracticeFormPage openPage(){
        open("/automation-practice-form");
       return this;
    }

    public PracticeFormPage deleteBanner(){
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

    public PracticeFormPage setGenderRadio(String value) {
        genderRadio.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setUserNumberMobile(String value) {
        userNumber.setValue(value);
        return this;
    }

    public PracticeFormPage setBirthDay (String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPage setHobbiesCheckbox(String value) {
        hobbiesCheckbox.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setUploadFromClasspath(String value) {
        uploadFromClasspath.uploadFromClasspath(value);
        return this;
    }

    public PracticeFormPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public PracticeFormPage setState(String value) {
        state.click();
        state.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setCity(String value) {
        city.click();
        city.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage submit() {
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
