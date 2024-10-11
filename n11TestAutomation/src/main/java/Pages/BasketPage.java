package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasketPage extends BaseTest {

    WebElement element;
    boolean basketIsEmpty;
    int productSize;

    @Step("Control whether basket is empty")
    public BasketPage isBasketEmpty() {
        List<WebElement> items = driver.findElements(By.xpath("//h2[@class='title']"));

        basketIsEmpty = items.isEmpty();
        screenshot();
        return this;
    }

    @Step("Get basket empty status")
    public boolean getBasketEmptyStatus() {
        return basketIsEmpty;
    }

    @Step("Click garbage icon to delete product from basket")
    public BasketPage clickGarbageIcon() {
        element = driver.findElement(By.xpath("//span[@title='Sil']"));
        element.click();
        screenshot();
        Sleep(300);
        return this;
    }

    @Step("Click delete button to delete product from basket")
    public BasketPage clickDeleteButton() {
        element = driver.findElement(By.xpath("//span[@id='deleteBtnDFLB']"));
        element.click();
        screenshot();
        Sleep(300);
        return this;
    }

    @Step("Control whether selected product is added to basket")
    public BasketPage getProductSize() {
        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

        productSize = rows.size();
        screenshot();
        return this;
    }

    @Step("Get product size")
    public int getProductSizeValue() {
        return productSize;
    }

    @Step("Click clarification text")
    public BasketPage clickClarificationText() {
        element = driver.findElement(By.xpath("//span[@class='btn btnBlack']"));
        element.click();
        screenshot();
        return this;
    }

}
