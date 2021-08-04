package pageObgects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class BlogPage extends AbstractPage {
    SoftAssert softAssert=new SoftAssert();
    private final By activeLink = By.xpath("//a[@class='tab-nav__item ng-scope active']");
    List<WebElement> notActiveLinks = getElements(By.xpath("//a[@class='tab-nav__item ng-scope']"));

    public void verifyLinksAreDisplayed(){
        softAssert.assertTrue(getElement(activeLink).isDisplayed());
        for(int i=0;i<notActiveLinks.size();i++){
            softAssert.assertTrue(notActiveLinks.get(i).isDisplayed());
        }
        softAssert.assertAll();
    }
}
