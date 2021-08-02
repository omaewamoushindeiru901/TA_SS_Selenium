package pageObgects;

import consts.BusinessConfig;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends AbstractPage {
    private final By signInButton = By.className("header-auth__signin");

    private final By topRightCornerUserNameElement = By.className("user-info__name");



    public SignInPage clickSignInButton() {
        getElement(signInButton).click();
        LOG.info("'Sign in' button clicked");
        return new SignInPage();
    }

    public HomePage proceedToHomePage() {
        proceedToPage(BusinessConfig.HOME_PAGE_URL.getUrl());
        LOG.info(String.format("Proceeded to '%s' URL.",BusinessConfig.HOME_PAGE_URL.getUrl()));
        return this;
    }

    public boolean isUserNameDisplayed(){
        boolean isDisplayed = isDisplayed(topRightCornerUserNameElement);
        LOG.info(String.format("User is logged in: '%s'",isDisplayed));
        return isDisplayed;
    }
    public String getLoggedInUserName(){
        return getElement(topRightCornerUserNameElement).getText();
    }


    public void verifyUserIsLoggedIn(){
        Assert.assertTrue(isUserNameDisplayed(),"User is not logged in");
    }


}
