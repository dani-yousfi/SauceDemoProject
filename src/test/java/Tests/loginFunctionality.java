package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginFunctionality extends BaseTest {


    @Test
    public void successfulLoginWithValidUsernameAndValidPassword() throws InterruptedException {
        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            driver.navigate().to("https://www.saucedemo.com/");
            String validUsername = excelReader.getStringData("Sheet1", i, 0);
            String validPassword = excelReader.getStringData("Sheet1", 1, 1);
            homepagePage.inputUsername(validUsername);
            homepagePage.inputPassword(validPassword);
            homepagePage.clickOnLoginButton();
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
            inventoryPage.clickOnHamburgerMenu();
            Thread.sleep(500);
            Assert.assertTrue(inventoryPage.logoutButton.isDisplayed());


        }


    }

    @Test
    public void unsuccessfulLoginWithValidUsernameAndInvalidPassword() {
        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            driver.navigate().to("https://www.saucedemo.com/");
            String validUsername = excelReader.getStringData("Sheet1", i, 0);
            String invalidPassword = excelReader.getStringData("Sheet1", 1, 1);
            homepagePage.inputUsername(validUsername);
            homepagePage.inputPassword(invalidPassword);
            homepagePage.clickOnLoginButton();
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
            Assert.assertTrue(homepagePage.loginButton.isDisplayed());


        }
    }

    @Test
    public void unsuccessfulLoginWithInvalidUsernameAndValidPassword() {
        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            driver.navigate().to("https://www.saucedemo.com/");
            String invalidUsername = excelReader.getStringData("Sheet1", i, 2);
            String validPassword = excelReader.getStringData("Sheet1", 1, 1);
            homepagePage.inputUsername(invalidUsername);
            homepagePage.inputPassword(validPassword);
            homepagePage.clickOnLoginButton();
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
            Assert.assertTrue(homepagePage.loginButton.isDisplayed());


        }
    }

    @Test
    public void unsuccessfulLoginWithInvalidUsernameAndInvalidPassword() {
        for (int i = 1; i <= excelReader.getLastRow("Sheet1"); i++) {
            driver.navigate().to("https://www.saucedemo.com/");
            String invalidUsername = excelReader.getStringData("Sheet1", i, 2);
            String invalidPassword = excelReader.getStringData("Sheet1", i, 3);
            homepagePage.inputUsername(invalidUsername);
            homepagePage.inputPassword(invalidPassword);
            homepagePage.clickOnLoginButton();
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
            Assert.assertTrue(homepagePage.loginButton.isDisplayed());


        }
    }

    @Test
    public void unsuccessfulLoginWithEmptyUsernameAndEmptyPassword() {

        driver.navigate().to("https://www.saucedemo.com/");
        homepagePage.inputUsername("");
        homepagePage.inputPassword("");
        homepagePage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(homepagePage.loginButton.isDisplayed());


    }


}