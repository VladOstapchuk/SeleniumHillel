package org.com.the_internet_herokuap.driver_manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class DriverManager {

    private static WebDriver driver;

    public DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10,SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, SECONDS);
        }
        return driver;
    }

    public static void driverQuit(){
        if (getDriver() != null){
            driver.quit();
            driver = null;
        }
    }
}
