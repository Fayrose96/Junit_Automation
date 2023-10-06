import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class TestAutomation {
    public WebDriver driver;

    @BeforeTest
    public void browsersetup() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void VisitSite() {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
    }

    @Test
    public void titleAssertion() {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        String titleActual = driver.getTitle();
        String titleExpected = "Practice webform for learners | Digital Unite";
        Assert.assertEquals(titleActual, titleExpected);
    }

    @Test
    public void gettingTitleImage() {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElements(By.tagName("img")).get(0).isDisplayed();
    }

    @Test
    public void write() {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.id("edit-name")).sendKeys("aria ann");
        driver.findElement(By.id("edit-number")).sendKeys("123654");
        driver.findElement(By.className("ui-checkboxradio-label"));
        driver.findElement(By.id("edit-date")).sendKeys("10/01/2023");
        driver.findElement(By.id("edit-email")).sendKeys("aria@ann.gmail");
        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("i am aria.i love reading fiction");
        WebElement fileInput = driver.findElement(By.id("edit-uploadocument-upload"));
        String filePath = "C:\\Users\\Ashik\\Desktop\\020823.txt"; // Full path to file
        fileInput.sendKeys(filePath);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        WebElement checkbox = driver.findElement(By.xpath("//input[@id='edit-age']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkbox));

        if (!checkbox.isSelected()) {
            js.executeScript("arguments[0].click();", checkbox);
        }

        // Scroll to the submit button
        WebElement submitButton = driver.findElement(By.id("edit-submit"));
        js.executeScript("arguments[0].scrollIntoView();", submitButton);

        // Wait for the submit button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));

        // Click the submit button
        submitButton.click();

        // Wait for the thank you message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title-area")));

        String text = driver.findElement(By.id("title-area")).getText();
        Assert.assertTrue(text.contains("Thank you for your submission!"));
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
