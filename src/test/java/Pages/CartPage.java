package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseTest {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.btn_secondary.btn_small.cart_button")
    public List<WebElement> allProductsInCart;

    @FindBy (id = "checkout")
    public WebElement checkOutButton;

    @FindBy (id = "continue-shopping")
    public WebElement continueShoppingButton;

    //---------------------------------------------------------

    public void removeAllProductsFromCart () throws InterruptedException {
        for (int i = allProductsInCart.size()-1; i>=0; i--){
            allProductsInCart.get(i).click();
            Thread.sleep(200);
        }
    }

    public void clickOnCheckOutButton () {
        checkOutButton.click();
    }

    public void clickOnContinueShoppingButton () {
        continueShoppingButton.click();
    }

    public boolean isProductInCartByName(String productName) {
        try {
            WebElement productInCart = driver.findElement(By.partialLinkText(productName));
            return productInCart.isDisplayed();
        } catch (Exception e) {
        }
        return false;
    }










}
