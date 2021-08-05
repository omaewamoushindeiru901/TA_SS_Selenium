import consts.Locations;
import consts.Skills;
import dataProvider.DataProviders;
import org.testng.annotations.Test;
import pageObgects.HomePage;
import pageObgects.TrainingListPage;

public class TrainingListPageTests extends BaseTest{
    @Test(dataProvider = "validCredentials",dataProviderClass = DataProviders.class,description = "Verify ‘Trainings’ search works properly with searching in ‘Skills'")
    public void verifyTrainingsSearchSkills(String email, String password){
        new HomePage()
                .signIn(email, password)
                .clickTrainingListLinkButton()
                .uncheckSelectedLocations()
                .clickOnSearchByButton()
                .clickOnBySkillsButton()
                .checkSkill(Skills.JAVA)
                .verifyPresentCourses(Skills.JAVA);
        new TrainingListPage()
                .uncheckSkill()
                .clickOnSearchByButton()
                .checkSkill(Skills.RUBY)
                .verifyNoTrainingsMessageDisplayed();
    }

    @Test(dataProvider = "validCredentials",dataProviderClass = DataProviders.class,description = "Verify ‘Trainings’ search works properly with searching in ‘Locations’.")
    public void verifyTrainingSearchLocations(String email, String password){
        new HomePage()
                .signIn(email, password)
                .clickTrainingListLinkButton()
                .uncheckSelectedLocations()
                .clickOnSearchByButton()
                .checkLocation(Locations.LVIV)
                .verifyLocations(Locations.LVIV);
    }
}
