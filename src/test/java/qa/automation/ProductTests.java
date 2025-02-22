package qa.automation;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductTests extends TestUtil {
    @Test
    public void selectDifferentOrder() throws InterruptedException {
        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");

        // (//input[@class='form_input'])[2]
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordInput.click();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.cssSelector("[value=LOGIN]"));
        loginBtn.click();

        //        Thread.sleep(3000);

        WebElement dropDownSortingOptions = driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/select"));
        dropDownSortingOptions.click();
        WebElement lowToHighPriceOption = driver.findElement(By.cssSelector("[value=lohi]"));
        lowToHighPriceOption.click();

        Assert.assertTrue(lowToHighPriceOption.isEnabled());
//        Thread.sleep(3000);
    }

    @Test
    public void addItemToTheCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addItemToTheCart("bike-light");
        Assert.assertEquals( productsPage.getItemsInTheCart(),1);
        productsPage.removeItemFromTheCart("bike-light");


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productsPage.getItemsInTheCart(),0);
        System.out.println("I will be executed");

        softAssert.assertAll();
    }
}
