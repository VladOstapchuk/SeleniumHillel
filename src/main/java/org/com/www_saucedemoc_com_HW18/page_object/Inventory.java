package org.com.www_saucedemoc_com_HW18.page_object;

import org.com.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


//page url = https://www.saucedemo.com/inventory.html
public class Inventory extends BasePage {
    public Inventory(WebDriver driver) {
        super(driver);
    }

    //натискаю саме першу кнопку в DIV, щоб потым перевірити що саме вона змінила статус
    public By addToCartButton() {
        return By.xpath("//div[@class='inventory_item'][1]//button[text()='Add to cart']");
    }

    //натискаю саме першу кнопку в DIV з текстом Remove
    public By removeFromCartButton() {
        return By.xpath("//div[@class='inventory_item'][1]//button[text()='Remove']");
    }

    // поле де відображається кількість товарів в корзині
    public By numberOfProductsInCart() {
        return By.xpath("//span[@class='shopping_cart_badge']");
    }


//_____________________________________________________________________________________________________


    //клік на кнопку Add to Cart
    public Inventory clickAddToCardButton() {
        driver.findElement(addToCartButton()).click();
        return this;
    }

    //клік на кнопку Add to Cart
    public Inventory checkAddToCardButton() {
        Assert.assertTrue(driver.findElement(addToCartButton()).isDisplayed(), "Button Add to Card is NOT Displayed");
        return this;
    }

    //перевірка що кнопка Add to Card змінилась після натискання на Remove
    public Inventory checkRemoveButton() {
        Assert.assertTrue(driver.findElement(removeFromCartButton()).getText().contains("Remove"), "Text is not correct!");
        // driver.navigate().refresh();
        return this;
    }

    //перевірка що У правому верхньому куті іконки кошика з’явилося число “1”
    public Inventory checkCartIcon() {
        Assert.assertTrue(driver.findElement(numberOfProductsInCart()).getText().contains("1"), "Text is not correct!");
        return this;
    }

    // натискання кнопки Remove
    public Inventory clickRemoveButton() {
        driver.findElement(removeFromCartButton()).click();
        return this;
    }

    //перевірка, що після натискання кнопки Remove, кылькысть товарыв в корзины зменшилась на 1
    //працюэ лише через .size()
    public boolean checkCartQuantityAfterRemove() {
        int quantityAfterRemove;
        int quantityBeforeRemove = Integer.parseInt(driver.findElement(numberOfProductsInCart()).getText());
        clickRemoveButton();

        if (driver.findElements(numberOfProductsInCart()).size() != 0) {
            quantityAfterRemove = Integer.parseInt(driver.findElement(numberOfProductsInCart()).getText());
        } else quantityAfterRemove = 0;

        return quantityBeforeRemove - quantityAfterRemove == 1;
    }
}

