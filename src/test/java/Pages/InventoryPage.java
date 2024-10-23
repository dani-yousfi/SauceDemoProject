package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage extends BaseTest {


    public InventoryPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(className = "shopping_cart_link")
    public WebElement cartButton;

    @FindBy(className = "shopping_cart_badge")
    public WebElement cartBadge;

    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
    public List<WebElement> listOfAllProductsByAddToCartButton;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> listOfAllProducts;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement hamburgerMenu;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutButton;

    @FindBy(className = "inventory_list")
    public WebElement inventoryPage;

    //----------------------------------------


    public void addProductToCartByName(String productName) {
        String formattedName = productName.toLowerCase().replace(" ", "-");
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-" + formattedName));
        addToCartButton.click();
    }


    public void removeProductFromCartByName(String productName) {
        String formattedName = productName.toLowerCase().replace(" ", "-");
        WebElement removeButton = driver.findElement(By.id("remove-" + formattedName));
        removeButton.click();
    }


    public void openCart() {
        cartButton.click();
    }





    public boolean isShoppingCartBadgeDisplayed() {
        try {
            return cartBadge.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public void clickOnHamburgerMenu() {
        hamburgerMenu.click();
    }


    public void clickOnLogoutButton() {
        logoutButton.click();
    }


    public void addAllProducts() throws InterruptedException {
        for (WebElement button : listOfAllProductsByAddToCartButton) {
            button.click();
            Thread.sleep(200);
        }
    }


    public int areAllProductsDisplayed() {
        return listOfAllProducts.size();
    }


    public String getCartItemCount() {
        return cartBadge.getText();
    }

    public boolean isInventoryPageDisplayed() {
        return inventoryPage.isDisplayed();
    }
}
