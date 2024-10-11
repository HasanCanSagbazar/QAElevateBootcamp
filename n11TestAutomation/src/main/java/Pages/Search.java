package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Search extends BaseTest {

    WebElement element;
    @Step("Click search bar")
    public Search clickSearchBar() {
        element = driver.findElement(By.xpath("//input[@id='searchData']"));
        element.click();
        screenshot();
        return this;
    }

    @Step("Type {text} to search bar")
    public Search typeToSearchBar(String text) {
        element.clear();
        element = driver.findElement(By.xpath("//input[@id='searchData']"));
        element.sendKeys(text);
        screenshot();
        return this;
    }

    @Step("Click search bar button")
    public Search clickSearchBarButton() {
        element = driver.findElement(By.xpath("//a[@class='searchBtn']"));
        element.click();
        screenshot();
        return this;
    }
}
