package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPageTwo extends BaseTest {

    public CheckoutPageTwo() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(className = "summary_info")
    public WebElement summaryInfo;

    public boolean isCheckoutSummaryDisplayed() {
        return summaryInfo.isDisplayed();
    }

    public void finishCheckout() {
        finishButton.click();
    }
}
