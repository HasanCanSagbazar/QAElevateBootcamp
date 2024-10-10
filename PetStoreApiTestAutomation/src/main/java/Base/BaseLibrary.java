package Base;

import io.qameta.allure.Attachment;
import io.restassured.response.Response;

public class BaseLibrary {
    @Attachment(value = "Response Body", type = "application/json")
    public String attachResponseBody(Response response) {
        return response.asString();
    }
}
