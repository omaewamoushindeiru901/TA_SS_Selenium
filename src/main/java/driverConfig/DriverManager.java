package driverConfig;

import consts.ConstantValues;
import consts.DriverConfigs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class DriverManager {
    protected static final Logger LOG= Logger.getLogger(DriverManager.class.getName());
     private static WebDriver driver;
    WebDriver getWebDriver(String browserName){
        switch (browserName){
            case "CHROME":
                return new ChromeDriver();
            case "MOZILLA":
                return new FirefoxDriver();
            case "EDGE":
                return new EdgeDriver();
            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }


    public void createDriver(String browserName){
        DriverConfigs browser=DriverConfigs.valueOf(browserName);
        System.setProperty(browser.getName(), browser.getPath());
        driver = getWebDriver(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(ConstantValues.IMPLICITLY_WAIT_VALUE.getValue(), TimeUnit.SECONDS);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public static void quitDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
