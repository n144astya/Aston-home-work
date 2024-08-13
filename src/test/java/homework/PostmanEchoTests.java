package homework;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostmanEchoTests {

    @Test
    public void testGetRequestStatusCode(){
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .get("get?foo1=bar1&foo2=bar2")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
