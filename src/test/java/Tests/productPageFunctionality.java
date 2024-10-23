package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.HomepagePage;
import Pages.InventoryPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class productPageFunctionality extends BaseTest {


    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homepagePage = new HomepagePage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();

    }

    @Test
    public void AllProductsAreDisplayed() {
        Assert.assertEquals(inventoryPage.areAllProductsDisplayed(), 6);
    }

    @Test
    public void cartIsEmptyWhenUserLogin() {
        Assert.assertFalse(inventoryPage.isShoppingCartBadgeDisplayed());
    }

    @Test
    public void addProductByName() {
        inventoryPage.addProductToCartByName("Sauce Labs Backpack");
        inventoryPage.openCart();
        Assert.assertTrue(cartPage.isProductInCartByName("Sauce Labs Backpack"));
    }

    @Test
    public void removeProductByName() {
        inventoryPage.addProductToCartByName("Sauce Labs Backpack");
        inventoryPage.openCart();
        inventoryPage.removeProductFromCartByName("Sauce Labs Backpack");
        Assert.assertFalse(cartPage.isProductInCartByName("Sauce Labs Backpack"));
    }

    @Test
    public void addAllProductsSuccessfully() throws InterruptedException {
        inventoryPage.addAllProducts();
        Assert.assertEquals(inventoryPage.getCartItemCount(), "6");
    }

    @Test
    public void removeAllProductsWhenYouAddAllProductsBefore() throws InterruptedException {
        inventoryPage.addAllProducts();
        Assert.assertEquals(inventoryPage.getCartItemCount(), "6");
        inventoryPage.openCart();
        cartPage.removeAllProductsFromCart();
        Assert.assertFalse(inventoryPage.isShoppingCartBadgeDisplayed());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
