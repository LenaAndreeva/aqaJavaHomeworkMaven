package org.andreevaelena.homework;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGETRequest {
    @Test
    public void testGETRequest() {
        String baseUrl = "https://postman-echo.com/get?foo1=bar1&foo2=bar2";

        Response response = RestAssured.get(baseUrl);

        int statusCode = response.getStatusCode();
        Assertions.assertEquals(200, statusCode, "Incorrect status code");

        statusCode = response.getStatusCode();

        String responseBody = response.getBody().asString();
        Assertions.assertTrue(responseBody.contains("\"foo1\": \"bar1\""), "Incorrect response body");
        Assertions.assertTrue(responseBody.contains("\"foo2\": \"bar2\""), "Incorrect response body");

        responseBody = response.getBody().asString();

        System.out.println("Response Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);
    }
}

