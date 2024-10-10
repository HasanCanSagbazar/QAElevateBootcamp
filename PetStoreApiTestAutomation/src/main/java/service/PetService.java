package service;

import io.qameta.allure.Step;
import io.restassured.response.Response;


public class PetService extends BaseService{

    @Step("Add a new pet to the store")
    public Response addPet(Object petBody) {
        String payload = serializeToJson(petBody);
        return postRequest("/pet/", payload);
    }

    @Step("Get pet details by ID: {petId}")
    public Response getPetById(long petId) {
        return getRequest("/pet/" + petId);
    }

    @Step("Get pets by status: {status}")
    public Response getPetByStatus(String status) {
        String payload = "{\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";
        return getRequest("/pet/findByStatus", payload);
    }

    @Step("Update an existing pet's information")
    public Response updatePet(Object petBody) {
        String payload = serializeToJson(petBody);
        return putRequest("/pet/", payload);
    }

    @Step("Delete a pet by ID: {petId}")
    public Response deletePet(long petId) {
        return deleteRequest("/pet/" + petId);
    }
}
