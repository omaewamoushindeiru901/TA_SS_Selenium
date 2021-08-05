package pageObgects;

import consts.Locations;
import consts.Skills;
import driverConfig.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TrainingListPage extends AbstractPage{
    Actions actions=new Actions(DriverManager.getDriver());

    private final By selectedFiltersCheckbox=By.xpath("//span[@class='filter-field__input-item-close-icon']");
    private final By searchByInput=By.xpath("//form[@class='training-search-form ng-pristine ng-valid ng-scope']");
    private final By bySkillsButton=By.xpath("//div[@class='navigation-item ng-binding'][contains(text(),'By skills')]");
    private final By noTrainingsMessage=By.xpath("//span[contains(text(),'No training are available')]");
    private final By allAvailableCoursesBySkills=By.xpath("//div[@class='training-list__container training-list__desktop']//div[@class='training-item__title ng-binding']");
    private final By courses=By.xpath("//div[@class='training-list__container training-list__desktop']");
    private final By byLocationButton=By.xpath("//div[@class='navigation-item ng-binding'][contains(text(),'By locations')]");
    private final By allAvailableCoursesByLocation=By.xpath("//div[@class='training-list__container training-list__desktop']//span[@class='training-item__location--text ng-binding ng-scope']");
    private final By multiLocationCourses = By.xpath("//div[@class='training-list__container training-list__desktop']//div[@class='rd-tooltip-text training-item__location--text'][normalize-space()='Multi-location']");

    public TrainingListPage checkSkill(Skills skill){
        getElement(By.xpath("//label[normalize-space()='"+skill.getSkillLowerCase()+"']/span")).click();
        getElement(searchByInput).click();
        LOG.info("Skill  checked");
        return this;

    }

    public TrainingListPage checkLocation(Locations loc){
        getElement(By.xpath("//div[@class='location__not-active-label city-name ng-binding'][contains(text(),'"
                +loc.getCountry()+"')]")).click();
        LOG.info("Country checked");
        getElement(By.xpath("//label[normalize-space()='"+loc.getCity()+"']/span")).click();
        LOG.info("City checked");
        getElement(searchByInput).click();
        return this;
    }

    public void verifyLocations(Locations loc){
        List<WebElement> specificCourses=getElements(allAvailableCoursesByLocation);
        List<WebElement> multiCourses=getElements(multiLocationCourses);
        SoftAssert softAssert=new SoftAssert();
        for (WebElement i : specificCourses) {
            softAssert.assertTrue(i.getText().contains(loc.getCountry()));
        }
        for (WebElement i : multiCourses) {
            softAssert.assertTrue(i.getText().contains("Multi-location"));
        }
        softAssert.assertAll();

    }

    public TrainingListPage uncheckSelectedLocations(){
        actions.moveToElement(getElement(selectedFiltersCheckbox)).click().perform();
        LOG.info("Selected checkboxes unchecked");
        return this;
    }

    public TrainingListPage uncheckSkill(){
        actions.moveToElement(getElement(courses)).perform();
        getElement(selectedFiltersCheckbox).click();
        LOG.info("Filter unchecked");
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


    public void verifyPresentCourses(Skills skill){
        SoftAssert softAssert=new SoftAssert();
        List<WebElement> courses=getElements(allAvailableCoursesBySkills);
        for (WebElement i : courses) {
            softAssert.assertTrue(i.getText().contains(skill.getSkillUpperCase()));
        }
        softAssert.assertAll();
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
