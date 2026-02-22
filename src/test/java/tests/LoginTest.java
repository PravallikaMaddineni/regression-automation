package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "Login failed - Inventory page not loaded");
    }

    @Test
    public void invalidPasswordTest() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("wrong_password");
        driver.findElement(By.id("login-button")).click();

        Assert.assertTrue(
                driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed(),
                "Error message not displayed for invalid password"
        );
    }

    @Test
    public void emptyLoginTest() {

        driver.findElement(By.id("login-button")).click();

        Assert.assertTrue(
                driver.findElement(By.cssSelector("[data-test='error']")).isDisplayed(),
                "Error message not displayed for empty login"
        );
    }
}