package pageObgects;

import consts.ConstantValues;
import driverConfig.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractPage {

    private final WebDriverWait wait =  new WebDriverWait(DriverManager.getDriver(), 10);

    protected static final Logger LOG= Logger.getLogger(AbstractPage.class.getName());

    AbstractPage() {
    }

    void proceedToPage(final String url) {
        DriverManager.getDriver().get(url);
    }

    WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    List<WebElement> getElements(By locator) {
        return DriverManager.getDriver().findElements(locator);
    }


    public boolean isDisplayed(By locator) {
        try {
            return getElement(locator).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

}
