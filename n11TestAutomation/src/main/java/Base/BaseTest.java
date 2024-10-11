package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseLibrary{
    public static WebDriver driver;

    @BeforeMethod
    public void OpenBrowser(){
        driver = new ChromeDriver();

    }

    @AfterMethod
    public void afterTest() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    public void goTo(String url){
        driver.get(url);
        driver.manage().window().maximize();
        Sleep(3000);
    }
}
