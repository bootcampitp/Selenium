
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClassExample {
    WebDriver driver;


    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();


//        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver");
//        driver = new EdgeDriver();

//        driver = new SafariDriver();
    }

    @Test
    public void testMethod1() throws Exception {
        String pageTitle;

        driver.get("https://demo.cyclos.org/ui/login");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@formcontrolname='principal']")).sendKeys("demo");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("1234");
        Thread.sleep(3000);

        driver.findElement((By.xpath("//button[@class='btn d-flex justify-content-center align-items-center w-100 h-100 btn-primary']"))).click();
        Thread.sleep(3000);
        //driver.findElement(By.xpath("//label[contains(@class,'uiButtonConfirm')]")).click();
        //driver.findElement(By.className("uiButtonConfirm")).click();
        pageTitle = driver.getTitle();
        //Assert.assertTrue(pageTitle.equals("Log in to Facebook | Facebook"));
        //Assert.assertTrue(pageTitle.equals("Facebook – log in or sign up"));

    }


    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(1000);
        driver.quit();
    }
}
