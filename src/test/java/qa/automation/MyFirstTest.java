package qa.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyFirstTest {

    private WebDriver driver;

    @BeforeTest
    public void initializerDriver(){
        WebDriverManager.chromedriver().setup();//
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void successfulLoginTest(){
        driver.get("https://www.saucedemo.com/v1/");

        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");

        // (//input[@class='form_input'])[2]
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.click();
        password.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.cssSelector("[value=LOGIN]"));
        loginBtn.click();

        WebElement userAllPagesButton = driver.findElement(By.id("menu_button_container"));
        Assert.assertTrue(userAllPagesButton.isDisplayed());
    }
}
