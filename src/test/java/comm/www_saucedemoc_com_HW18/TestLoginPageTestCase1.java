package comm.www_saucedemoc_com_HW18;

import comm.BaseTest;
import org.com.BasePage;
import org.com.www_saucedemoc_com_HW18.page_object.SdHome;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPageTestCase1 extends BaseTest {


    //тест по тест-кейсу 1 з ДЗ 18
    @Test
    public void TestCase1() {
        //відкрити сторінку з цією URL
        new BasePage(driver).openURL("https://www.saucedemo.com/");
        new SdHome(driver)
                .checkTitlePageText()
                .usernameInput("standard_user")
                .passwordInput("secret_sauce")
                .clickSubmitButton();

        //перевірка URL cторінки, що завантажилась
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "URL is not correct!");
    }
}
