package org.andreevaelena.homework;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPOSTRawText {
    private final String REQUEST_URL = "https://postman-echo.com";

    @Test
    public void testPOSTRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";
        given()
                .body(requestBody)

                .when()
                .post(REQUEST_URL + "/post")

                .then()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .log().body()
                .log().status();
    }
}

