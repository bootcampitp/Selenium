
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class UgurSelenium {

    @Test
    public void get() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Dimension dim = new Dimension(800, 600);
        driver.manage().window().setSize(dim);
        driver.navigate().to("https://www.amazon.com/"); // doesnt wait for loading the page
        driver.navigate().back();
        driver.get("https://www.amazon.com/");// waits for loading the page
//        driver.quit();// butun browserlari kapatiyor
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
//        driver.findElement(By.linkText());  //??
//partialLinkText
//        driver.findElement(By.partialLinkText());   // ???

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
        //  Attribute&Value	//tagName[@AttributeName=‘AttributeValue’]
//        String str=driver.findElement(By.xpath("//label[@for='RESULT_TextField-2']")).getText();
//
//        driver.findElement(By.xpath("//input[@name='RESULT_TextField-2']")).sendKeys("Surname");
        WebElement line = driver.findElement(By.xpath("//div[@itemprop='description articleBody']"));
        String str = line.getText();
        System.out.println(str);
        Assert.assertEquals(str, "This is a sample text in the Page One.");
//        System.out.println(driver.findElement(By.xpath("//div[@itemprop='description articleBody']")).getText());
        System.out.println(str);

//        Visible Text	// tagname[text()=‘full text’]
        System.out.println(driver.findElement(By.xpath("//h2[text()='Text Area Field Two']")).getText());

//        Partial visible text	//TagName[contains(text(),‘part of exact text’)]
        System.out.println(driver.findElement(By.xpath("//h2[contains(text(),' Two')]")).getText());

//        Start With	//TagName[starts-with(@Attribute, ‘value’)]
        System.out.println("Starts With " + driver.findElement(By.xpath("//*[starts-with(@id,'tex')]")).getText());

//        Ends With	//TagName[ends-with(@Attribute, ‘value’)]   ??


//        Contains	//TagName[contains(@Attribute, ‘value’)]
        System.out.println("contains = " + driver.findElement(By.xpath("//input[contains(@id,'xtbo')]")).getText());

//        Index	(//a[contains(text(),'Dynamic')])[2]

        System.out.println("Index = " + driver.findElement(By.xpath("(//div[@class='widget-content'])[14]")).getText());


        driver.quit();
    }

    @Test
    public void css() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
//        Dimension dim=new Dimension(600,800);
//        driver.manage().window().setSize(dim);
//        driver.findElement(By.xpath("//*[@type='email']")).sendKeys("Hello");
// CSS	tagName[AttributeName=‘AttributeValue’]
//        driver.findElement(By.cssSelector(" input[type='email']")).sendKeys("Merhaba");
        WebElement email = driver.findElement(By.cssSelector(" input[type='email']"));
        email.sendKeys("Ali@hotmail.com");

//  id	TagName#idValue
        WebElement name = driver.findElement(By.cssSelector("input#userName"));
        name.sendKeys("Ahmet");

//  JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,200)", "");
//       Thread.sleep(2000);

//  Class	TagName.classValue
        WebElement submitButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
        js.executeScript("arguments[0].scrollIntoView();", submitButton);
//        submitButton.click();

//    STARTING WITH	TagName[attribute^=‘value’]
//    ENDING WITH	TagName[attribute$=‘value’]
        WebElement adress = driver.findElement(By.cssSelector("textarea[id^='permanentA']"));
        adress.sendKeys("Sheffield");

        WebElement adressBox = driver.findElement(By.cssSelector("textarea[id$='rentAddress']"));
        adressBox.sendKeys("United Kingdom");

//CONTAINS	TagName[attribute*=‘value’]
        WebElement currentAdress = driver.findElement(By.cssSelector("*[placeholder*='ent Add']"));
        currentAdress.sendKeys("Glasgow Rangers");

        submitButton.click();


    }


    @Test
    public void action() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/resizable");
        driver.manage().window().maximize();

        Actions action = new Actions(driver);
        WebElement el = driver.findElement(By.cssSelector("span.react-resizable-handle.react-resizable-handle-se"));
        action.dragAndDropBy(el, 20, 40).perform();
        Thread.sleep(3000);
        action.clickAndHold(el).moveToElement(el, 50, 30).release().perform();
        Thread.sleep(3000);
        driver.get("https://demoqa.com/droppable");
        WebElement dragable = driver.findElement(By.id("draggable"));
        WebElement droppingpoint = driver.findElement(By.id("droppable"));
        action.dragAndDrop(dragable, droppingpoint).perform();
//        action.clickAndHold(dragable).moveToElement(droppingpoint).release().perform();
        driver.get("https://demoqa.com/slider");
        WebElement slider = driver.findElement(By.cssSelector(".range-slider.range-slider--primary"));
        action.dragAndDropBy(slider, 30, 0);

        for (int i = 0; i < 21; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }

// Linktext  +JSE
        driver.get("https://demoqa.com/broken");
        Thread.sleep(2000);
        WebElement link = driver.findElement(By.linkText("Click Here for Valid Link"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(0,50);");
        //        link.click();
// Broken Link
        WebElement Element = driver.findElement(By.partialLinkText(" Broken Link"));
        jse.executeScript("arguments[0].scrollIntoView();", Element);
        String url = Element.getAttribute("href");
        System.out.println(Element.getText());
        verifyLinks(url);
// Waits
//        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
//        WebDriverWait explicit=new WebDriverWait(driver,5);
//        explicit.until(ExpectedConditions.elementToBeClickable(Element));
//Iframes
        driver.get("https://demoqa.com/frames");
//        driver.switchTo().frame("frame1");
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        driver.switchTo().defaultContent();
        WebElement tabs = driver.findElement(By.xpath("//*[text()='Browser Windows']"));
        jse.executeScript("arguments[0].scrollIntoView();", tabs);
        tabs.click();
        WebElement tabbutton = driver.findElement(By.cssSelector("#tabButton"));
        tabbutton.click();
        tabbutton.click();
        WebElement winbutton = driver.findElement(By.cssSelector("#windowButton"));
        winbutton.click();
        winbutton.click();
        String s = driver.getWindowHandle();
        Set<String> list = driver.getWindowHandles();

        System.out.println(s + "  =  " + list.size());

//                driver.quit();

    }

    public static void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);

            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if (httpURLConnect.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + "is a broken link");
            }

            //Fetching and Printing the response code obtained
            else {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
            }
        } catch (Exception e) {
        }
    }


}