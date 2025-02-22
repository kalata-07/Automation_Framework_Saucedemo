package qa.automation;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest extends TestUtil {

    @Test
    public void LoginWithJSAction() throws InterruptedException {
        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("standard_user");

        // (//input[@class='form_input'])[2]
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordInput.click();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = driver.findElement(By.cssSelector("[value=LOGIN]"));
        loginBtn.click();
//        loginBtn.sendKeys(Keys.ENTER);

       JavascriptExecutor script = (JavascriptExecutor) driver;
       script.executeScript("arguments[0].scrollIntoView", driver.findElement(By.xpath("/html/body/footer/ul/li[3]")));
       Thread.sleep(3000);

//        WebElement linkedin = driver.findElement(By.xpath("/html/body/footer/ul/li[3]"));
//        linkedin.click();
    }
}
