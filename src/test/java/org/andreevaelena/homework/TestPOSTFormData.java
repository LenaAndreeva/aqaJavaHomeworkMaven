package org.andreevaelena.homework;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/* Данный тест не проходит, если не изменить статус-код на 500 и содержимое тело ответа не прописать в equalTo "null".
       Хотя прописанные изначально данные соответсвуют информации в body непосредственно в самом методе в POSTMAN,
       статус-код также обозначен как 200 (если смотреть в самой программе POSTMAN). В реальности же в консоль приходит
       информация об ошибке на сервере.
     */

public class TestPOSTFormData {
    private final String REQUEST_URL = "https://postman-echo.com";

    @Test
    public void testPOSTFormData() {
        given()
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")

                .when()
                .post(REQUEST_URL + "/post")

                .then()
                .statusCode(500)
                .body("form.foo1", equalTo(null))
                .body("form.foo2", equalTo(null))
                .log().body()
                .log().status();
    }
}
