package comm.www_saucedemoc_com_HW18;

import comm.BaseTest;
import org.com.BasePage;
import org.com.www_saucedemoc_com_HW18.page_object.SdHome;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLoginPageTestCase3 extends BaseTest {


    //тест по тест-кейсу 3 з ДЗ 18
    @Test
    public void TestCase3() {
        //відкрити сторінку з цією URL
        new BasePage(driver).openURL("https://www.saucedemo.com/");

        //все завернув в Assert - остання перевірка на кількість товарів в корзині повертає boolean
        Assert.assertTrue(
                new SdHome(driver)
                        .checkTitlePageText()
                        .usernameInput("standard_user")
                        .passwordInput("secret_sauce")
                        .clickSubmitButton()
                        .clickAddToCardButton()
                        .checkCartQuantityAfterRemove());

    }
}
