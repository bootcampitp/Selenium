import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestStudentRegistrationForm {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void testRegisterStudent() throws InterruptedException {
        driver.navigate().to("https://demoqa.com/automation-practice-form");

        //FirstName
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("John");

        //Lastname
        WebElement lastName = driver.findElement(By.xpath("//*[@placeholder='Last Name']"));
        lastName.sendKeys("Doe");

        //Email
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("johndoe@email.com");

        //Gender
        WebElement genderOther = driver.findElement(By.xpath("(//*[@class='custom-control-label'])[3]"));
        //WebElement genderOther = driver.findElement(By.id("gender-radio-3"));
        genderOther.click();

        //Phone number
        WebElement phoneNumber = driver.findElement(By.id("userNumber"));
        phoneNumber.sendKeys("1231231212");
        Thread.sleep(2000);
        phoneNumber.clear();
        phoneNumber.sendKeys("9879879898");

        //Select date of birth
        WebElement clickDoB = driver.findElement(By.id("dateOfBirthInput"));
        clickDoB.click();

        //Requirement:  Expected = 10 Jan 1990
        //Select month
        By by;
        WebElement selectMonth = driver.findElement(By.className("react-datepicker__month-select"));
        Select select = new Select(selectMonth);
        select.selectByIndex(0); //Selects January
        //select.selectByValue("2");
        //select.selectByVisibleTest("March");

        //Select year
        WebElement selectYear = driver.findElement(By.cssSelector(".react-datepicker__year-select"));
        select = new Select(selectYear);
        select.selectByValue("1990");

        //Select day
        WebElement selectDay = driver.findElement(By.cssSelector(".react-datepicker__day.react-datepicker__day--010"));
        selectDay.click();

        //Assert date
        String actualDate = clickDoB.getAttribute("value");
        String expectedDate = "10 Jan 1990";
        Assert.assertEquals(actualDate, expectedDate);

        //Select subjects
        WebElement subjectArea = driver.findElement(By.id("subjectsInput"));
        subjectArea.sendKeys("Maths");
        subjectArea.sendKeys(Keys.ENTER);

        //Select hobbies
        WebElement hobby = driver.findElement(By.xpath("//*[@id='hobbiesWrapper']//*[contains(text(), 'Reading')]"));
        hobby.click();

        //Upload picture
        WebElement uploadFile = driver.findElement(By.id("uploadPicture"));
        uploadFile.sendKeys("/Users/ismailkaraoz/Documents/QA2/sampleFile.jpeg");

        //Select Address
        WebElement addressArea = driver.findElement(By.id("currentAddress"));
        addressArea.sendKeys("4371  Dog Hill Lane\nBird City\nKS\nKansas\n67731");

        //Selec state
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("Haryana");
        state.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //Select city
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Karnal");
        city.sendKeys(Keys.ENTER);

        //Submit
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();


    }
}
