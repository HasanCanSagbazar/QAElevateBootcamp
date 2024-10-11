import Base.BaseTest;
import Pages.BasketPage;
import Pages.ProductPage;
import Pages.ProductsPage;
import Pages.Search;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBasketTest extends BaseTest {
    Search search = new Search();
    ProductsPage productsPage = new ProductsPage();
    ProductPage productPage = new ProductPage();
    BasketPage basketPage = new BasketPage();
    String homeUrl = "https://www.n11.com/";

    boolean isBasketEmpty = true;
    int beforeBasketCount = 0;

    @BeforeMethod
    public void beforeMethod() {
        isBasketEmpty = basketPage.isBasketEmpty().getBasketEmptyStatus();

        beforeBasketCount = isBasketEmpty ? 0 : basketPage.getProductSize().getProductSizeValue();

        goTo(homeUrl);
        search.clickSearchBar()
                .typeToSearchBar("laptop")
                .clickSearchBarButton();
    }

    @Test(description = "Successfully add product to basket")
    public void addBasketTest() {
        productsPage.clickRandomItem();
        productPage.addProductToBasket()
                .goToBasketPage()
                .Sleep(3000);

        basketPage.clickClarificationText().Sleep(3000);

        ScrollPage("300");

        int afterBasketCount = basketPage.getProductSize().getProductSizeValue();
        assert afterBasketCount == beforeBasketCount + 1 : "Product not added successfully";

    }

    @Test(description = "Successfully delete product from basket")
    public void deleteBasketTest() {
        productsPage.clickRandomItem();
        productPage.addProductToBasket()
                .goToBasketPage()
                .Sleep(3000);

        basketPage.clickClarificationText().Sleep(3000);

        ScrollPage("300");

        basketPage.clickGarbageIcon()
                .clickDeleteButton()
                .Sleep(3000);;

        int afterBasketCount = basketPage.getProductSize().getProductSizeValue();
        assert afterBasketCount == beforeBasketCount : "Product not deleted successfully";

        ScrollPage("-300");

        String basketEmptyText = driver.findElement(By.xpath("//h2[@class='title']")).getText();

        AssertEquals("Sepetin Boş Görünüyor", basketEmptyText);
    }
}