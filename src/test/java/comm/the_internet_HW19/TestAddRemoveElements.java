package comm.the_internet_HW19;

import comm.BaseTest;
import org.com.BasePage;
import org.com.the_internet_herokuap.page_object.AddRemoveElements;
import org.com.the_internet_herokuap.page_object.Home;

import org.testng.annotations.Test;

public class TestAddRemoveElements extends BaseTest {


    //тест по тест-кейсу 1 з ДЗ 19
    @Test
    public void TestCase1() {
        //відкрити сторінку з цією URL
        new BasePage(driver).openURL("https://the-internet.herokuapp.com/");
        new Home(driver)
                .clickOnLink("add_remove_elements/");
        //новий об'єкт, так як clickOnLink нічого не повертає, бо можуть бути різні сторінки
        new AddRemoveElements(driver)
                .checkTitlePageText()
                .clickAddButton(3)
                .clickDeleteButton(3);


    }
}
