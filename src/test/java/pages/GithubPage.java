package pages;

import static com.codeborne.selenide.Selenide.open;

public class GithubPage {
    public GithubPage openPage(){
        open("https://github.com/KatasonovaMasa/qa.quru");
        return this;
    }
    public GithubPage searhRepo() {
        open("KatasonovaMasa/qa.quru");
        return this;
    }
}
