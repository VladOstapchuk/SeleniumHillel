package org.com.the_internet_herokuap.page_object;

import org.com.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

//page url = https://the-internet.herokuapp.com/login
public class Login extends BasePage{
    public Login(WebDriver driver) {
        super(driver);
    }

    public By usernamefield() {
        return By.xpath("//input[@type='text' and @name='username']");
    }

    public By passwordfield() {
        return By.xpath("//input[@type='password' and @name='password']");
    }

    public By submitButton() {
        return By.xpath("//button[@type='submit']/i");
    }

    public By titleText() {
        return By.xpath("//h2[text()='Login Page']");
    }

    public By flashLoggedOutElement() {
        return By.xpath("//div[@id='flash' and @class='flash success']");
    }

    public By redflashElement() {
        return By.xpath("//div[@id='flash' and @class='flash error']");
    }

//_____________________________________________________________________________________________________

    //перевіряю текст в тайтлі Н2
    public Login checkTitlePageText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement titlepage = wait.until(ExpectedConditions.visibilityOfElementLocated(titleText()));
        Assert.assertEquals(titlepage.getText(), "Login Page", "Page Title is not correct");
        return this;
    }

    //вношу дані в поле вводу Login
    public Login usernameInput(String username) {
        driver.findElement(usernamefield()).sendKeys(username);
        return this;
    }

    //вношу дані в поле вводу Password
    public Login passwordInput(String password) {
        driver.findElement(passwordfield()).sendKeys(password);
        return this;
    }

    //клік на кнопку Login
    public Secure clickSubmitButton() {
        driver.findElement(submitButton()).click();
        return new Secure(driver);
    }

    public Login clickWrongSubmitButton() {
        driver.findElement(submitButton()).click();
        return this;
    }

    //Асерт флеша, що з'являється при виході
    public void loggedOut() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login", "URL is not correct!");
        WebElement flashloggedout = driver.findElement(flashLoggedOutElement());
        Assert.assertTrue(flashloggedout.getText().contains("You logged out of the secure area!"), "Text is not correct!");
    }

    //перевірка наявності червоної флешки з текстом про помилку в пассворді
    public void LoginWithoutPassword() {
        WebElement redflashWebElement = driver.findElement(redflashElement());
        Assert.assertTrue(redflashWebElement.getText().contains("Your password is invalid!"), "Text is not correct!");
    }

    //перевірка наявності червоної флешки з текстом про помилку в юзернеймі
    public void LoginWithoutUsername() {
        WebElement redflashWebElement = driver.findElement(redflashElement());
        Assert.assertTrue(redflashWebElement.getText().contains("Your username is invalid!"), "Text is not correct!");
    }


}
