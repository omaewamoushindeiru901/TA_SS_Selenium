import org.testng.annotations.Test;
import pageObgects.HomePage;

public class BlogPageTests extends BaseTest{
    @Test(description = "Verify links on ‘Blog’ Page ")
    public void verifyLinks(){
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("ivanhorintest@gmail.com")
                .clickContinueButton()
                .enterPassword("ivanhorintestPassword")
                .clickSignInButton()
                .clickBlogPageButton()
                .verifyLinksAreDisplayed();
    }
}
