import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocatorLabQ {
    @Test
    public void positive() throws InterruptedException {
        // Create an instance of ChromeDriver;
        WebDriverManager.chromedriver().setup();


        // Navigate to 'https://demo.cyclos.org/ui/login'


        /*
         Locate elements:
          -username,
          -password,
          -submit,
          -Forgot your password?
          -Not a user yet? Register here.
         */
        Thread.sleep(3000);
        WebElement submit = driver.findElement((By.xpath("//button[@type='button' and span[contains(text(), 'Submit')]]")));


        // Assert submit button is enabled
        submit. ?;

        // Send "demo" to username field
        username.sendKeys("demo");


        // Send "1234" to password field


        // Click submit


        // Wait for 5 seconds
        Thread.sleep(5000);


        // Print out full name
        WebElement fullname = driver.findElement(By.xpath( ?));
        String fullnameInString = fullname.getText();

        // Assert full name is 'Demo user'
        Assert.assertEquals( ?, ?);


        //Print out Balance value (Follow same methods as 'Print out full name'


        // Assert balance is "7.800 IU"

        // Quit the session/driver

    }


    @Test
    public void negativeEmptyPassword() throws InterruptedException {
        // Create an instance of MSEdge or FirefoxDriver;


        // get the link 'https://demo.cyclos.org/ui/login' and then wait 3 seconds

        Thread.sleep(3000);

        /*
         Locate element:
          -username
          -submit
         */


        // Try to login with no password
        // Send "demo" to username field and click and then wait 2 seconds


        // Assert error message for password: Expected --> "This field is required"


        // Assert that current URL is still --> "https://demo.cyclos.org/ui/login"


        // Assert that page title is "Login - Cyclos"


        // Quit driver


    }

}
