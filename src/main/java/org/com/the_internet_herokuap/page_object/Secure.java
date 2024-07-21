package org.com.the_internet_herokuap.page_object;

import org.com.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

//page url = https://the-internet.herokuapp.com/secure
public class Secure extends BasePage {
    public Secure(WebDriver driver) {
        super(driver);
    }

    public By flashElement() {
        return By.xpath("//div[@id='flash']");
    }

    public By logoutButton() {
        return By.xpath("//a[@href='/logout']/i[text()=' Logout']");
    }

//_____________________________________________________________________________________________________________

    // очікування флеша після Логіну, перевірка вмісту текста на флеші
    public Secure waitFlashElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement flash = wait.until(ExpectedConditions.visibilityOfElementLocated(flashElement()));
        Assert.assertTrue(flash.getText().contains("You logged into a secure area!"), "Text is not correct!");
        return this;
    }

    //натискання кнопки Logout
    public Login logoutPush() {
        WebElement logoutButton = driver.findElement(logoutButton());
        logoutButton.click();
        return new Login(driver);
    }
}
