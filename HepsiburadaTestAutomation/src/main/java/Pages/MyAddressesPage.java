package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAddressesPage extends BaseTest {
    WebElement element;

    @Step("Click add new address button")
    public MyAddressesPage clickAddNewAddressButton() {
        element = driver.findElement( By.xpath("//div[@id='addButton']"));
        element.click();
        screenshot();
        return this;
    }

    @Step("calculate how many addresses there are")
    public int countAddresses() {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='address']"));
        return elements.size();
    }
}
