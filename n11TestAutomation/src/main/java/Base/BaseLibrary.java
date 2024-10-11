package Base;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.testng.Assert;

import static Base.BaseTest.driver;

public class BaseLibrary extends TestData{
    @Step("wait {time} miliseconds")
    public void Sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Compare values")
    public void AssertEquals(String expectedValue, String actualValue){
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Get error message")
    public String getErrorMessage(String selector){
        WebElement element = driver.findElement(By.cssSelector(selector));
        String value = element.getText();
        screenshot();
        return value;
    }

    @Step("Scroll page")
    public void ScrollPage(String number){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + number + ")", "");
    }
}
