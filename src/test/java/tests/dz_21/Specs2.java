package tests.dz_21;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class Specs2 {
    public static RequestSpecification request = with()
            .baseUri("https://store.steampowered.com")
            .basePath("/search")
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
//            .expectBody(containsString("success"))
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