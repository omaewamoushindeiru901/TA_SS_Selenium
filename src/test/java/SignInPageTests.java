import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pageObgects.HomePage;
import pageObgects.SignInPage;

import java.util.concurrent.TimeUnit;

public class SignInPageTests extends BaseTest{

    @Test(description = "Check if user logged in successfully with valid credentials")
    public void verifyUser(){
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("ivanhorintest@gmail.com")
                .clickContinueButton()
                .enterPassword("ivanhorintestPassword")
                .clickSignInButton()
                .verifyUserIsLoggedIn();
    }

    @Test(description = "Check if user got error message when logging in with invalid credentials")
    public void verifyUserWrong(){
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("ivanhorintest@gmail.com")
                .clickContinueButton()
                .enterPassword("ivanhorintestPasswordddd")
                .clickSignInButton();
        new SignInPage()
                .verifyFailedLoginErrorMessageDisplayed();

    }
}
