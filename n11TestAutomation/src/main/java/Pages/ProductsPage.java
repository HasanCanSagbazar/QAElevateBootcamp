package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BaseTest {

    WebElement element;
    String searchName;
    String productName;
    String notFoundProduct;
    Random rand = new Random();
    int randomIndex;

    @Step("Find search title")
    public ProductsPage getProductTitle() {
        searchName = driver.findElement(By.xpath("//ul[@class='clearfix']//span[contains(text(),'laptop')]")).getText();
        screenshot();
        return this;
    }

    @Step("Get product name")
    public String getProductName() {
        return searchName;
    }


    @Step("Click random item")
    public ProductsPage clickRandomItem() {
        List<WebElement> items = driver.findElements(By.xpath("//ul[@id='listingUl']/li"));

        randomIndex = rand.nextInt(4);

        element = items.get(randomIndex);
        element.click();
        screenshot();
        return this;
    }


    @Step("Find product name")
    public ProductsPage getProductNameFromProductPage() {
        productName = driver.findElement(By.xpath("//ul[@id='listingUl']/li["+randomIndex+"]/div[@class='columnContent']/div[@class='pro']/a[@class='plink']/h3[@class='productName']")).getText();
        screenshot();
        return this;
    }

    @Step("Get product name from product page")
    public String getProductNameFromProductPageText() {
        return productName;
    }

    @Step("Not Found Product")
    public ProductsPage notFoundProduct() {
        element = driver.findElement(By.xpath("//div[@class=\"notFound\"]/h1"));
        notFoundProduct = element.getText();
        screenshot();
        return this;
    }

    @Step("Get not found product")
    public String getNotFoundProduct() {
        return notFoundProduct;
    }
}
