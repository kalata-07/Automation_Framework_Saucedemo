package qa.automation;

import base.TestUtil;
import com.opencsv.exceptions.CsvException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.CsvHelper;

import java.io.IOException;

public class LoginTest extends TestUtil {
//    private WebDriver driver;

//    @BeforeTest
//    public void initializerDriver(){
//        WebDriverManager.edgedriver().setup();//
//        driver = new EdgeDriver();
//    }

//    @AfterTest
//    public void tearDown(){
//        driver.quit();
//    }

    @DataProvider(name = "wrongUsersList")
    public Object [][] getWrongUsers(){
        return new Object[][]{
                {"standardUser7", "secret_sauce"},
                {"standard_user", "wrong_password"},
                {"blah", "blah"}
        };
    }

    @DataProvider (name = "csvUserList")
    public static Object[][] readUsersFromCsvFile() throws IOException, CsvException {
        return CsvHelper.readCsvFile("src/test/resources/usersCSV");
    }

    @Test (dataProvider = "wrongUsersList")
    public void UnsuccessfulLogin(String userName, String password){
//        driver.get("https://www.saucedemo.com/v1/");

//        WebElement username = driver.findElement(By.id("user-name"));
//        username.click();
 //       username.sendKeys(userName);

        // (//input[@class='form_input'])[2]
//        WebElement passwordInput = driver.findElement(By.id("password"));
 //       passwordInput.click();
 //       passwordInput.sendKeys(password);

//        WebElement loginBtn = driver.findElement(By.cssSelector("[value=Login]"));
 //       loginBtn.click();

        LoginPage loginPage = new LoginPage(driver);
       loginPage.login(userName, password);
       // loginPage.tryToLogin(userName, password);

        WebElement errorLoginLabel = driver.findElement(By.className("error-button"));
        Assert.assertTrue(errorLoginLabel.isDisplayed());
    }

    @Test (dataProvider = "csvUserList")
    public void SuccessfulLogin(String userName, String password){
//        driver.get("https://www.saucedemo.com/v1/");

//        WebElement username = driver.findElement(By.id("user-name"));
//        username.click();
//        username.sendKeys(userName);

        // (//input[@class='form_input'])[2]
//        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"password\"]"));
//        passwordInput.click();
//        passwordInput.sendKeys(password);

//        WebElement loginBtn = driver.findElement(By.cssSelector("[value=LOGIN]"));
//        loginBtn.click();
//
 //      WebElement userAllPagesButton = driver.findElement(By.id("menu_button_container"));
 //       Assert.assertTrue(userAllPagesButton.isDisplayed());

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage= loginPage.login(userName,password);
    }
}
