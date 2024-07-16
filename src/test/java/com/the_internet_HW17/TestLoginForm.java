package com.the_internet_HW17;

import org.com.the_internet_herokuap.page_object.BasePage;
import org.com.the_internet_herokuap.page_object.Home;
import org.testng.annotations.Test;

public class TestLoginForm extends BaseTest {

    //тест по тест-кейсу 1 з ДЗ 16
    @Test
    public void testLoginPageCase1() {
        //відкрити сторінку з цією URL
        new BasePage(driver).openURL("https://the-internet.herokuapp.com");
        new Home(driver)
                .clickOnLink("login")
                .checkTitlePageText()
                .usernameInput("tomsmith")
                .passwordInput("SuperSecretPassword!")
                .clickSubmitButton()
                .waitFlashElement()
                .logoutPush()
                .loggedOut();
    }

    //тест по тест-кейсу 2 з ДЗ 16
    @Test
    public void testLoginPageCase2() {
        //відкрити сторінку з цією URL
        new BasePage(driver).openURL("https://the-internet.herokuapp.com");
        new Home(driver)
                .clickOnLink("login")
                .checkTitlePageText()
                .usernameInput("tomsmith")
                .clickWrongSubmitButton()
                .LoginWithoutPassword();
    }

    //тест по тест-кейсу 3 з ДЗ 16
    @Test
    public void testLoginPageCase3() {
        //відкрити сторінку з цією URL
        new BasePage(driver).openURL("https://the-internet.herokuapp.com");
        new Home(driver)
                .clickOnLink("login")
                .checkTitlePageText()
                .passwordInput("SuperSecretPassword!")
                .clickWrongSubmitButton()
                .LoginWithoutUsername();
    }
}
