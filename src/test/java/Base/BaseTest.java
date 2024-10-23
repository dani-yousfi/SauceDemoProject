package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public ExcelReader excelReader;

    public HomepagePage homepagePage;

    public InventoryPage inventoryPage;

    public CartPage cartPage;

    public CheckoutPageOne checkoutPageOne;

    public CheckoutPageTwo checkoutPageTwo;

    public CheckoutCompletePage checkoutCompletePage;




    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        excelReader = new ExcelReader("SauceDemo.xlsx");
        homepagePage = new HomepagePage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkoutPageOne = new CheckoutPageOne();
        checkoutPageTwo = new CheckoutPageTwo();
        checkoutCompletePage = new CheckoutCompletePage();




    }

    public void login() {
        driver.navigate().to("https://www.saucedemo.com/");
        homepagePage.inputUsername("standard_user");
        homepagePage.inputPassword("secret_sauce");
        homepagePage.clickOnLoginButton();
    }



    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }


















}
