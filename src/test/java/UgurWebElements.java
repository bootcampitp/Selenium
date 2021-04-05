import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UgurWebElements {
    WebDriver driver;

    @BeforeMethod
    public void method() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void After() throws InterruptedException {
        Thread.sleep(2000);
//        driver.close();
    }

    @Test
    public void elements() throws InterruptedException {
//  CheckBox
//        driver.get("https://demoqa.com/checkbox");
//        WebElement checkbox=driver.findElement(By.cssSelector(".rct-icon.rct-icon-uncheck"));
//        checkbox.click();
//        WebElement uncheckbox=driver.findElement(By.xpath("(//*[@stroke='currentColor'])[49]"));
//        Assert.assertEquals(uncheckbox.isSelected(),true);
//        Thread.sleep(3000);
        driver.get("https://demoqa.com/radio-button");
//        Thread.sleep(2000);
        WebElement yes = driver.findElement(By.cssSelector("#yesRadio"));
//        yes.click();
//        System.out.println(yes.isSelected());


        driver.get("http://omayo.blogspot.com/");
        WebElement boxx = driver.findElement(By.id("checkbox1"));
        if (boxx.isSelected()) {
            boxx.click();
        }


        driver.get("http://omayo.blogspot.com/");
        WebElement checkedOrange = driver.findElement(By.id("checkbox1"));
        System.out.println(checkedOrange.isSelected() + "   Before click");
        checkedOrange.click();
        System.out.println(checkedOrange.isSelected() + " After Click");

        int row = 2;
        int column = 3;
        WebElement tableCell = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[" + row + "]/td[" + column + "]"));
        System.out.println(tableCell.getText());

    }

    @Test
    public void elem() throws InterruptedException {
        // PopUps
//        driver.get("https://www.google.co.uk/");
//        Thread.sleep(2000);
//        WebElement agree=driver.findElement(By.xpath("//*[text()='I agree']"));
//        agree.click();
        //JS PopUps
//        driver.get("https://demoqa.com/alerts");
//        WebElement button1=driver.findElement(By.id("alertButton"));
//        button1.click();
//        Alert alert=driver.switchTo().alert();
//        Thread.sleep(2000);
//        alert.accept();
//        WebElement button3=driver.findElement(By.id("confirmButton"));
//        alert=driver.switchTo().alert();
//        button3.click();
//        Thread.sleep(2000);
//        alert.dismiss();

// Select dropdown
//        driver.get("http://omayo.blogspot.com/");
//        WebElement sel=driver.findElement(By.id("drop1"));
//        Select select=new Select(sel);
//        select.selectByIndex(0);
// MultiSelect
//        WebElement multi=driver.findElement(By.id("multiselect1"));
//        Select multiSelect=new Select(multi);
//        multiSelect.selectByValue("volvox");
//        multiSelect.selectByVisibleText("Hyundai");
// Without Select class
//        List<WebElement> nonSelect=driver.findElements(By.xpath("//*[@id='multiselect1']/option"));
//        nonSelect.get(1).click();
//        nonSelect.get(3).click();

        driver.get("https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");
        Thread.sleep(2000);
        WebElement state = driver.findElement(By.cssSelector(".js-example-basic-multiple.select2-hidden-accessible"));
        Select sel = new Select(state);
        sel.selectByIndex(6);
        sel.selectByValue("CA");
        sel.selectByVisibleText("Arizona");
        List<WebElement> alist = new ArrayList<>();
        alist = driver.findElements(By.xpath("//*[@id='country']/option"));
        System.out.println(alist.size());
        alist.get(3).click();

    }

    @Test
    public void WebTables() {
        driver.get("http://omayo.blogspot.com/");
        WebElement mum = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[4]/td[3]"));
        System.out.println(mum.getText());
        int row = 12;   // row1 column 1.getText().contains("Goztepe")
        // Row 12 Column 7. getTetxt.sout
        int column = 7;
        WebElement Table = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + row + "]/td[" + column + "]"));
        System.out.println(Table.getText());

        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 4; j++) {
                WebElement India = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]"));
                System.out.print(India.getText() + " ");
            }
            System.out.println();
        }

        driver.get("https://demoqa.com/webtables");
        //                                          table             head/body  Row         Column
        WebElement demo = driver.findElement(By.xpath("//div[@class='rt-table']/div[2]/div[3]/div/div[4]"));
        System.out.println(demo.getText());
    }

    @Test
    public void futbol() {
        driver.get("https://www.tff.org/default.aspx?pageID=198");
//        System.out.println(driver.findElement(By.xpath("//div[@id='ctl00_MPane_m_198_1890_ctnr_m_198_1890_Panel1']//tr[10]/td[3]/span")).getText());

        for (int i = 2; i < 22; i++) {

//
//            for(int j=1;j<10;j++){
//                System.out.print(driver.findElement(By.xpath("//div[@id='ctl00_MPane_m_198_1890_ctnr_m_198_1890_Panel1']//tr["+i+"]/td["+j+"]")).getText()+" ");
//            }            System.out.println();
            String teamname = driver.findElement(By.xpath("//div[@id='ctl00_MPane_m_198_1890_ctnr_m_198_1890_Panel1']//tr[" + i + "]/td[" + 1 + "]")).getText();
            if (teamname.contains("GÖZTEPE")) {
                String point = driver.findElement(By.xpath("//div[@id='ctl00_MPane_m_198_1890_ctnr_m_198_1890_Panel1']//tr[" + i + "]/td[" + 9 + "]//span")).getText();
                System.out.println(teamname + " has points = " + point);
            }

        }
    }

    @Test
    public void iframess() throws InterruptedException {
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
        WebElement text1 = driver.findElement(By.id("sampleHeading"));
        System.out.println(text1.getText());
        driver.switchTo().parentFrame();
        WebElement fr2 = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(fr2);
        WebElement text2 = driver.findElement(By.id("sampleHeading"));
        System.out.println(text2.getText());
        driver.switchTo().defaultContent();
        WebElement browserWindows = driver.findElement(By.xpath("//*[text()='Browser Windows']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", browserWindows);

        browserWindows.click();

        WebElement tabButton = driver.findElement(By.id("tabButton"));
        tabButton.click();
        tabButton.click();
//            Thread.sleep(3000);

        WebElement windowButton = driver.findElement(By.id("windowButton"));
        windowButton.click();
        windowButton.click();

        String curentTab = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles.size());
        System.out.println(curentTab);
        int a = 0;
        for (String s : handles) {
            a++;
            if (!s.equals(curentTab)) {
                driver.switchTo().window(s);
                Thread.sleep(2000);
            }
            System.out.println(a + " = " + s);

        }
    }

    @Test
    public void actions() throws InterruptedException {
//        driver.get("http://omayo.blogspot.com/");
//        driver.switchTo().frame("iframe2");
//        driver.findElement(By.xpath("//*[text()='Chapter3']")).click();
//        driver.switchTo().defaultContent();
//        driver.findElement(By.id("ta1")).sendKeys("Hello");

//            driver.get("https://demoqa.com/droppable");
//            WebElement drag=driver.findElement(By.id("draggable"));
//            WebElement drop=driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        Actions action = new Actions(driver);
//            Thread.sleep(2000);
//            action.clickAndHold(drag).moveToElement(drop).release().perform();

//            action.clickAndHold(drag).moveToElement(drop).pause(1000).release().perform();
//            driver.get("https://demoqa.com/buttons");
//            WebElement doubleClick=driver.findElement(By.id("doubleClickBtn"));
//            action.doubleClick(doubleClick).perform();
//            WebElement right=driver.findElement(By.id("rightClickBtn"));
//            action.contextClick(right).perform();

        driver.get("https://demoqa.com/slider");
        WebElement slide = driver.findElement(By.cssSelector(".range-slider.range-slider--primary"));
//            action.moveToElement(slide,20,50).perform();
//            action.clickAndHold(slide).moveToElement(slide,20,30).release().perform();
        Thread.sleep(1000);
        action.dragAndDropBy(slide, 20, 0).perform();
        Thread.sleep(1000);
        for (int i = 0; i < 12; i++) {
            slide.sendKeys(Keys.ARROW_RIGHT);
        }


    }


    @Test
    public void tables() {
        driver.get("http://omayo.blogspot.com/");
        int row = 2;
        int column = 3;
        WebElement tableCell = driver.findElement(By.xpath("//*[@id='table1']/tbody/tr[" + row + "]/td[" + column + "]"));
        System.out.println(tableCell.getText());
//        WebElement sel=driver.findElement(By.id("drop1"));
        WebElement sel = driver.findElement(By.id("multiselect1"));
        Select select = new Select(sel);
//        select.selectByIndex(2);
//        select.selectByIndex(3);
        List<WebElement> drop = driver.findElements(By.xpath("//*[@id='multiselect1']/option"));
        drop.get(0).click();
        drop.get(2).click();

        driver.get("https://www.google.co.uk/");
        driver.findElement(By.xpath("//*[text()='I agree']")).click();


//        driver.get("https://demoqa.com/webtables");
//        WebElement WebTableCell=driver.findElement(By.xpath("((//*[@class='rt-tbody']/div)["+row+"]/div/div)["+column+"]"));
//        System.out.println(WebTableCell.getText());


    }


}