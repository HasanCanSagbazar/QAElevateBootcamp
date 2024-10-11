import Base.BaseTest;
import Pages.ProductsPage;
import Pages.Search;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    Search search = new Search();
    ProductsPage productsPage = new ProductsPage();
    String homeUrl = "https://www.n11.com/";

    @BeforeMethod
    public void goPage() {
        goTo(homeUrl);
    }

    @Test(description = "Successfully search test")
    public void searchTest() {
        search.clickSearchBar()
                .typeToSearchBar("laptop")
                .clickSearchBarButton();

        String productTitle = productsPage.getProductTitle()
                                        .getProductName();

        AssertEquals("laptop", productTitle);
    }

    @Test(description = "Unsuccessfully search test with unknown charachters")
    public void unsuccessfulSearchTest() {
        search.clickSearchBar()
                .typeToSearchBar("%&/%+/(")
                .clickSearchBarButton();

        String noResultMessage = productsPage.notFoundProduct().getNotFoundProduct();

        AssertEquals("Yazdığın kelimeyi kontrol ederek tekrar arayabilirsin.", noResultMessage);
    }

    @Test(description = "Show not found product for searching with different languages")
    public void differentLanguageSearchTest() {
        search.clickSearchBar()
                .typeToSearchBar("حاسوب")
                .clickSearchBarButton();

        String noResultMessage = productsPage.notFoundProduct().getNotFoundProduct();

        AssertEquals("Yazdığın kelimeyi kontrol ederek tekrar arayabilirsin.", noResultMessage);
    }

    @Test(description = "Control whether the website gives connection error for searching with malevolent data and It is expected to give an error")
    public void malevolentDataSearchTest() {
        search.clickSearchBar()
                .typeToSearchBar("<script>alert('XSS')</script>")
                .clickSearchBarButton();

        String noResultMessage = productsPage.notFoundProduct().getNotFoundProduct();

        //The website doest not give connection error for malevolent data, it controls them as unknown product so we assert it with a different message
        Assert.assertNotEquals(noResultMessage, "Yazdığın kelimeyi kontrol ederek tekrar arayabilirsin.");
    }


    @Test(description = "empty search")
    public void emptySearchTest() {
        search.clickSearchBar()
                .typeToSearchBar("")
                .clickSearchBarButton();

        String getCurrentUrl = driver.getCurrentUrl();

        AssertEquals(homeUrl, getCurrentUrl);
    }
}
