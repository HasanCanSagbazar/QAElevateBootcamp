import Base.BaseTest;
import Pages.LoginPage;
import Pages.SubscribePage;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Login Test Scenarios")
public class LoginTest extends BaseTest {
    String loginUrl = "https://www.n11.com/giris-yap";
    LoginPage loginPage = new LoginPage();
    SubscribePage subscribePage = new SubscribePage();


    @BeforeMethod
    public void goPage() {
        loginPage.goTo(loginUrl);
    }

    @Test(description = "control \"Üye Ol\" card")
    public void GotoSubscribePage() {
        loginPage.ClickToSubscribeCard().Sleep(300);

        String currentUrl = driver.getCurrentUrl();
        AssertEquals("https://www.n11.com/uye-ol", currentUrl);


        String loginButtonText = subscribePage.
                ClickFirstAcceptButton().
                getLoginText().
                getLoginButtonText();
        AssertEquals(loginButtonText, "Numaranı Doğrula");

        subscribePage.ClickToLoginCard();
    }

    @Test(description = "Successfully login with email")
    public void LoginSuccessfulWithMail() {

        loginPage.fillMail(email)
                .fillPassword(password)
                .clickLogin()
                .Sleep(300);
    }

    @Test(description = "Unsuccessfully login with wrong email structure")
    public void LoginUnsuccessfullWithWronEmailStructure() {

        loginPage.fillMail(wrongMail)
                .fillPassword(password)
                .clickLogin()
                .Sleep(300);

        String errorMsg = loginPage.getErrorMessage("div[data-errormessagefor='email'] div[class='errorText']");
        AssertEquals("Geçerli bir e-posta adresi girmelisin.", errorMsg);

        String currentUrl = driver.getCurrentUrl();
        AssertEquals(loginUrl, currentUrl);
    }

    @Test(description = "Unsuccessfully login with unregister mail")
    public void LoginUnsuccessfullWithUnregisterMail() {

        loginPage.fillMail(unregisterMail)
                .fillPassword(password)
                .clickLogin()
                .Sleep(300);
        String errorMsg = loginPage.getErrorMessage("div[class='card-body'] span:nth-child(2)");
        AssertEquals("E-posta adresi veya şifre hatalı, kontrol edebilir misin?", errorMsg);
    }

    @Test(description = "Unsuccessfully login with wrong password")
    public void LoginUnsuccessfullWithWrongPassword() {

        loginPage.fillMail(email)
                .fillPassword(wrongPassword)
                .clickLogin()
                .Sleep(300);

        String errorMsg = loginPage.getErrorMessage("div[class='card-body'] span:nth-child(2)");
        AssertEquals("E-posta adresi veya şifre hatalı, kontrol edebilir misin?", errorMsg);
    }

    @Test(description = "Maximum character (15 character) control for email")
    public void MaxCharacterControlForPassword() {

        loginPage.fillMail(email)
                .fillPassword(longPassword)
                .clickLogin()
                .Sleep(300);

        String errorMsg = loginPage.getErrorMessage("div[data-errormessagefor='password'] div[class='errorText']");
        AssertEquals("Girilen değer en fazla 15 karakter olmalıdır.", errorMsg);

    }


    @Test(description = "Empty password field")
    public void UnsuccessfullyLoginWithEmptyPasswordField() {

        loginPage.fillMail(email)
                .clickLogin()
                .Sleep(300);

        String errorMsg = loginPage.getErrorMessage("div[data-errormessagefor='password'] div[class='errorText']");
        AssertEquals("Şifreni girebilir misin?", errorMsg);

    }

    @Test(description = "Empty email field")
    public void UnsuccessfullyLoginWithEmptyMailField() {

        loginPage.fillPassword(password)
                .clickLogin()
                .Sleep(300);

        String errorMsg = loginPage.getErrorMessage("div[data-errormessagefor='email'] div[class='errorText']");
        AssertEquals("Geçerli bir e-posta adresi girmelisin.", errorMsg);
    }

    @Test(description = "Empty email field")
    public void UnsuccessfullyLoginWithEmptyFields() {

        loginPage.clickLogin()
                .Sleep(300);

        String errorMsg = loginPage.getErrorMessage("div[data-errormessagefor='email'] div[class='errorText']");
        AssertEquals("Geçerli bir e-posta adresi girmelisin.", errorMsg);

        errorMsg = loginPage.getErrorMessage("div[data-errormessagefor='password'] div[class='errorText']");
        AssertEquals("Şifreni girebilir misin?", errorMsg);
    }
}
