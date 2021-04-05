package theInternetChallenge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAuth_Y {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void userNamePassword() {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    }

    @Test(priority = 1)
    public void multipleWindows() {
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        WebElement clickHere = driver.findElement(By.cssSelector("a[href='/windows/new']"));
        clickHere.click();
        driver.getWindowHandles();


    }
}
