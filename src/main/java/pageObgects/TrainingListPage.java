package pageObgects;

import driverConfig.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class TrainingListPage extends AbstractPage{
    Actions actions=new Actions(DriverManager.getDriver());

    private final By selectedLocationsCheckbox=By.xpath("//span[@class='filter-field__input-item-close-icon']");
    private final By searchByInput=By.xpath("//form[@class='training-search-form ng-pristine ng-valid ng-scope']");
    private final By bySkillsButton=By.xpath("//div[@class='navigation-item ng-binding'][contains(text(),'By skills')]");
    private final By javaCheckbox=By.xpath("//label[normalize-space()='Java']/span");
    private final By rubyCheckbox=By.xpath("//label[normalize-space()='Ruby']/span");
    private final By noTrainingsMessage=By.xpath("//span[contains(text(),'No training are available')]");
    private final By availableJavaCourses=By.xpath("//div[@class='training-list__container training-list__desktop']//div[@class='training-item__title ng-binding']");
    private final By courses=By.xpath("//div[@class='training-list__container training-list__desktop']");
    private final By byLocationButton=By.xpath("//div[@class='navigation-item ng-binding'][contains(text(),'By locations')]");
    private final By ukraineLocation =By.xpath("//div[@class='location__not-active-label city-name ng-binding'][contains(text(),'Ukraine')]");
    private final By lvivLocation=By.xpath("//label[normalize-space()='Lviv']/span");
    private final By availableCoursesUkraine=By.xpath("//div[@class='training-item__inner']/div/span");

    public TrainingListPage checkLviv(){
        getElement(ukraineLocation).click();
        LOG.info("Ukraine checked");
        getElement(lvivLocation).click();
        LOG.info("Lviv checked");
        getElement(searchByInput).click();
        return this;
    }

    public void verifyLocations(){
        List<WebElement> courses=getElements(availableCoursesUkraine);
        Assert.assertEquals(courses.size(),9);
    }

    public TrainingListPage uncheckSelectedLocations(){
        actions.moveToElement(getElement(selectedLocationsCheckbox)).click().perform();
        LOG.info("Selected checkboxes unchecked");
        return this;
    }

    public TrainingListPage uncheckJava(){
        actions.moveToElement(getElement(courses)).perform();
        getElement(selectedLocationsCheckbox).click();
        LOG.info("Java unchecked");
        return this;
    }

    public TrainingListPage clickOnSearchByButton(){
        actions.moveToElement(getElement(courses)).perform();
        getElement(searchByInput).click();
        LOG.info("Search by input clicked");
        return this;
    }

    public TrainingListPage clickOnBySkillsButton(){
        getElement(bySkillsButton).click();
        LOG.info("By skills button clicked");
        return this;
    }

    public TrainingListPage clickOnByLocationsButton(){
        getElement(byLocationButton).click();
        LOG.info("By location button clicked");
        return this;
    }

    public TrainingListPage checkJava(){
        getElement(javaCheckbox).click();
        getElement(searchByInput).click();
        LOG.info("Java checked");
        return this;
    }

    public TrainingListPage verifyJavaCourses(){
        List<WebElement> courses=getElements(availableJavaCourses);
        Assert.assertEquals(courses.size(),18);
        return this;
    }

    public TrainingListPage checkRuby(){
        getElement(rubyCheckbox).click();
        getElement(searchByInput).click();
        LOG.info("Ruby checked");
        return this;
    }

    public boolean isNoTrainingsMessageDisplayed(){
        boolean isDisplayed=isDisplayed(noTrainingsMessage);
        LOG.info(String.format("No trainings message is displayed: '%s' ",isDisplayed));
        return isDisplayed;
    }

    public void verifyNoTrainingsMessageDisplayed(){
        Assert.assertTrue(isNoTrainingsMessageDisplayed(),"No trainings message is not displayed");
    }
}
