import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocatorLab2Answers {
    @Test
    public void singleInputField() {
        // Create an instance of ChromeDriver;
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to "https://www.seleniumeasy.com/test/basic-first-form-demo.html"
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

        /*
         Locate elements:
          -Enter messager input field,
          -Show message button,
          -Your message field
         */

        WebElement enterMessage = driver.findElement(By.xpath("//input[@placeholder='Please enter your Message']"));
        WebElement showMessage = driver.findElement(By.xpath("//button[@onclick='showInput();']"));
        WebElement echo = driver.findElement(By.id("display"));

        // Send "hello world" to enterMessage field and click 'showMessage' button
        enterMessage.sendKeys("hello");
        showMessage.click();

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
        WebDriver driver = new ChromeDriver();

        // Get the link "https://www.seleniumeasy.com/test/basic-first-form-demo.html"
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

        /*
         Locate elements:
          -Enter a,
          -Enter b,
          -Get total,
          -Total value (next to the a + b = )
         */

        WebElement enterA = driver.findElement(By.id("sum1"));
        WebElement enterB = driver.findElement(By.id("sum2"));
        WebElement getTotalButton = driver.findElement(By.xpath("//button[@onclick='return total()']"));
        WebElement total = driver.findElement(By.id("displayvalue"));

        // Do the maths:
        // a =5;
        // b =10;
        // Print out total

        int a = 5;
        int b = 10;
        String expectedTotal = String.valueOf(a + b);

        enterA.sendKeys(String.valueOf(a));
        enterB.sendKeys(String.valueOf(b));
        getTotalButton.click();
        String actualTotal = total.getText();
        System.out.println("actualTotal = " + actualTotal);
        Thread.sleep(4000);


        // Assert that expectedTotal and actualTotal equals
        Assert.assertEquals(actualTotal, expectedTotal);

        //Quit driver
        driver.quit();

    }
}
