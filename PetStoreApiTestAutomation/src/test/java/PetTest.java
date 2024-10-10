import io.qameta.allure.Feature;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.Category;
import model.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import service.PetService;

import java.util.Arrays;
import java.util.Collections;

@Feature("Pet Test Scenarios")
public class PetTest extends BaseTest{
    PetService petService;

    @BeforeMethod
    public static void setUp() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @Test(priority = 1, description = "Add a new pet")
    public void addPetTest() {
        petService = new PetService();
        Category category = new Category(1, "Dog");
        Tag tag = new Tag(1, "cute");
        Pet newPet = new Pet(123456789, category, "doggie", Arrays.asList("url1", "url2"), Collections.singletonList(tag), "available");

        Response addResponse = petService.addPet(newPet);
        Assert.assertEquals(addResponse.getStatusCode(), 200);

        attachResponseBody(addResponse);
    }

    @Test(priority = 2, description = "Find pet by id")
    public void findPetByIdTest(){
        petService = new PetService();

        Response findResponse = petService.getPetById(123456789);
        Assert.assertEquals(findResponse.getStatusCode(), 200);

        attachResponseBody(findResponse);
    }

    @Test(priority = 3, description = "Find pet by status that is available")
    public void findPetByStatusTest(){
        petService = new PetService();

        Response findResponse = petService.getPetByStatus("available");
        Assert.assertEquals(findResponse.getStatusCode(), 200);

        attachResponseBody(findResponse);
    }

    @Test(priority = 4, description = "Update pet")
    public void updatePet(){
        petService = new PetService();
        Category category = new Category(1, "Dog");
        Tag tag = new Tag(1, "playful");
        Pet updatePet = new Pet(123456789, category, "doggie", Arrays.asList("url1", "url2"), Collections.singletonList(tag), "available");

        Response updateResponse = petService.updatePet(updatePet);
        Assert.assertEquals(updateResponse.getStatusCode(), 200);

        attachResponseBody(updateResponse);
    }

    @Test(priority = 5, description = "Delete pet")
    public void deletePet(){
        petService = new PetService();
        Response deleteResponse = petService.deletePet(123456789);
        Assert.assertEquals(deleteResponse.getStatusCode(), 200);

        attachResponseBody(deleteResponse);
    }

}
