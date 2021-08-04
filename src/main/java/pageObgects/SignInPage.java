package pageObgects;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SignInPage extends AbstractPage {

    private final By mailInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By signInButton = By.id("kc-login");
    private final By continueButton = By.id("kc-login-next");
    private final By loginFailedErrorMessage = By.xpath("//span[text()='We can't find user with such credentials.']");

    public SignInPage enterEmail(String email){
        getElement(mailInput).sendKeys(email);
        LOG.info("Mail was entered.");
        return this;
    }

   /* public boolean isEmailInBoundaries(String email){
        return email.length() > 0 && email.length() <= 64;
    }

    public boolean isDomainInBoundaries(String email){
        int i;
        for(i=0;i<email.length();i++){
            if(email.charAt(i)=='.') break;
        }
        return (email.length()-i-1)<=10 && (email.length()-i-1)>=2;
    }

    public boolean isAtSymbolPresent(String email){
        return email.contains("@");
    }

    public boolean isAtSymbolFirst(String email){
        return email.charAt(0)!='@';
    }

    public boolean verifyEmailIsValid(String email){
        return isEmailInBoundaries(email) && isDomainInBoundaries(email) && isAtSymbolFirst(email)
                && isAtSymbolPresent(email);}*/

    public void verifyButtonIsEnabled(){
        Assert.assertTrue(getElement(continueButton).isEnabled());
    }

    public void verifyButtonIsDisabled(){
        Assert.assertFalse(getElement(continueButton).isEnabled());
    }

    public void verifyButtonIsDisabledSoftAssert(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertFalse(getElement(continueButton).isEnabled());
        softAssert.assertAll();
    }


    public  SignInPage clickContinueButton(){
        getElement(continueButton).click();
        LOG.info("Continue button clicked.");
        return this;
    }

    public SignInPage enterPassword(String password){
        getElement(passwordInput).sendKeys(password);
        LOG.info("Password was entered.");
        return this;
    }

    public  HomePage clickSignInButton(){
        getElement(signInButton).click();
        LOG.info("Sign in button clicked.");
        return new HomePage();
    }

    public boolean isLoginFailedErrorMessageDisplayed() {
        boolean isDisplayed = isDisplayed(loginFailedErrorMessage);
        LOG.info(String.format("Is 'Login Failed' error message displayed': '%s'",isDisplayed));
        return isDisplayed;
    }

    public void verifyFailedLoginErrorMessageDisplayed(){
        Assert.assertFalse(isLoginFailedErrorMessageDisplayed(),
                "'Login failed' error message is not displayed");
    }

}
