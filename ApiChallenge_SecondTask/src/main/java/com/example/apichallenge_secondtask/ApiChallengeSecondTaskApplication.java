package com.example.apichallenge_secondtask;

import io.restassured.RestAssured;
import org.junit.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

@SpringBootApplication
public class ApiChallengeSecondTaskApplication {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080/";
    }

    @Test
    public void testGetInventory() {
        given()
                .when()
                .get("/v2/store/inventory")
                .then()
                .statusCode(200);
    }

    @Test
    public void testPlaceOrder() {
        String requestBody = "{\"id\": 1,\"petId\": 1,\"quantity\": 1,\"shipDate\": \"2022-02-09T15:15:00.000Z\",\"status\": \"placed\",\"complete\": true}";

        given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/v2/store/order")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetOrderById() {
        given()
                .pathParam("orderId", 1)
                .when()
                .get("/v2/store/order/{orderId}")
                .then()
                .statusCode(200)
                .body("id", equalTo(1));
    }

    @Test
    public void testDeleteOrder() {
        given()
                .pathParam("orderId", 1)
                .when()
                .delete("/v2/store/order/{orderId}")
                .then()
                .statusCode(200);
    }
}