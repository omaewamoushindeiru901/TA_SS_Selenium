import dataProvider.DataProviders;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pageObgects.HomePage;
import pageObgects.SignInPage;

import java.util.concurrent.TimeUnit;

public class SignInPageTests extends BaseTest{

    @Test(dataProvider = "validCredentials",dataProviderClass = DataProviders.class,description = "Check if user logged in successfully with valid credentials")
    public void verifyUser(String email,String password){
        new HomePage()
                .signIn(email, password)
                .verifyUserIsLoggedIn();
    }

    @Test(dataProvider = "invalidCredentials",dataProviderClass = DataProviders.class,description = "Check if user got error message when logging in with invalid credentials")
    public void verifyUserWrong(String email,String password){
        new HomePage()
                .signIn(email, password);
        new SignInPage()
                .verifyFailedLoginErrorMessageDisplayed();

    }
}
