package org.andreevaelena.homework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDELETERequest {

    @Test
    public void testDeleteRequest() {
        String baseUrl = "https://postman-echo.com/delete";
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = RestAssured.given()
                .contentType(ContentType.TEXT)
                .body(requestBody)
                .delete(baseUrl);

        int statusCode = response.getStatusCode();
        Assertions.assertEquals(200, statusCode, "Incorrect status code");

        String responseBody = response.getBody().asString();
        Assertions.assertTrue(responseBody.contains(requestBody), "Incorrect response body");

        System.out.println("Response Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);
    }
}
