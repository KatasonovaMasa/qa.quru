package tests.dz_19;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static tests.dz_19.helpers.CustomApiListener.withCustomTemplates;

public class Specs {
    public static RequestSpecification request = with()
            .filter(withCustomTemplates())
            .baseUri("https://reqres.in")
            .basePath("/api")
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    public static ResponseSpecification responseDelete = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .build();

    public static ResponseSpecification responseSuccessAdd = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .build();
    public static ResponseSpecification responseUnsuccess = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .build();
}