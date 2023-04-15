package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BrowserPage {

    private final SelenideElement searchYa = $x("//*[@id='text']");
    private final SelenideElement findButton = $x("//button[text()='Найти']");
    private final SelenideElement makeSureSportmaster = $x("//span[contains(text(), '— спортивный магазин для всей семьи!')]//b[text()='Спортмастер']");

    public SelenideElement searchYa(){
        return searchYa;
    }
    public SelenideElement findButton(){
        return findButton;
    }
    public SelenideElement makeSureSportmaster(){
        return makeSureSportmaster;
    }
}
