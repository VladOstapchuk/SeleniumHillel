package comm.the_internet_HW16;

import comm.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class TestLoginPageCase1 extends BaseTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void startdriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void testLoginPageCase1() {
        //відкрити сторінку з цією URL
        driver.get("https://the-internet.herokuapp.com/login");
        //перевірка, що сторінка загрузилась
        WebElement titlepage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Login Page']")));
        //перевірка що на сторінці є текст
        Assert.assertEquals(titlepage.getText(), "Login Page", "Page Title is not correct");
        //заповнюю логін, пароль та натисаю кноку Логін
        WebElement usernamefield = driver.findElement(By.xpath("//input[@type='text' and @name='username']"));
        WebElement passwordfield = driver.findElement(By.xpath("//input[@type='password' and @name='password']"));
        usernamefield.sendKeys("tomsmith" );
        passwordfield.sendKeys("SuperSecretPassword!");
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']/i"));
        submitButton.click();
        //перевірка URL cторінки, що завантажилась
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure", "URL is not correct!");
        //перевірка наявності флешки з текстом
        WebElement flash = driver.findElement(By.xpath("//div[@id='flash']"));
        Assert.assertTrue(flash.getText().contains("You logged into a secure area!"), "Text is not correct!");
        //Натиснути на кнопку Logout
        WebElement logoutButton = driver.findElement(By.xpath("//a[@href='/logout']/i[text()=' Logout']"));
        logoutButton.click();
        //перевірка, що завантажилась сторінка з потрібним URL
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login", "URL is not correct!");
        //перевірка що на сторінці є флеша з потрібним текстом
        WebElement flashloggedout = driver.findElement(By.xpath("//div[@id='flash' and @class='flash success']"));
        Assert.assertTrue(flashloggedout.getText().contains("You logged out of the secure area!"), "Text is not correct!");
    }

    @AfterClass
    public void closeDive(){
        driver.quit();
    }
}
