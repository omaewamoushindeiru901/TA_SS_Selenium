import org.testng.annotations.Test;
import pageObgects.HomePage;
import pageObgects.TrainingListPage;

import java.util.HashMap;

public class TrainingListPageTests extends BaseTest{
    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Skills'")
    public void verifyTrainingsSearchSkills(){
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("ivanhorintest@gmail.com")
                .clickContinueButton()
                .enterPassword("ivanhorintestPassword")
                .clickSignInButton()
                .clickTrainingListLinkButton()
                .uncheckSelectedLocations()
                .clickOnSearchByButton()
                .clickOnBySkillsButton()
                .checkJava()
                .verifyJavaCourses()
                .uncheckJava()
                .clickOnSearchByButton()
                .checkRuby()
                .verifyNoTrainingsMessageDisplayed();
    }

    @Test(description = "Verify ‘Trainings’ search works properly with searching in ‘Locations’.")
    public void verifyTrainingSearchLocations(){
        new HomePage()
                .proceedToHomePage()
                .clickSignInButton()
                .enterEmail("ivanhorintest@gmail.com")
                .clickContinueButton()
                .enterPassword("ivanhorintestPassword")
                .clickSignInButton()
                .clickTrainingListLinkButton()
                .uncheckSelectedLocations()
                .clickOnSearchByButton()
                .checkLviv()
                .verifyLocations();
    }
}
