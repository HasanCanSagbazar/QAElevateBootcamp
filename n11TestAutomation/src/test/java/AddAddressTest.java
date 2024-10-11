import Base.BaseTest;
import Pages.LoginPage;
import Pages.MyAddressesPage;
import Pages.SaveAddressPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddAddressTest extends BaseTest {
    String loginUrl = "https://www.n11.com/giris-yap";
    String addAddressUrl = "https://www.n11.com/hesabim/teslimat-adresi/";
    LoginPage loginPage = new LoginPage();
    SaveAddressPage saveAddressPage = new SaveAddressPage();
    MyAddressesPage myAddressesPage = new MyAddressesPage();

    int beforeAddAddress = 0;

    @BeforeMethod(description = "Login before test")
    public void LoginSuccessfulWithMail() {
        goTo(loginUrl);

        loginPage.fillMail(email)
                .fillPassword(password)
                .clickLogin()
                .Sleep(300);

        goTo(addAddressUrl);
        beforeAddAddress = myAddressesPage.countAddresses();
        Sleep(3000);
        myAddressesPage.clickAddNewAddressButton();
    }


    @Test(description = "Unsuccessfully save new address without full name")
    public void UnsuccessfullySaveNewAddressWithoutFullName() {
        saveAddressPage.fillAddressTitle("Ev")
                .selectCountry("TR")
                .selectCity("2506")
                .selectDistrict("22975")
                .selectNeighborhood("4666")
                .fillAddressDetail("Battalgazi Mahallesi 1031.sokak no 1/3 Altındağ Ankara")
                .fillPhoneNumber(phoneNumber)
                .clickIndividualInvoiceType()
                .fillIdNumber("95653020246")
                .clickSaveButton()
                .Sleep(300);

        String errorMessage = saveAddressPage.getErrorMessage("div[data-errormessagefor='fullName'] div[class='errorText']");
        AssertEquals("Lütfen ad soyadı girin.", errorMessage);

    }

    @Test(description = "Unsuccessfully save new address without address title")
    public void UnsuccessfullySaveNewAddressWithoutAddressTitle() {
        saveAddressPage.fillFullName("Hasan Can Sağbazar")
                .selectCountry("TR")
                .selectCity("2506")
                .selectDistrict("22975")
                .selectNeighborhood("4666")
                .fillAddressDetail("Battalgazi Mahallesi 1031.sokak no 1/3 Altındağ Ankara")
                .fillPhoneNumber(phoneNumber)
                .clickIndividualInvoiceType()
                .fillIdNumber("95653020246")
                .clickSaveButton()
                .Sleep(300);

        String errorMessage = saveAddressPage.getErrorMessage("div[data-errormessagefor='title'] div[class='errorText']");
        AssertEquals("Lütfen adres başlığı girin.", errorMessage);

    }


    @Test(description = "Unsuccessfully save new address without location selections")
    public void UnsuccessfullySaveNewAddressWithoutLocationSelections() {
        saveAddressPage.fillAddressTitle("Ev")
                .fillFullName("Hasan Can Sağbazar")
                .fillAddressDetail("Battalgazi Mahallesi 1031.sokak no 1/3 Altındağ Ankara")
                .fillPhoneNumber(phoneNumber)
                .clickIndividualInvoiceType()
                .fillIdNumber("95653020246")
                .clickSaveButton()
                .Sleep(300);

        String errorMessage = saveAddressPage.getErrorMessage("div[data-errormessagefor='cityId'] div[class='errorText']");
        AssertEquals("Lütfen şehir seçin.", errorMessage);

        errorMessage = saveAddressPage.getErrorMessage("div[data-errormessagefor='districtId'] div[class='errorText']");
        AssertEquals("Lütfen ilçe seçin.", errorMessage);

        errorMessage = saveAddressPage.getErrorMessage("div[data-errormessagefor='neighbourhoodId'] div[class='errorText']");
        AssertEquals("Lütfen mahalle seçiniz.", errorMessage);

    }

    @Test(description = "Unsuccessfully save new address without address detail")
    public void UnsuccessfullySaveNewAddressWithoutAddressDetail() {
        saveAddressPage.fillAddressTitle("Ev")
                .fillFullName("Hasan Can Sağbazar")
                .selectCountry("TR")
                .selectCity("2506")
                .selectDistrict("22975")
                .selectNeighborhood("4666")
                .fillPhoneNumber(phoneNumber)
                .clickIndividualInvoiceType()
                .fillIdNumber("95653020246")
                .clickSaveButton()
                .Sleep(300);

        String errorMessage = saveAddressPage.getErrorMessage("div[data-errormessagefor='address'] div[class='errorText']");
        AssertEquals("Lütfen adres girin.", errorMessage);

    }


    @Test(description = "Unsuccessfully save new address without address detail less than 10 characters")
    public void UnsuccessfullySaveNewAddressWithoutAddressDetailLessThan10Characters() {
        saveAddressPage.fillAddressTitle("Ev")
                .fillFullName("Hasan Can Sağbazar")
                .selectCountry("TR")
                .selectCity("2506")
                .selectDistrict("22975")
                .selectNeighborhood("4666")
                .fillAddressDetail("Battal")
                .fillPhoneNumber(phoneNumber)
                .clickIndividualInvoiceType()
                .fillIdNumber("95653020246")
                .clickSaveButton()
                .Sleep(300);

        String errorMessage = saveAddressPage.getErrorMessage("div[data-errormessagefor='address'] div[class='errorText']");
        AssertEquals("Girilen değer en az 10 karakter olmalıdır.", errorMessage);

    }

    @Test(description = "Unsuccessfully save new address without phone number")
    public void UnsuccessfullySaveNewAddressWithoutPhoneNumber() {
        saveAddressPage.fillAddressTitle("Ev")
                .fillFullName("Hasan Can Sağbazar")
                .selectCountry("TR")
                .selectCity("2506")
                .selectDistrict("22975")
                .selectNeighborhood("4666")
                .fillAddressDetail("Battalgazi Mahallesi 1031.sokak no 1/3 Altındağ Ankara")
                .fillIdNumber("95653020246")
                .clickSaveButton()
                .Sleep(300);

        String errorMessage = saveAddressPage.getErrorMessage("div[data-errormessagefor='gsm'] div[class='errorText']");
        AssertEquals("Lütfen cep telefonu numarası girin.", errorMessage);

    }


    @Test(description = "Unsuccessfully save new address without identity number")
    public void UnsuccessfullySaveNewAddressWithoutIdentityNumber() {
        saveAddressPage.fillAddressTitle("Ev")
                .fillFullName("Hasan Can Sağbazar")
                .selectCountry("TR")
                .selectCity("2506")
                .selectDistrict("22975")
                .selectNeighborhood("4666")
                .fillAddressDetail("Battalgazi Mahallesi 1031.sokak no 1/3 Altındağ Ankara")
                .fillPhoneNumber(phoneNumber)
                .clickIndividualInvoiceType()
                .clickSaveButton()
                .Sleep(300);

        String errorMessage = saveAddressPage.getErrorMessage("div[data-errormessagefor='shipping_tcId'] div[class='errorText']");
        AssertEquals("Bu alanın doldurulması zorunludur.", errorMessage);

    }


    @Test(description = "Unsuccessfully save new address with wrong identity number")
    public void UnsuccessfullySaveNewAddressWithWrongIdentityNumber() {
        saveAddressPage.fillAddressTitle("Ev")
                .fillFullName("Hasan Can Sağbazar")
                .selectCountry("TR")
                .selectCity("2506")
                .selectDistrict("22975")
                .selectNeighborhood("4666")
                .fillAddressDetail("Battalgazi Mahallesi 1031.sokak no 1/3 Altındağ Ankara")
                .fillPhoneNumber(phoneNumber)
                .clickIndividualInvoiceType()
                .fillIdNumber("29266402791")
                .clickSaveButton()
                .Sleep(300);

        String errorMessage = saveAddressPage.getErrorMessage("div[data-errormessagefor='shipping_tcId'] div[class='errorText']");
        AssertEquals("Lütfen geçerli bir TC Kimlik Numarası girin.", errorMessage);

    }


    @Test(description = "Succesfully save new address with coorparate invoice type")
    public void SuccesfullySaveNewAddressWithCoorparateInvoiceType() {
        saveAddressPage.fillAddressTitle("Ev")
                .fillFullName("Hasan Can Sağbazar")
                .selectCountry("TR")
                .selectCity("2506")
                .selectDistrict("22975")
                .selectNeighborhood("4666")
                .fillAddressDetail("Battalgazi Mahallesi 1031.sokak no 1/3 Altındağ Ankara")
                .fillPhoneNumber(phoneNumber)
                .clickCoorparateInvoiceType()
                .fillCompanyName("Test Company")
                .fillTaxNumber("1234567890")
                .fillTaxOffice("Test Tax Office")
                .clickSaveButton()
                .Sleep(300);

        int afterAddAddress = myAddressesPage.countAddresses();
        assert afterAddAddress == beforeAddAddress + 1 : "Address not added successfully";

    }

    @Test(description = "Unsuccessfully save new address without company name")
    public void UnsuccessfullySaveNewAddressWithoutCompanyName() {
        saveAddressPage.fillAddressTitle("Ev")
                .fillFullName("Hasan Can Sağbazar")
                .selectCountry("TR")
                .selectCity("2506")
                .selectDistrict("22975")
                .selectNeighborhood("4666")
                .fillAddressDetail("Battalgazi Mahallesi 1031.sokak no 1/3 Altındağ Ankara")
                .fillPhoneNumber(phoneNumber)
                .clickCoorparateInvoiceType()
                .fillTaxNumber("4457902784")
                .fillTaxOffice("Test Tax Office")
                .clickSaveButton()
                .Sleep(300);

        String errorMessage = saveAddressPage.getErrorMessage("div[data-errormessagefor='shipping_companyName'] div[class='errorText']");
        AssertEquals("Bu alanın doldurulması zorunludur.", errorMessage);

    }


    @Test(description = "Unsuccessfully save new address without tax number")
    public void UnsuccessfullySaveNewAddressWithoutTaxNumber() {
        saveAddressPage.fillAddressTitle("Ev")
                .fillFullName("Hasan Can Sağbazar")
                .selectCountry("TR")
                .selectCity("2506")
                .selectDistrict("22975")
                .selectNeighborhood("4666")
                .fillAddressDetail("Battalgazi Mahallesi 1031.sokak no 1/3 Altındağ Ankara")
                .fillPhoneNumber(phoneNumber)
                .clickCoorparateInvoiceType()
                .fillCompanyName("Test Company")
                .fillTaxOffice("Test Tax Office")
                .clickSaveButton()
                .Sleep(300);

        String errorMessage = saveAddressPage.getErrorMessage("div[data-errormessagefor='shipping_taxId'] div[class='errorText']");
        AssertEquals("Bu alanın doldurulması zorunludur.", errorMessage);

    }


    @Test(description = "Unsuccessfully save new address without tax office")
    public void UnsuccessfullySaveNewAddressWithoutTaxOffice() {
        saveAddressPage.fillAddressTitle("Ev")
                .fillFullName("Hasan Can Sağbazar")
                .selectCountry("TR")
                .selectCity("2506")
                .selectDistrict("22975")
                .selectNeighborhood("4666")
                .fillAddressDetail("Battalgazi Mahallesi 1031.sokak no 1/3 Altındağ Ankara")
                .fillPhoneNumber(phoneNumber)
                .clickCoorparateInvoiceType()
                .fillCompanyName("Test Company")
                .fillTaxNumber("4457902784")
                .clickSaveButton()
                .Sleep(300);

        String errorMessage = saveAddressPage.getErrorMessage("div[data-errormessagefor='shipping_taxHouse_corporate'] div[class='errorText']");
        AssertEquals("Bu alanın doldurulması zorunludur.", errorMessage);

    }


    @Test(description = "Unsuccessfully save new address with wrong tax number")
    public void UnsuccessfullySaveNewAddressWithWrongTaxNumber() {
        saveAddressPage.fillAddressTitle("Ev")
                .fillFullName("Hasan Can Sağbazar")
                .selectCountry("TR")
                .selectCity("2506")
                .selectDistrict("22975")
                .selectNeighborhood("4666")
                .fillAddressDetail("Battalgazi Mahallesi 1031.sokak no 1/3 Altındağ Ankara")
                .fillPhoneNumber(phoneNumber)
                .clickCoorparateInvoiceType()
                .fillCompanyName("Test Company")
                .fillTaxNumber("1234567898")
                .fillTaxOffice("Test Tax Office")
                .clickSaveButton()
                .Sleep(300);

        String errorMessage = saveAddressPage.getErrorMessage("div[data-errormessagefor='shipping_taxId'] div[class='errorText']");
        AssertEquals("Lütfen geçerli bir Vergi Kimlik Numarası girin.", errorMessage);

    }

    @Test(description = "Unsuccessfully save new address with wrong tax number less than 10 characters")
    public void UnsuccessfullySaveNewAddressWithWrongTaxNumberLessThan10Characters() {
        saveAddressPage.fillAddressTitle("Ev")
                .fillFullName("Hasan Can Sağbazar")
                .selectCountry("TR")
                .selectCity("2506")
                .selectDistrict("22975")
                .selectNeighborhood("4666")
                .fillAddressDetail("Battalgazi Mahallesi 1031.sokak no 1/3 Altındağ Ankara")
                .fillPhoneNumber(phoneNumber)
                .clickCoorparateInvoiceType()
                .fillCompanyName("Test Company")
                .fillTaxNumber("123456789")
                .fillTaxOffice("Test Tax Office")
                .Sleep(300);

        String errorMessage = saveAddressPage.getErrorMessage("div[data-errormessagefor='shipping_taxId'] div[class='errorText']");
        AssertEquals("Girilen değer en az 10 karakter olmalıdır.", errorMessage);

    }


    @Test(description = "Successfully save new address")
    public void SuccessfullySaveNewAddress() {
        saveAddressPage.fillAddressTitle("Ev")
                .fillFullName("Hasan Can Sağbazar")
                .selectCountry("TR")
                .selectCity("2506")
                .selectDistrict("22975")
                .selectNeighborhood("4666")
                .fillAddressDetail("Battalgazi Mahallesi 1031.sokak no 1/3 Altındağ Ankara")
                .fillPhoneNumber(phoneNumber)
                .clickIndividualInvoiceType()
                .fillIdNumber("95653020246")
                .clickSaveButton()
                .Sleep(300);

        int afterAddAddress = myAddressesPage.countAddresses();
        assert afterAddAddress == beforeAddAddress + 1 : "Address not added successfully";

    }


}
