package org.com.the_internet_herokuap.page_object;


import org.com.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


//page url = https://the-internet.herokuapp.com/
public class Home extends BasePage {

    public Home(WebDriver driver) {
        super(driver);
    }

    //повертає об'єкт By, що знаходить за X-path
    public By btnOnLoginPage(String buttonName) {
        return By.xpath("//a[@href='/" + buttonName + "']");
    }

//_____________________________________________________________________________________________________

    //перехід на посилання з переліку, що є на сторінці
    public void clickOnLink(String name) {
        driver.findElement(btnOnLoginPage(name)).click();
    }
}
