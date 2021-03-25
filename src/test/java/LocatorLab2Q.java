import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocatorLab2Q {
    WebDriver driver;

    @Test
    public void singleInputField() throws InterruptedException {
        // Create an instance of ChromeDriver;
        // WebDriverManager.edgedriver().setup();
        driver = new SafariDriver();

        // Navigate to "https://www.seleniumeasy.com/test/basic-first-form-demo.html"
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

        /*
         Locate elements:
          -Enter message input field,
          -Show message button,
          -Your message field
         */
        Thread.sleep(5000);
        WebElement enterMessage = driver.findElement(By.xpath("//input[@placeholder='Please enter your Message']"));
        WebElement showMessage = driver.findElement(By.xpath("//button[@onclick='showInput();']"));
//        WebElement echo = driver.findElement(By.id("display"));
        WebElement echo = driver.findElement(By.cssSelector("#display"));

        // Send "hello world" to enterMessage field and click 'showMessage' button
        enterMessage.sendKeys("hello world");
        showMessage.click();
        Thread.sleep(5000);


        // Print out echo message
        // Assert that echo message is same with 'hello world'
        String text = echo.getText();
        System.out.println("text = " + text);
        Assert.assertEquals("hello world", text);

        // Quit driver
        driver.quit();


    }


    @Test
    public void twoInputFields() throws InterruptedException {
        // Create an instance of Edge or FireFox driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Get the link "https://www.seleniumeasy.com/test/basic-first-form-demo.html"
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

        /*
         Locate elements:
          -Enter a,
          -Enter b,
          -Get total,
          -Total value (next to the a + b = )
         */

        Thread.sleep(4000);

        WebElement aValue = driver.findElement(By.xpath("//input[@id='sum1']"));
        WebElement bValue = driver.findElement(By.id("sum2"));
        WebElement getTotal = driver.findElement(By.xpath("//button[@onclick='return total()']"));
        WebElement total = driver.findElement(By.xpath("//span[@id='displayvalue']"));


        // Do the maths:
        // a =5;
        // b =10;
        // Print out total

        int a = 5;
        int b = 10;
        aValue.sendKeys(String.valueOf(a));
        bValue.sendKeys(String.valueOf(b));
        getTotal.click();
        String actualTotal = total.getText();
        String expectedTotal = String.valueOf(a + b);


        // Assert that expectedTotal and actualTotal equals
        Assert.assertEquals(actualTotal, "14");

        //Quit driver
        Thread.sleep(5000);
        driver.quit();

    }
}
