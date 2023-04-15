package pages;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class SportmasterPage {

    public SportmasterPage openPage(){
        open("https://www.sportmaster.ru/");
        return this;
    }

}
