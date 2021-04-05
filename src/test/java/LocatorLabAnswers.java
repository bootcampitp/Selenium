import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocatorLabAnswers {
    @Test
    public void positive() throws InterruptedException {
        // Create an instance of ChromeDriver;
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to 'https://demo.cyclos.org/ui/login'
        driver.navigate().to("https://demo.cyclos.org/ui/login");

        /*
         Locate elements:
          -username,
          -password,
          -submit,
          -Forgot your password?
          -Not a user yet? Register here.
         */
        Thread.sleep(3000);
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='User']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement submit = driver.findElement((By.xpath("//button[@type='button' and span[contains(text(), 'Submit')]]")));
        WebElement forgot = driver.findElement(By.id("forgotPasswordLink"));
        WebElement register = driver.findElement(By.id("registerLink"));


        // Assert submit button is enabled
        submit.isEnabled();

        // Send "demo" to username field
        username.sendKeys("demo");

        // Send "1234" to password field
        password.sendKeys("1234");

        // Click submit
        submit.click();

        // Wait for 5 seconds --> Thread.sleep(5000);
        Thread.sleep(5000);

        // Print out full name
        WebElement fullname = driver.findElement(By.xpath("//*[@class='personal-label']"));
        String fullnameInString = fullname.getText();
        System.out.println("fullnameInString = " + fullnameInString);

        // Assert full name is Demo user
        Assert.assertEquals(fullnameInString, "Demo user");

        //Print out Balance value
        WebElement balance = driver.findElement(By.xpath("//*[starts-with(@class, 'balance-value')]"));
        String balanceInText = balance.getText();
        System.out.println("balanceInText = " + balanceInText);

        // Assert balance is "7.800 IU"
        Assert.assertEquals(balanceInText, "7.800 IU");

        // Quit the session/driver
        driver.quit();

    }

    @Test
    public void negativeEmptyPassword() throws InterruptedException {
        // Create an instance of MSEdge or FirefoxDriver;
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        // get the link 'https://demo.cyclos.org/ui/login' and then wait 3 seconds
        driver.get("https://demo.cyclos.org/ui/login");
        Thread.sleep(3000);

        /*
         Locate element:
          -username
          -submit
         */
        WebElement username = driver.findElement(By.xpath("//input[@formcontrolname='principal']"));
        WebElement submit = driver.findElement((By.xpath("//button[@type='button' and span[contains(text(), 'Submit')]]")));


        // Try to login with no password
        // Send "demo" to username field and click
        username.sendKeys("demo");
        submit.click();
        Thread.sleep(2000);

        // Assert error message for password: Expected --> "This field is required"
        String errorMessageText = driver.findElement(By.xpath("//div[@class='invalid-feedback']")).getText();
        System.out.println("errorMessageText = " + errorMessageText);
        Assert.assertEquals(errorMessageText, "This field is required");

        // Assert that current URL is still --> "https://demo.cyclos.org/ui/login"
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://demo.cyclos.org/ui/login");

        // Assert that page title is "Login - Cyclos"
        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);
        Assert.assertEquals(currentTitle, "Login - Cyclos");


        // Quit driver
        driver.quit();

    }
}
