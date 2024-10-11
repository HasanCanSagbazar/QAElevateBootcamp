package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SaveAddressPage extends BaseTest {
    WebElement element;

    @Step("Fill add address title")
    public SaveAddressPage fillAddressTitle(String title) {
        By addressTitle = By.xpath("//input[@id='title']");
        element = driver.findElement(addressTitle);
        element.clear();
        element.sendKeys(title);
        screenshot();
        return this;
    }

    @Step("Add user full name")
    public SaveAddressPage fillFullName(String fullName) {
        By fullNameInput = By.xpath("//input[@id='fullName']");
        element = driver.findElement(fullNameInput);
        element.clear();
        element.sendKeys(fullName);
        screenshot();
        return this;
    }

    @Step("Select country")
    public SaveAddressPage selectCountry(String country) {
        By countryInput = By.xpath("//select[@id='countryCode']");
        element = driver.findElement(countryInput);
        element.click();
        Sleep(3000);
        Select countrySelect = new Select(element);
        countrySelect.selectByValue(country);
        screenshot();
        return this;
    }

    @Step("Select city")
    public SaveAddressPage selectCity(String city) {
        By cityInput = By.xpath("//select[@id='cityId']");
        element = driver.findElement(cityInput);
        element.click();
        Sleep(3000);
        Select citySelect = new Select(element);
        citySelect.selectByValue(city);
        screenshot();
        return this;
    }

    @Step("Select district")
    public SaveAddressPage selectDistrict(String district) {
        By districtInput = By.xpath("//select[@id='districtId']");
        element = driver.findElement(districtInput);
        element.click();
        Sleep(3000);
        Select districtSelect = new Select(element);
        districtSelect.selectByValue(district);
        screenshot();
        return this;
    }

    @Step("Select neighborhood")
    public SaveAddressPage selectNeighborhood(String neighborhood) {
        By neighborhoodInput = By.xpath("//select[@id='neighbourhoodId']");
        element = driver.findElement(neighborhoodInput);
        element.click();
        Sleep(3000);
        Select neighborhoodSelect = new Select(element);
        neighborhoodSelect.selectByValue(neighborhood);
        screenshot();
        return this;
    }

    @Step("Add address detail")
    public SaveAddressPage fillAddressDetail(String addressDetail) {
        By addressDetailInput = By.xpath("//textarea[@id='address']");
        element = driver.findElement(addressDetailInput);
        element.clear();
        element.sendKeys(addressDetail);
        screenshot();
        Sleep(3000);
        return this;
    }

    @Step("Add postal code")
    public SaveAddressPage fillPostalCode(String postalCode) {
        By postalCodeInput = By.xpath("//input[@id='postalcode']");
        element = driver.findElement(postalCodeInput);
        element.clear();
        element.sendKeys(postalCode);
        screenshot();
        Sleep(100);
        return this;
    }

    @Step("Add phone number")
    public SaveAddressPage fillPhoneNumber(String phoneNumber) {
        By phoneInput = By.xpath("//input[@id='gsm']");
        WebElement element = driver.findElement(phoneInput);
        element.clear();
        element.click();
        Sleep(100);
        element.sendKeys(phoneNumber);
        screenshot();
        return this;
    }

    @Step("Click individual invoice type")
    public SaveAddressPage clickIndividualInvoiceType() {
        By individualInvoiceType = By.xpath("//input[@value='INDIVIDUAL']");
        element = driver.findElement(individualInvoiceType);
        element.click();
        screenshot();
        return this;
    }

    @Step("Click coorparate invoice type")
    public SaveAddressPage clickCoorparateInvoiceType() {
        By coorparateInvoiceType = By.xpath("//input[@value='CORPARATE']");
        element = driver.findElement(coorparateInvoiceType);
        element.click();
        screenshot();
        return this;
    }

    @Step("Add company name")
    public SaveAddressPage fillCompanyName(String companyName) {
        By companyNameInput = By.xpath("//input[@id='shipping_companyName']");
        element = driver.findElement(companyNameInput);
        element.clear();
        element.sendKeys(companyName);
        screenshot();
        return this;
    }

    @Step("Add tax number")
    public SaveAddressPage fillTaxNumber(String taxNumber) {
        By taxNumberInput = By.xpath("//input[@id='shipping_taxId']");
        element = driver.findElement(taxNumberInput);
        element.clear();
        element.sendKeys(taxNumber);
        screenshot();
        return this;
    }

    @Step("Add tax office")
    public SaveAddressPage fillTaxOffice(String taxOffice) {
        By taxOfficeInput = By.xpath("//input[@id='shipping_taxHouse_corporate']");
        element = driver.findElement(taxOfficeInput);
        element.clear();
        element.sendKeys(taxOffice);
        screenshot();
        return this;
    }

    @Step("Add identity number")
    public SaveAddressPage fillIdNumber(String idNumber) {
        By idNumberInput = By.xpath("//input[@id='shipping_tcId']");
        element = driver.findElement(idNumberInput);
        element.clear();
        element.sendKeys(idNumber);
        screenshot();
        return this;
    }

    @Step("Click save button")
    public SaveAddressPage clickSaveButton() {
        By saveButton = By.xpath("//div[@id='saveButton']");
        element = driver.findElement(saveButton);
        element.click();
        screenshot();
        return this;
    }

    @Step("Click cancel button")
    public SaveAddressPage clickCancelButton() {
        By cancelButton = By.xpath("//a[@class='btn btnGrey']");
        element = driver.findElement(cancelButton);
        element.click();
        screenshot();
        return this;
    }
}
