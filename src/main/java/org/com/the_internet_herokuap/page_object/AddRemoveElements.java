package org.com.the_internet_herokuap.page_object;

import org.com.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddRemoveElements extends BasePage {
    public AddRemoveElements(WebDriver driver) {
        super(driver);
    }

    //x-path Title сторінки
    public By titleText() {
        return By.xpath("//h3[text()='Add/Remove Elements']");
    }

    //x-path кнопки Add Element
    public By addElementButton() {
        return By.xpath("//div/button[text()='Add Element']");
    }

    //x-path кнопки Delete
    public By deleteButton() {
        return By.xpath("//div/button[text()='Delete']");
    }

    //x-path кнопки Delete - метод перегружений для видалення потрібної кількості елементів
    public By deleteButton(int numbers) {
        return By.xpath("//div/button[text()='Delete'][" + numbers + "]");
    }


//_____________________________________________________________________________________________________


    //метод перевіряє, що сторінка завантажилась
    public AddRemoveElements checkTitlePageText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement titlepage = wait.until(ExpectedConditions.visibilityOfElementLocated(titleText()));
        Assert.assertEquals(titlepage.getText(), "Add/Remove Elements", "Page Title is not correct");
        return this;
    }

    //метод натискання кнопки Add Element потрібну кількість раз,
    //заклав перевірку і реакцію, якщо передано 0
    public AddRemoveElements clickAddButton(int clicks) {
        try {
            for (int i = 1; i <= clicks; i++) {
                driver.findElement(addElementButton()).click();
            }
            Assert.assertTrue(driver.findElement(deleteButton(clicks)).isDisplayed());
        } catch (NoSuchElementException e) {
            System.out.println("Number of AddButton elements can't be 0");
            e.printStackTrace();
            driver.quit();
            System.exit(-1);
        }
        return this;
    }

    //метод натискання кнопки Delete потрібну кількість раз,
    //заклав перевірку і реакцію, якщо передано 0
    public void clickDeleteButton(int clicks) {
        if (clicks == 0) {
            System.out.println("Number of Delete elements can't be 0");
            driver.quit();
            System.exit(-1);
        } else {
            for (int i = 1; i <= clicks; i++) {
                driver.findElement(deleteButton()).click();
            }
            Assert.assertTrue((driver.findElements(deleteButton()).size() == 0), "Something wrong -> Delete button present on the page!");
        }
    }
}
