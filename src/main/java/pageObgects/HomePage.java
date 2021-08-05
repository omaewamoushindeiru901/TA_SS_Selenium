package pageObgects;

import consts.BusinessConfig;
import dataProvider.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePage extends AbstractPage {
    private final By signInButton = By.className("header-auth__signin");
    private final By topRightCornerUserNameElement = By.className("user-info__name");
    private final By trainingListLinkButton = By.xpath("//ul[@class='main-nav__list']//a[contains(@class,'training')]");
    private final By blogButton = By.xpath("//ul[@class='main-nav__list']//li//a[contains(text(),'Blog')]");


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

    public TrainingListPage clickTrainingListLinkButton(){
        getElement(trainingListLinkButton).click();
        LOG.info("Training list link button clicked.");
        return new TrainingListPage();
    }

    public BlogPage clickBlogPageButton(){
        getElement(blogButton).click();
        LOG.info("Blog button clicked");
        return new BlogPage();
    }


    public HomePage signIn(String email, String password){
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(email)
                .clickContinueButton()
                .enterPassword(password)
                .clickSignInButton();
        return this;
    }

}
