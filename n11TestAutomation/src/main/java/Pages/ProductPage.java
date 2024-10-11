package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPage extends BaseTest {

    WebElement element;
    String productTitle;

    @Step("Find product title from product page")
    public ProductPage getProductTitleFromProductPage() {
        element = driver.findElement(By.xpath("//h1[@class='proName']"));
        productTitle = element.getText();
        screenshot();
        return this;
    }
    @Step("Get product title")
    public String getProductTitle() {
        return productTitle;
    }

    @Step("Add product to basket")
    public ProductPage addProductToBasket() {
        element = driver.findElement(By.xpath("//button[@value='static']"));
        element.click();
        screenshot();
        return this;
    }

    @Step("Go to basket page")
    public ProductPage goToBasketPage() {
        element = driver.findElement(By.xpath("//a[@title='Sepetim']"));
        element.click();
        screenshot();
        return this;
    }
}
