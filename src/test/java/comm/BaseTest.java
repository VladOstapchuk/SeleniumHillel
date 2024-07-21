package comm;

import org.com.driver_manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverManager.getDriver();
    }


    @AfterClass
    public void closeDriver() {
        DriverManager.driverQuit();
    }


}
