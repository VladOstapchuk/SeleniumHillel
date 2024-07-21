package comm.www_saucedemoc_com_HW18;

import comm.BaseTest;
import org.com.BasePage;
import org.com.www_saucedemoc_com_HW18.page_object.Inventory;
import org.com.www_saucedemoc_com_HW18.page_object.SdHome;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPageTestCase2 extends BaseTest {


    //тест по тест-кейсу 2 з ДЗ 18
    @Test
    public void TestCase2() {
        //відкрити сторінку з цією URL
        new BasePage(driver).openURL("https://www.saucedemo.com/");
        new SdHome(driver)
                .checkTitlePageText()
                .usernameInput("standard_user")
                .passwordInput("secret_sauce")
                .clickSubmitButton()
                .clickAddToCardButton()
                .checkRemoveButton()
                .checkCartIcon();

    }
}
