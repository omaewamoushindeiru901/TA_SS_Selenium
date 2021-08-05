import driverConfig.DriverManager;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.logging.Logger;

public abstract class BaseTest {

    protected Logger LOG=Logger.getLogger(BaseTest.class.getName());

    @Parameters({"browserName"})
    @BeforeMethod(alwaysRun = true)
    public void doBeforeMethod(@Optional(value = "CHROME") String browserName, Method method){
        DriverManager.createDriver(browserName);
        LOG = Logger.getLogger(String.valueOf(method.getDeclaringClass()));
        Test test = method.getAnnotation(Test.class);
        LOG.info(String.format("Test '%s' started.",method.getName()));
        LOG.info(String.format("Description: %s.", test.description()));
    }

    @AfterMethod(alwaysRun = true)
    public void doAfterMethod(final Method method){
        LOG.info(String.format("Test '%s' is completed.",method.getName()));
        DriverManager.quitDriver();
    }

}
