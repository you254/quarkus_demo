package org.jared.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;
import static jakarta.ws.rs.core.Response.Status.OK;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BookResourceTest {

    @Test
    void shouldGetAllBooks() {
        given()
                .header(ACCEPT, APPLICATION_JSON)
                .when().get("api/books")
                .then().statusCode(OK.getStatusCode())
                .body("size()", is(5));
    }

    @Test
    void shouldCountAllBooks() {
        given()
                .header(ACCEPT, TEXT_PLAIN)
                .when().get("api/books/count")
                .then().statusCode(OK.getStatusCode())
                .body(is("5"));
    }

    @Test
    void shouldGetABook() {
        given()
                .header(ACCEPT, APPLICATION_JSON)
                .pathParam("id", 1)
                .when().get("api/books/{id}")
                .then().statusCode(OK.getStatusCode())
                .body("title", is("Understanding Quarkus"))
                .body("author", is("Antonio"))
                .body("year", is(2020))
                .body("genre", is("IT"));
    }

}