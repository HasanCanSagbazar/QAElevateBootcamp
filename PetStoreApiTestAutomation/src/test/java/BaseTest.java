import Base.BaseLibrary;
import io.restassured.RestAssured;
import org.junit.BeforeClass;


public class BaseTest extends BaseLibrary {
    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }
}

