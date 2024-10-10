package service;

import io.qameta.allure.Step;
import io.restassured.response.Response;
public class UserService extends BaseService{

    @Step("Create a new user")
    public Response createUser(Object body) {
        String payload = serializeToJson(body);
        return postRequest("/user/", payload);
    }

    @Step("Get user details by username: {userName}")
    public Response getUserByUsername(String userName) {
        return getRequest("/user/" + userName);
    }

    @Step("Update user information for username: {userName}")
    public Response updateUser(Object body, String userName) {
        String payload = serializeToJson(body);
        return putRequest("/user/" + userName, payload);
    }

    @Step("Log in a user with provided credentials")
    public Response login(Object body) {
        String payload = serializeToJson(body);
        return getRequestParam("/user/login", payload);
    }

    @Step("Log out the current user")
    public Response logout() {
        return getRequest("/user/logout/");
    }

    @Step("Delete user by username: {userName}")
    public Response deleteUser(String userName) {
        return deleteRequest("/user/" + userName);
    }
}
