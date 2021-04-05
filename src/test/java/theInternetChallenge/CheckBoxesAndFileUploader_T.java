package theInternetChallenge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckBoxesAndFileUploader_T {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkBoxes() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(3000);
        WebElement checkBox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        checkBox1.click();
        Assert.assertTrue(checkBox1.isSelected());          // if selected or not
        WebElement checkBox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
        Assert.assertTrue(checkBox2.isEnabled());           // if it is enabled or not
        checkBox2.click();
        Thread.sleep(5000);
    }

    @Test
    public void fileUpload() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement uploading = driver.findElement(By.id("file-upload"));
        uploading.sendKeys("C:\\Users\\tufan\\IdeaProjects\\src\\test\\java\\Challenge1\\img.png");
        Thread.sleep(3000);
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        WebElement check = driver.findElement(By.tagName("h3"));
        String message = check.getText();
        System.out.println("message = " + message);
        Assert.assertEquals(message,"File Uploaded!");
        Thread.sleep(5000);

    }
}