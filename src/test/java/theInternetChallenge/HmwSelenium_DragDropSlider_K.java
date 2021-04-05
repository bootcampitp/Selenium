package theInternetChallenge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

public class HmwSelenium_DragDropSlider_K {

    WebDriver driver;//farkli metodlardan erisebilmek icin

    @BeforeMethod
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    //https://the-internet.herokuapp.com/

    @Test
    public void DragAndDrop_Slider() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().maximize();//browseri tam ekran yap

        Thread.sleep(3000);//3 sn bekle

    //Drag and Drop
        WebElement DragAndDropLink= driver.findElement(By.xpath("//a[text()='Drag and Drop']"));
        DragAndDropLink.click();

        Thread.sleep(3000);//3 sn bekle

        WebElement fieldA= driver.findElement(By.id("column-a"));
        WebElement fieldB= driver.findElement(By.id("column-b"));

        Actions actionDragAndDrop=new Actions(driver);

        for(int i=0; i<2; i++) {
            actionDragAndDrop.clickAndHold(fieldA).moveToElement(fieldB).release().perform();
            Thread.sleep(3000);//3 sn bekle
            actionDragAndDrop.clickAndHold(fieldB).moveToElement(fieldA).release().perform();
            Thread.sleep(3000);//3 sn bekle
        }

        //actionDragAndDrop.dragAndDrop(fieldA,fieldB).perform(); //Second and easy method about drag and drop.
        //Thread.sleep(3000);//3 sn bekle

        driver.navigate().back();
        Thread.sleep(3000);//3 sn bekle


    //Horizontal Slider
        WebElement horizontalSliderLink=driver.findElement(By.xpath("//a[text()='Horizontal Slider']"));
        horizontalSliderLink.click();
        Thread.sleep(3000);//3 sn bekle

        WebElement slider= driver.findElement(By.xpath("//input[@type='range']"));
        WebElement rangeValue = driver.findElement(By.id("range"));

//        while (!rangeValue.getText().equals("5")){
//            slider.sendKeys(Keys.ARROW_RIGHT);
//        }

        for(int i=0; i<9; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
        Thread.sleep(3000);//3 sn bekle
        slider.sendKeys(Keys.ARROW_LEFT);

        //Actions actionSlider=new Actions(driver);
        // actionSlider.clickAndHold(slider).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.RIGHT).sendKeys(Keys.ARROW_RIGHT)
        //      .sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).release().perform();
        //Second method about slider.


       Thread.sleep(3000);//3 sn bekle
        driver.navigate().back();
        Thread.sleep(3000);//3 sn bekle
    }
}
