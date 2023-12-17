package org.andreevaelena.homework;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestGETRequest {
    private final String REQUEST_URL = "https://postman-echo.com";

    @Test
    public void testGETRequest() {
        given()
                .param("foo1", "bar1")
                .param("foo2", "bar2")

                .when()
                .get(REQUEST_URL + "/get")

                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .log().body()
                .log().status();
    }
}
