package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SubscribePage extends BaseTest {
    WebElement element;
    private String verificationButtonText;

    @Step("Enter first name: {fName}")
    public SubscribePage fillFirstName(String fName) {
        By firstName = By.xpath("//input[@id='firstName']");
        WebElement element = driver.findElement(firstName);
        element.clear();
        element.sendKeys(fName);
        screenshot();
        return this;
    }

    @Step("Enter last name: {lName}")
    public SubscribePage fillLastName(String lName) {
        By lastName = By.xpath("//input[@id='lastName']");
        WebElement element = driver.findElement(lastName);
        element.clear();
        element.sendKeys(lName);
        screenshot();
        return this;
    }

    @Step("Enter email: {emailAddress}")
    public SubscribePage fillEmail(String emailAddress) {
        By email = By.xpath("//input[@id='registrationEmail']");
        WebElement element = driver.findElement(email);
        element.clear();
        element.sendKeys(emailAddress);
        screenshot();
        return this;
    }

    @Step("Enter phone number: {phoneNumber}")
    public SubscribePage fillPhoneNumber(String phoneNumber) {
        By phone = By.xpath("//input[@id='phoneNumber']");
        WebElement element = driver.findElement(phone);
        element.clear();
        element.click();
        Sleep(100);
        element.sendKeys(phoneNumber);
        screenshot();
        return this;
    }

    @Step("Enter password: {pwd}")
    public SubscribePage fillPassword(String pwd) {
        By password = By.xpath("//input[@id='password']");
        WebElement element = driver.findElement(password);
        element.clear();
        element.sendKeys(pwd);
        screenshot();
        Sleep(100);
        return this;
    }

    @Step("Select female gender")
    public SubscribePage selectFemaleGender() {
        By genderFemale = By.xpath("//label[@for='genderFemale']//div[1]");
        driver.findElement(genderFemale).click();
        screenshot();
        return this;
    }

    @Step("Select male gender")
    public SubscribePage selectMaleGender() {
        By genderMale = By.xpath("//div[contains(text(),'Erkek')]");
        driver.findElement(genderMale).click();
        screenshot();
        return this;
    }

    @Step("Accept agreement")
    public SubscribePage acceptAgreement() {
        By agreementCheckbox = By.xpath("//label[@for='acceptContract']");
        driver.findElement(agreementCheckbox).click();
        screenshot();
        return this;
    }

    @Step("Accept notifications")
    public SubscribePage acceptNotification() {
        By notificationCheckbox = By.xpath("//label[@for='sendPromotionalMailAndSms']");
        driver.findElement(notificationCheckbox).click();
        screenshot();
        return this;
    }

    @Step("Enter captcha code manually")
    public SubscribePage waitForManualCaptchaInput() {
        ScrollPage("250");
        screenshot();
        System.out.println("Please enter the CAPTCHA manually...");
        try {
            Thread.sleep(10000);  // 10 seconds wait time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Click the phone number verification button")
    public SubscribePage clickVerificationButton() {
        By verificationButton = By.xpath("//div[@id='submitButton']");
        element = driver.findElement(verificationButton);
        element.click();
        screenshot();
        return this;
    }

    @Step("Enter phone number verification code manually")
    public SubscribePage waitForManualVerificationCode() {
        System.out.println("Please enter the phone verification code manually...");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Click Login Card to go to login page")
    public SubscribePage ClickToLoginCard() {
        By toLoginCard = By.xpath("//a[@class='login-button card-header__tabs']");
        element = driver.findElement(toLoginCard);
        element.click();
        screenshot();
        return this;
    }

    @Step("Get verification button text")
    public SubscribePage getLoginText() {
        By verificationButton = By.xpath("//div[@id='submitButton']");
        element = driver.findElement(verificationButton);
        Sleep(300);
        verificationButtonText = element.getText();
        screenshot();
        return this;
    }

    @Step("Get verification button value")
    public String getLoginButtonText() {
        return verificationButtonText;
    }

    @Step("Accept First Agreement")
    public SubscribePage ClickFirstAcceptButton() {
        By acceptButton = By.xpath("//div[@class='btnPrimary agreement-button']");
        WebElement element = driver.findElement(acceptButton);
        element.click();
        screenshot();
        return this;
    }
}