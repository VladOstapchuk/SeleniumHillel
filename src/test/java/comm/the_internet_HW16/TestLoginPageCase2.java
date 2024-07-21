package comm.the_internet_HW16;

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


public class TestLoginPageCase2 {
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
    public void testLoginPageCase2() {
        //відкрити сторінку з цією URL
        driver.get("https://the-internet.herokuapp.com/login");
        //перевірка, що сторінка загрузилась
        WebElement titlepage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Login Page']")));
        //перевірка що на сторінці є текст
        Assert.assertEquals(titlepage.getText(), "Login Page", "Page Title is not correct");
        //заповнюю логін, пароль та натисаю кноку Логін
        WebElement usernamefield = driver.findElement(By.xpath("//input[@type='text' and @name='username']"));
        usernamefield.sendKeys("tomsmith" );
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']/i"));
        submitButton.click();
        //перевірка наявності флешки з текстом
        WebElement redflash = driver.findElement(By.xpath("//div[@id='flash' and @class='flash error']"));
        Assert.assertTrue(redflash.getText().contains("Your password is invalid!"), "Text is not correct!");
    }


    @AfterClass
    public void closeDive(){
        driver.quit();
    }
}
