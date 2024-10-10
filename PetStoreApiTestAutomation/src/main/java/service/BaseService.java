package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class BaseService {

    private final ObjectMapper objectMapper;

    public BaseService() {
        this.objectMapper = new ObjectMapper(); // Jackson ObjectMapper
    }

    public String serializeToJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException("JSON serileştirme hatası: " + e.getMessage(), e);
        }
    }

    @Step("Send GET request to endpoint: {endpoint}")
    public Response getRequest(String endpoint) {
        return given()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    @Step("Send GET request to endpoint: {endPoint} with query parameters")
    public Response getRequest(String endPoint, String payload) {
        return given()
                .queryParam(payload)
                .when()
                .get(endPoint)
                .then()
                .extract()
                .response();
    }

    @Step("Send POST request to endpoint: {endpoint} with body")
    public Response postRequest(String endpoint, Object body) {
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    @Step("Send GET request to endpoint: {endpoint} with query parameter payload")
    public Response getRequestParam(String endpoint, String payload) {
        return given()
                .contentType("application/json")
                .queryParam(payload)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    @Step("Send DELETE request to endpoint: {endpoint}")
    public Response deleteRequest(String endpoint) {
        return given()
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }

    @Step("Send PUT request to endpoint: {endpoint} with body")
    public Response putRequest(String endpoint, Object body) {
        return given()
                .contentType("application/json")
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }
}

