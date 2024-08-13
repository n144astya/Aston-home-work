package homework;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PostmanEchoTests {

    @Test
    public void testGetRequest() throws IOException {

        Response response = given()
                .baseUri("https://postman-echo.com")
                .when()
                .get("get?foo1=bar1&foo2=bar2");
        assertAll(
                () -> response.then().assertThat().statusCode(200),
                () -> response.then().body("args.foo1", equalTo("bar1")),
                () -> response.then().body("args.foo2", equalTo("bar2"))
        );
    }

    @Test
    public void testPostRawText() {
        String bodyText = "This is expected to be sent back as part of response body.";
        Response response = given()
                .baseUri("https://postman-echo.com")
                .header("Content-Type", "text/plain")
                .body(bodyText)
                .when()
                .post("post");

        assertAll(
                () -> response.then().assertThat().statusCode(200),
                () -> response.then().body("data", equalTo(bodyText))
        );
    }
}
