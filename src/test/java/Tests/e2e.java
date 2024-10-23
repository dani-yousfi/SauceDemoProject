package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class e2e extends BaseTest {

    @Test
    public void placeOrderSuccessfully () {
        login();
        inventoryPage.addProductToCartByName("Sauce Labs Backpack");
        inventoryPage.openCart();
        Assert.assertTrue(cartPage.isProductInCartByName("Sauce Labs Backpack"));
        cartPage.clickOnCheckOutButton();
        checkoutPageOne.fillCheckoutInformation("Dani", "Danini", "12345");
        checkoutPageOne.continueToNextPage();
        Assert.assertTrue(checkoutPageTwo.isCheckoutSummaryDisplayed());
        checkoutPageTwo.finishCheckout();
        Assert.assertTrue(checkoutCompletePage.isOrderComplete());
        checkoutCompletePage.goBackToHomepage();
        Assert.assertTrue(inventoryPage.isInventoryPageDisplayed());
        inventoryPage.clickOnHamburgerMenu();
        inventoryPage.clickOnLogoutButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
        Assert.assertTrue(homepagePage.loginButton.isDisplayed());
    }













}
