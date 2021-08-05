import dataProvider.DataProviders;
import org.testng.annotations.Test;
import pageObgects.HomePage;

public class BlogPageTests extends BaseTest{
    @Test(dataProvider = "validCredentials",dataProviderClass = DataProviders.class,description = "Verify links on ‘Blog’ Page ")
    public void verifyLinks(String email,String password){
        new HomePage()
                .signIn(email, password)
                .clickBlogPageButton()
                .verifyLinksAreDisplayed();
    }
}
