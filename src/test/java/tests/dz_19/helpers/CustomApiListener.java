package tests.dz_19.helpers;

import io.qameta.allure.restassured.AllureRestAssured;

public class CustomApiListener {
    private static final AllureRestAssured FILTER = new AllureRestAssured();

    public static AllureRestAssured withCustomTemplates() {
        FILTER.setRequestTemplate("tpl/request.ftl");
        FILTER.setResponseTemplate("tpl/response.ftl");
        return FILTER;
    }
}
