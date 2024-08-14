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
                .contentType("text/plain")
                .body(bodyText)
                .when()
                .post("post");

        assertAll(
                () -> response.then().assertThat().statusCode(200),
                () -> response.then().body("data", equalTo(bodyText))
        );
    }

    @Test
    public void testPostFormData() {
        Response response = given()
                .baseUri("https://postman-echo.com")
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("post");

        assertAll(
                () -> response.then().assertThat().statusCode(200),
                () -> response.then().body("form.foo1", equalTo("bar1")),
                () -> response.then().body("form.foo2", equalTo("bar2")),
                () -> response.then().body("json.foo1", equalTo("bar1")),
                () -> response.then().body("json.foo2", equalTo("bar2"))
        );
    }

    @Test
    public void testPutRawText() {
        String bodyText = "This is expected to be sent back as part of response body.";
        Response response = given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain")
                .body(bodyText)
                .when()
                .put("put");

        assertAll(
                () -> response.then().assertThat().statusCode(200),
                () -> response.then().body("data", equalTo(bodyText))
        );
    }

    @Test
    public void testPatchRawText() {
        String bodyText = "This is expected to be sent back as part of response body.";
        Response response = given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain")
                .body(bodyText)
                .when()
                .patch("patch");

        assertAll(
                () -> response.then().assertThat().statusCode(200),
                () -> response.then().body("data", equalTo(bodyText))
        );
    }

    @Test
    public void testDeleteRawText() {
        String bodyText = "This is expected to be sent back as part of response body.";
        Response response = given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain")
                .body(bodyText)
                .when()
                .delete("delete");

        assertAll(
                () -> response.then().assertThat().statusCode(200),
                () -> response.then().body("data", equalTo(bodyText))
        );
    }
}
