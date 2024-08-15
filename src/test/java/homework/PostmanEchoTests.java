package homework;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;
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
                () -> response.then().body("args.foo2", equalTo("bar2")),
                () -> response.then().body("url", equalTo("http://postman-echo.com/get?foo1=bar1&foo2=bar2")),
                () -> response.then().body("headers.host", equalTo("postman-echo.com")),
                () -> response.then().body("headers.x-forwarded-proto", equalTo("http")),
                () -> response.then().body("headers.connection", equalTo("close")),
                () -> response.then().body("headers.x-forwarded-port", equalTo("443")),
                () -> response.then().body("headers.accept", equalTo("*/*")),
                () -> response.then().body("headers.accept-encoding", equalTo("gzip,deflate")),
                () -> response.then().body("headers", hasKey("x-request-start")),
                () -> response.then().body("headers", hasKey("x-amzn-trace-id")),
                () -> response.then().body("headers", hasKey("user-agent"))
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
                () -> response.then().body("data", equalTo(bodyText)),
                () -> response.then().body("json", equalTo(null)),
                () -> response.then().body("url", equalTo("http://postman-echo.com/post")),
                () -> response.then().body("headers.host", equalTo("postman-echo.com")),
                () -> response.then().body("headers.x-forwarded-proto", equalTo("http")),
                () -> response.then().body("headers.connection", equalTo("close")),
                () -> response.then().body("headers.content-length", equalTo("58")),
                () -> response.then().body("headers.x-forwarded-port", equalTo("443")),
                () -> response.then().body("headers.accept", equalTo("*/*")),
                () -> response.then().body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1")),
                () -> response.then().body("headers.accept-encoding", equalTo("gzip,deflate")),
                () -> response.then().body("headers", hasKey("x-request-start")),
                () -> response.then().body("headers", hasKey("x-amzn-trace-id")),
                () -> response.then().body("headers", hasKey("user-agent"))
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
                () -> response.then().body("json.foo2", equalTo("bar2")),
                () -> response.then().body("url", equalTo("http://postman-echo.com/post")),
                () -> response.then().body("headers.host", equalTo("postman-echo.com")),
                () -> response.then().body("headers.x-forwarded-proto", equalTo("http")),
                () -> response.then().body("headers.connection", equalTo("close")),
                () -> response.then().body("headers.content-length", equalTo("19")),
                () -> response.then().body("headers.x-forwarded-port", equalTo("443")),
                () -> response.then().body("headers.accept", equalTo("*/*")),
                () -> response.then().body("headers.content-type", equalTo("application/x-www-form-urlencoded; charset=utf-8")),
                () -> response.then().body("headers.accept-encoding", equalTo("gzip,deflate")),
                () -> response.then().body("headers", hasKey("x-request-start")),
                () -> response.then().body("headers", hasKey("x-amzn-trace-id")),
                () -> response.then().body("headers", hasKey("user-agent")),
                () -> response.then().body("$", hasKey("args")),
                () -> response.then().body("$", hasKey("data")),
                () -> response.then().body("$", hasKey("files"))
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
                () -> response.then().body("data", equalTo(bodyText)),
                () -> response.then().body("json", equalTo(null)),
                () -> response.then().body("url", equalTo("http://postman-echo.com/put")),
                () -> response.then().body("$", hasKey("args")),
                () -> response.then().body("$", hasKey("form")),
                () -> response.then().body("$", hasKey("files")),
                () -> response.then().body("headers.host", equalTo("postman-echo.com")),
                () -> response.then().body("headers.x-forwarded-proto", equalTo("http")),
                () -> response.then().body("headers.connection", equalTo("close")),
                () -> response.then().body("headers.content-length", equalTo("58")),
                () -> response.then().body("headers.x-forwarded-port", equalTo("443")),
                () -> response.then().body("headers.accept", equalTo("*/*")),
                () -> response.then().body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1")),
                () -> response.then().body("headers.accept-encoding", equalTo("gzip,deflate")),
                () -> response.then().body("headers", hasKey("x-request-start")),
                () -> response.then().body("headers", hasKey("x-amzn-trace-id")),
                () -> response.then().body("headers", hasKey("user-agent"))
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
                () -> response.then().body("data", equalTo(bodyText)),
                () -> response.then().body("json", equalTo(null)),
                () -> response.then().body("url", equalTo("http://postman-echo.com/patch")),
                () -> response.then().body("$", hasKey("args")),
                () -> response.then().body("$", hasKey("form")),
                () -> response.then().body("$", hasKey("files")),
                () -> response.then().body("headers.host", equalTo("postman-echo.com")),
                () -> response.then().body("headers.x-forwarded-proto", equalTo("http")),
                () -> response.then().body("headers.connection", equalTo("close")),
                () -> response.then().body("headers.content-length", equalTo("58")),
                () -> response.then().body("headers.x-forwarded-port", equalTo("443")),
                () -> response.then().body("headers.accept", equalTo("*/*")),
                () -> response.then().body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1")),
                () -> response.then().body("headers.accept-encoding", equalTo("gzip,deflate")),
                () -> response.then().body("headers", hasKey("x-request-start")),
                () -> response.then().body("headers", hasKey("x-amzn-trace-id")),
                () -> response.then().body("headers", hasKey("user-agent"))
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
                () -> response.then().body("data", equalTo(bodyText)),
                () -> response.then().body("json", equalTo(null)),
                () -> response.then().body("url", equalTo("http://postman-echo.com/delete")),
                () -> response.then().body("$", hasKey("args")),
                () -> response.then().body("$", hasKey("form")),
                () -> response.then().body("$", hasKey("files")),
                () -> response.then().body("headers.host", equalTo("postman-echo.com")),
                () -> response.then().body("headers.x-forwarded-proto", equalTo("http")),
                () -> response.then().body("headers.connection", equalTo("close")),
                () -> response.then().body("headers.content-length", equalTo("58")),
                () -> response.then().body("headers.x-forwarded-port", equalTo("443")),
                () -> response.then().body("headers.accept", equalTo("*/*")),
                () -> response.then().body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1")),
                () -> response.then().body("headers.accept-encoding", equalTo("gzip,deflate")),
                () -> response.then().body("headers", hasKey("x-request-start")),
                () -> response.then().body("headers", hasKey("x-amzn-trace-id")),
                () -> response.then().body("headers", hasKey("user-agent"))
        );
    }
}
