
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UgurSelenium {

    @Test
    public void get() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com/"); // doesnt wait for loading the page
        driver.navigate().back();
        driver.get("https://www.amazon.com/");// waits for loading the page
        driver.quit();// butun browserlari kapatiyor
//        driver.close();  //sadece acik browser kapatiyor

    }

    @Test
    public void seleniumlocators() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();   // polymorphism
        driver.manage().window().maximize();
//        driver.get("https://www.amazon.com/");
        // id locator
//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium");
//        WebElement searchInputBox=driver.findElement(By.id("twotabsearchtextbox"));
//        searchInputBox.click();
//        searchInputBox.sendKeys("Selenium");
//        driver.findElement(By.id("nav-search-submit-button")).click();
//        WebElement searchButton=driver.findElement(By.id("nav-search-submit-button"));
//        searchButton.click();
// ClassName
        driver.get("http://omayo.blogspot.com/");
//        driver.findElement(By.className("date-header")).click(); //??
//        driver.close();
//name
        String str = driver.findElement(By.name("Cross-Column 2")).getText();
        System.out.println(str);
        Assert.assertTrue(str.contains("www.Selenium143"));
//tagName
//        driver.findElement(By.tagName());
//        driver.findElement(By.tagName("iframe")).click();
// linkText
//        driver.findElement(By.linkText());
//partialLinkText
//        driver.findElement(By.partialLinkText());

    }
//     20:25 te devam


    @Test
    public void xpath() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://omayo.blogspot.com/");
//    Absolute path starts from html and goes to the child one by one
//        html/body/div/div/div/h4/span/input/
//    Relative path starts from any child with //
        // input
        //  Attribute&Value        //tagName[@AttributeName=‘AttributeValue’]
//        String str=driver.findElement(By.xpath("//label[@for='RESULT_TextField-2']")).getText();
//
//        driver.findElement(By.xpath("//input[@name='RESULT_TextField-2']")).sendKeys("Surname");
        WebElement line = driver.findElement(By.xpath("//div[@itemprop='description articleBody']"));
        String str = line.getText();
        System.out.println(str);
        Assert.assertEquals(str, "This is a sample text in the Page One.");
//        System.out.println(driver.findElement(By.xpath("//div[@itemprop='description articleBody']")).getText());
        System.out.println(str);

//        Visible Text        // tagname[text()=‘full text’]
        System.out.println(driver.findElement(By.xpath("//h2[text()='Text Area Field Two']")).getText());

//        Partial visible text        //TagName[contains(text(),‘part of exact text’)]
        System.out.println(driver.findElement(By.xpath("//h2[contains(text(),' Two')]")).getText());

//        Start With        //TagName[starts-with(@Attribute, ‘value’)]
        System.out.println("Starts With " + driver.findElement(By.xpath("//*[starts-with(@id,'tex')]")).getText());

//        Ends With        //TagName[ends-with(@Attribute, ‘value’)]   ??


//        Contains        //TagName[contains(@Attribute, ‘value’)]
        System.out.println("contains = " + driver.findElement(By.xpath("//input[contains(@id,'xtbo')]")).getText());

//        Index        (//a[contains(text(),'Dynamic')])[2]

        System.out.println("Index = " + driver.findElement(By.xpath("(//div[@class='widget-content'])[14]")).getText());


        driver.quit();
    }


}
