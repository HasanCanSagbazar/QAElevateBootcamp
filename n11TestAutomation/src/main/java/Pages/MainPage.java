package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends BaseTest {

    WebElement element;
    private String accountValue;

    @Step("Get Account Name")
    public MainPage getAccountName() {
        accountValue = driver.findElement(By.cssSelector("//a[@title='Hesabım']")).getText();
        screenshot();
        return this;
    }

    @Step("Get Account Name Value")
    public String getAccountValue() {
        return accountValue;
    }
}
