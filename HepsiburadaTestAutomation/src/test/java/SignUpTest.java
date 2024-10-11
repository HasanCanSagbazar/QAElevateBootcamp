import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.SubscribePage;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Subscribe Test Scenarios")
public class SignUpTest extends BaseTest {

    String signUpUrl = "https://www.n11.com/uye-ol";
    SubscribePage subscribePage = new SubscribePage();
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void goPage() {
        goTo(signUpUrl);
        subscribePage.ClickFirstAcceptButton()
                    .ScrollPage("250");
    }

    @Test(description = "control \"Giriş Yap\" button")
    public void GotoLoginPage(){
        subscribePage.ClickToLoginCard().Sleep(300);

        String currentUrl = driver.getCurrentUrl();
        AssertEquals("https://www.n11.com/giris-yap", currentUrl);

        String loginButtonText = loginPage.getLoginText().getLoginButtonText();
        AssertEquals(loginButtonText,"Giriş Yap");

        loginPage.ClickToSubscribeCard();
    }

    @Test(description = "Fail to subscribe with empty name")
    public void FailToSubscribeWithEmptyName() {
        subscribePage.fillLastName("Sağbazar")
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword(password)
                .selectMaleGender()
                .acceptAgreement()
                .acceptNotification()
                .waitForManualCaptchaInput()
                .clickVerificationButton()
                .Sleep(3000);

        String errorMessage = subscribePage.getErrorMessage("div[class='formfield error'] div[class='errorMessage']");
        AssertEquals(errorMessage, "Adını girebilir misin?");
    }

    @Test(description = "Fail to subscribe with empty email")
    public void FailToSubscribeWithEmptyEmail() {
        subscribePage.fillFirstName("Hasan Can")
                .fillLastName("Sağbazar")
                .fillPhoneNumber(phoneNumber)
                .fillPassword(password)
                .selectMaleGender()
                .acceptAgreement()
                .acceptNotification()
                .waitForManualCaptchaInput()
                .clickVerificationButton();

        String errorMessage = subscribePage.getErrorMessage("div[class='errorMessage registrationEmailFieldErrorMessage']");
        AssertEquals(errorMessage, "E-posta adresini girebilir misin?");

    }

    @Test(description = "Fail to subscribe with empty phone number")
    public void FailToSubscribeWithEmptyPhoneNumber() {
        subscribePage.fillFirstName("Hasan Can")
                .fillLastName("Sağbazar")
                .fillEmail(email)
                .fillPassword(password)
                .selectMaleGender()
                .acceptAgreement()
                .acceptNotification()
                .waitForManualCaptchaInput()
                .clickVerificationButton()
                .Sleep(3000);

        String errorMessage = subscribePage.getErrorMessage("div[class='form-inputs-split'] div[class='errorMessage']");
        AssertEquals("Cep telefonu numarası girebilir misin?", errorMessage);
    }

    @Test(description = "Fail to subscribe without aggrement")
    public void FailToSubscribeWithoutAgreement() {
        subscribePage.fillFirstName("Hasan Can")
                .fillLastName("Sağbazar")
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword(password)
                .selectMaleGender()
                .acceptNotification()
                .waitForManualCaptchaInput()
                .clickVerificationButton()
                .Sleep(3000);

        String currentUrl = driver.getCurrentUrl();
        AssertEquals(signUpUrl, currentUrl);

    }

    @Test(description = "Fail to subscribe without wrong captcha")
    public void FailToSubscribeWithWrongCaptcha() {
        subscribePage.fillFirstName("Hasan Can")
                .fillLastName("Sağbazar")
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword(password)
                .selectMaleGender()
                .acceptNotification()
                .waitForManualCaptchaInput()
                .clickVerificationButton()
                .waitForManualVerificationCode()
                .Sleep(3000);

        String currentUrl = driver.getCurrentUrl();
        AssertEquals(signUpUrl, currentUrl);

    }

    //@Test(description = "fail to verify captcha")

    @Test(description = "Fail to subscribe with wrong email structure")
    public void FailToSubscribeWithWrongMailStructure() {
        subscribePage.fillFirstName("Hasan Can")
                .fillLastName("Sağbazar")
                .fillEmail("testmail.com")
                .fillPhoneNumber(phoneNumber)
                .fillPassword(password)
                .selectMaleGender()
                .acceptNotification()
                .waitForManualCaptchaInput()
                .clickVerificationButton()
                .Sleep(3000);

        String errorMessage = subscribePage.getErrorMessage("div[class='errorMessage registrationEmailFieldErrorMessage'] div[class='errorText']");
        AssertEquals("Lütfen geçerli bir e-posta adresi girin.", errorMessage);
    }

    @Test(description = "Minimum character controller for password")
    public void FailToSubscribeWithInsufficientPasswordCharachter() {
        subscribePage.fillFirstName("Hasan Can")
                .fillLastName("Sağbazar")
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword(insufficientPassword)
                .selectMaleGender()
                .acceptNotification()
                .waitForManualCaptchaInput()
                .clickVerificationButton()
                .Sleep(3000);


        String errorMessage = subscribePage.getErrorMessage("div.errorMessage[data-errormessagefor='password'] .errorText");
        AssertEquals("Girilen değer en az 6 karakter olmalıdır.", errorMessage);
    }

    @Test(description = "Maximum character controller for password")
    public void FailToSubscribeWithLongPasswordCharachter() {
        subscribePage.fillFirstName("Hasan Can")
                .fillLastName("Sağbazar")
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword(longPassword)
                .selectMaleGender()
                .acceptNotification()
                .waitForManualCaptchaInput()
                .clickVerificationButton()
                .Sleep(3000);

        String errorMessage = subscribePage.getErrorMessage("div.errorMessage[data-errormessagefor='password'] .errorText");
        AssertEquals("Girilen değer en fazla 15 karakter olmalıdır.", errorMessage);
    }

    @Test(description = "Fail to subscribe with missing password character(number)")
    public void FailtToSubscribeWithMissingPasswordCharachter() {
        subscribePage.fillFirstName("Hasan Can")
                .fillLastName("Sağbazar")
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword("abcdef")
                .selectMaleGender()
                .acceptNotification()
                .waitForManualCaptchaInput()
                .clickVerificationButton()
                .Sleep(3000);


        String errorMessage = subscribePage.getErrorMessage("div.errorMessage[data-errormessagefor='password'] .errorText");
        AssertEquals("Şifreniz en az 1 rakam ve 1 harf içermelidir.", errorMessage);
    }

    @Test(description = "Fail to subscribe with missing password character(text)")
    public void FailtToSubscribeWithMissingPasswordCharachter_2() {
        subscribePage.fillFirstName("Hasan Can")
                .fillLastName("Sağbazar")
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword("1324568")
                .selectMaleGender()
                .acceptNotification()
                .waitForManualCaptchaInput()
                .clickVerificationButton()
                .Sleep(3000);


        String errorMessage = subscribePage.getErrorMessage("div.errorMessage[data-errormessagefor='password'] .errorText");
        AssertEquals("Şifreniz en az 1 rakam ve 1 harf içermelidir.", errorMessage);
    }


    @Test(description = "Successfully subscribe")
    public void SuccessfullySubscribe() {
        subscribePage.fillFirstName("Hasan Can")
                .fillLastName("Sağbazar")
                .fillEmail(email)
                .fillPhoneNumber(phoneNumber)
                .fillPassword(password)
                .selectMaleGender()
                .acceptAgreement()
                .acceptNotification()
                .waitForManualCaptchaInput()
                .clickVerificationButton()
                .waitForManualVerificationCode()
                .Sleep(3000);

        String accountValue = mainPage.getAccountValue();
        AssertEquals("HS", accountValue);

    }

}
