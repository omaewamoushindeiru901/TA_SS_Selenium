import org.testng.annotations.Test;
import pageObgects.HomePage;
import pageObgects.SignInPage;

public class ContinueButtonTests extends BaseTest{
    @Test(description = "Check if continue button is enabled when user inputs valid email")
    public void verifyButton(){
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("ivanhorintest@gmail.com")
                .verifyButtonIsEnabled();

    }

    @Test(description = "Verify email by 'boundary values' criteria")
    public void verifyButtonByBoundaries(){
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("123456789012345678901234567890123456789012345678901234@gmail.com")
                .verifyButtonIsEnabled();
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("123456789012345678901234567890123456789012345678901234@gmail.ua")
                .verifyButtonIsEnabled();
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("qqqq@gmail.eeeeeeeeee")
                .verifyButtonIsEnabled();
    }
}
