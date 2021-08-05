import dataProvider.DataProviders;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObgects.HomePage;


public class ContinueButtonTests extends BaseTest{
    @Test(description = "Check if continue button is enabled when user inputs valid email")
    public void verifyButton(){
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("ivanhorintest@gmail.com")
                .verifyButtonIsEnabled();

    }

    @Test(dataProvider = "validEmails",dataProviderClass = DataProviders.class,description = "Verify email by 'boundary values' criteria")
    public void verifyButtonByBoundaries(String description,String value){
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(value)
                .verifyButtonIsEnabled();
    }

    @Test(dataProvider = "nonValidEmails",dataProviderClass = DataProviders.class,description = "Check if button disabled when email is invalid")
    public void verifyButtonHardAssert(String description,String value){
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(value)
                .verifyButtonIsDisabled();
    }

    @Test(dataProvider = "nonValidEmails",dataProviderClass = DataProviders.class,description = "Check if button disabled when email is invalid")
    public void verifyButtonSoftAssert(String description,String value){
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail(value)
                .verifyButtonIsDisabledSoftAssert();
    }
}
