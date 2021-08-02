import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstHWTest {

    @Test(description = "Check if user successfully logged in with valid credentials")
    public void verifyUser(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.by/#!/Home?lang=en");

        WebElement signInButton = driver.findElement(By.className("header-auth__signin"));
        signInButton.click();

        WebElement mailInput=driver.findElement(By.id("username"));
        mailInput.sendKeys("ivanhorintest@gmail.com");
        WebElement continueButton=driver.findElement(By.id("kc-login-next"));
        continueButton.click();

        WebElement passwordInput=driver.findElement(By.id("password"));
        passwordInput.sendKeys("ivanhorintestPassword");
        WebElement signInButtonOnPasswordWindow=driver.findElement(By.id("kc-login"));
        signInButtonOnPasswordWindow.click();

        WebElement userName=driver.findElement(By.className("user-info__name"));
        Assert.assertTrue(userName.isDisplayed(),"Username is NOT displayed");

        driver.quit();
    }

    @Test(description = "Check if user not logged in with invalid password")
    public void verifyUserWrong() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://training.by/#!/Home?lang=en");

        WebElement signInButton = driver.findElement(By.className("header-auth__signin"));
        signInButton.click();

        WebElement mailInput=driver.findElement(By.id("username"));
        mailInput.sendKeys("ivanhorintest@gmail.com");
        WebElement continueButton=driver.findElement(By.id("kc-login-next"));
        continueButton.click();

        WebElement passwordInput=driver.findElement(By.id("password"));
        passwordInput.sendKeys("2882289020");
        WebElement signInButtonOnPasswordWindow=driver.findElement(By.id("kc-login"));
        signInButtonOnPasswordWindow.click();

        Thread.sleep(2000);

        WebElement errorMessage=driver.findElement(By.className("error-text"));
        Assert.assertTrue(errorMessage.isDisplayed(),"Error message is NOT displayed");

        driver.quit();
    }
}
