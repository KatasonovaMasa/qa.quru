package steps;
import io.qameta.allure.Step;
import pages.BrowserPage;

import static com.codeborne.selenide.Condition.visible;

public class SportmasterSteps {
    BrowserPage browserPage = new BrowserPage();
    @Step("Ввести в поиск 'спортмастер'")
    public void searchYa(){
        browserPage.searchYa().setValue("спортмастер");
    }
    @Step("Нажать кнопку 'Найти'")
    public void findButton(){
        browserPage.findButton().click();
    }
    @Step("Убедиться что в списке результатов есть нужный сайт")
    public void makeSureSportmaster(){
        browserPage.makeSureSportmaster().shouldHave(visible.because("Нужный сайт не найден"));
    }

}
