package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private final SelenideElement dateOfBirth = $("#dateOfBirthInput");
    public void setDate(String day, String month, String year){
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)").click();
    }

    public CalendarComponent setDateOfBirth (){
        dateOfBirth.click();
        return this;
    }
}
