package com.the_internet_HW17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.com.the_internet_herokuap.driver_manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverManager.getDriver();
    }


    @AfterClass
    public void closeDriver() {
        DriverManager.driverQuit();
    }


}
