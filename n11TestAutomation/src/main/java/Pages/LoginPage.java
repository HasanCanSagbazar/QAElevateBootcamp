package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends BaseTest {

    WebElement element;
    String loginButtonText;

    @Step("Fill mail address")
    public LoginPage fillMail(String email) {

        element = driver.findElement(By.xpath("//input[@id='email']"));
        element.clear();
        element.sendKeys(email);
        screenshot();
        Sleep(300);
        return this;
    }


    @Step("Fill user password")
    public LoginPage fillPassword(String password) {
        element = driver.findElement(By.xpath("//input[@id='password']"));
        element.clear();
        element.sendKeys(password);
        Sleep(300);
        screenshot();
        return this;
    }

    @Step("Click login button")
    public LoginPage clickLogin() {
        element = driver.findElement(By.xpath("//div[@id='loginButton']"));
        element.click();
        screenshot();
        return this;
    }

    @Step("Get login button text")
    public LoginPage getLoginText() {
        element = driver.findElement(By.xpath("//div[@id='loginButton']"));
        Sleep(300);
        loginButtonText = element.getText();
        screenshot();
        return this;
    }

    @Step("Get login button value")
    public String getLoginButtonText() {
        return loginButtonText;
    }

    @Step("Click Subscribe Card to go to signUp page")
        public LoginPage ClickToSubscribeCard(){
        By toSubscribeCard = By.xpath("//a[@class='register-button']");
        element = driver.findElement(toSubscribeCard);
        element.click();
        screenshot();
        return this;
    }

}
