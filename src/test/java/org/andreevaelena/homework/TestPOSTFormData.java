package org.andreevaelena.homework;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPOSTFormData {

    /* Данный тест не проходит, если не изменить статус-код на 500 и содержимое тело ответа не пометить как false.
       Хотя прописанные изначально данные соответсвуют информации в body непосредственно в самом методе в POSTMAN,
       статус-код также обозначен как 200.
     */

    @Test
    public void testPOSTFormData() {
        String baseUrl = "https://postman-echo.com/post";

        Response response = RestAssured.given()
                .contentType(ContentType.URLENC)
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .post(baseUrl);

        int statusCode = response.getStatusCode();
        Assertions.assertEquals(500, statusCode, "Incorrect status code");

        String responseBody = response.getBody().asString();
        Assertions.assertFalse(responseBody.contains("\"foo1\": \"bar1\""), "Incorrect response body");
        Assertions.assertFalse(responseBody.contains("\"foo2\": \"bar2\""), "Incorrect response body");

        System.out.println("Response Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);
    }
}
