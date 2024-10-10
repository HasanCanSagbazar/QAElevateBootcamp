import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.Login;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import service.UserService;
import model.User;

@Feature("User Test Scenarios")
public class UserTest extends BaseTest{
    UserService userService;

    @BeforeMethod
    public static void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test(priority = 1, description = "create user")
    public void createUserTest(){
        userService = new UserService();
        User user = new User(
                1,                      // id
                "john_doe",                // username
                "John",                    // firstName
                "Doe",                     // lastName
                "john.doe@example.com",    // email
                "securePassword123",       // password
                "+123456789",              // phone
                1                          // userStatus
        );

        Response createResponse = userService.createUser(user);
        Assert.assertEquals(createResponse.getStatusCode(), 200);

        attachResponseBody(createResponse);
    }

    @Test(priority = 2, description = "Find user by username")
    public void findUserbyUsername(){
        userService = new UserService();
        Response findResponse = userService.getUserByUsername("john_doe");
        Assert.assertEquals(findResponse.getStatusCode(), 200);

        attachResponseBody(findResponse);
    }

    @Test(priority = 3, description = "User login")
    public void userLogin(){
        userService = new UserService();

        Login login = new Login(
                "john_doe",
                "securePassword123"
        );
        userService.login(login);
        Response loginResponse = userService.login(login);
        Assert.assertEquals(loginResponse.getStatusCode(), 200);

        attachResponseBody(loginResponse);
    }


    @Test(priority = 4, description = "User logout")
    public void userLogout(){
        userService = new UserService();
        Response logoutResponse = userService.logout();
        Assert.assertEquals(logoutResponse.getStatusCode(), 200);

        attachResponseBody(logoutResponse);
    }


    @Test(priority = 5, description = "Delete user")
    public void deleteUser(){
        userService = new UserService();
        Response deleteResponse = userService.deleteUser("john_doe");
        Assert.assertEquals(deleteResponse.getStatusCode(), 200);

        attachResponseBody(deleteResponse);
    }
}
