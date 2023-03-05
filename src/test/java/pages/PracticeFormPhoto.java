package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPhoto {
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

    public PracticeFormPhoto openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPhoto deleteBaner(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public PracticeFormPhoto setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPhoto setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPhoto setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public PracticeFormPhoto setGenderRadio(String value) {
        genderRadio.$(byText(value)).click();
        return this;
    }

    public PracticeFormPhoto setUserNumberMobile(String value) {
        userNumber.setValue(value);
        return this;
    }

    public PracticeFormPhoto setBirthDay (String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public PracticeFormPhoto setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public PracticeFormPhoto setHobbiesCheckbox(String value) {
        hobbiesCheckbox.$(byText(value)).click();
        return this;
    }

    public PracticeFormPhoto setUploadFromClasspath(String value) {
        uploadFromClasspath.uploadFromClasspath(value);
        return this;
    }

    public PracticeFormPhoto setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public PracticeFormPhoto setState(String value) {
        state.click();
        state.$(byText(value)).click();
        return this;
    }

    public PracticeFormPhoto setCity(String value) {
        city.click();
        city.$(byText(value)).click();
        return this;
    }

    public PracticeFormPhoto submit() {
        submit.click();
        return this;
    }

    public PracticeFormPhoto verifyModalAppears() {
        resultsModal.verifyModalAppears();
        return this;
    }

    public PracticeFormPhoto isResultFormElementPresent(String key, String value) {
        resultsModal.verifyResult(key, value);
        return this;
    }

    public PracticeFormPhoto close() {
        close.click();
        return this;
    }
}
