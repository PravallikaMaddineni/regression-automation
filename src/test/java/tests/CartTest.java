package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    private void login() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void addToCartTest() {

        login();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(cartBadge.getText(), "1", "Item not added to cart");
    }

    @Test
    public void removeFromCartTest() {

        login();

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        boolean badgePresent = driver.findElements(By.className("shopping_cart_badge")).size() > 0;
        Assert.assertFalse(badgePresent, "Item not removed from cart");
    }
}