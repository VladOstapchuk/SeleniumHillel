package org.com.www_saucedemoc_com_HW18.page_object;


import org.com.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


//page url = https://www.saucedemo.com
public class SdHome extends BasePage {

    public SdHome(WebDriver driver) {
        super(driver);
    }

    //x-path для поля Username
    public By usernamefield() {
        return By.xpath("//input[@placeholder='Username']");
    }

    //x-path для поля Password
    public By passwordfield() {
        return By.xpath("//input[@placeholder='Password']");
    }

    //x-path для поля кнопки Login
    public By submitButton() {
        return By.xpath("//input[@type='submit']");
    }

    //x-path для поля Title text (Swag Labs)
    public By titleText() {
        return By.xpath("//div[@class='login_logo']");
    }


//_____________________________________________________________________________________________________

    //перевірка що на сторінці є тайтл з текстом
    public SdHome checkTitlePageText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(titleText()));
        Assert.assertEquals(pageTitle.getText(), "Swag Labs", "Page Title is not correct");
        return this;
    }

    //вношу дані в поле вводу Login
    public SdHome usernameInput(String username) {
        driver.findElement(usernamefield()).sendKeys(username);
        return this;
    }

    //вношу дані в поле вводу Password
    public SdHome passwordInput(String password) {
        driver.findElement(passwordfield()).sendKeys(password);
        return this;
    }

    //клік на кнопку Login
    public Inventory clickSubmitButton() {
        driver.findElement(submitButton()).click();
        return new Inventory(driver);
    }

}
