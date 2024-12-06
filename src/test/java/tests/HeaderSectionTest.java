package tests;

import pages.HeaderSection;
import pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class HeaderSectionTest {
    WebDriver driver;
    HeaderSection headersection;


    @BeforeClass
    public void setUp() throws InterruptedException {
        // Set up the WebDriver (ChromeDriver in this case)
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        headersection = new HeaderSection(driver);

        LoginPage lp = new LoginPage(driver);
        lp.login("rahul", "rahul@2021");
        driver.manage().window().maximize();
        Thread.sleep(8000);
    }


    @Test
    public void testNavbarElements() {
        // Test if Navbar elements (Home, Popular, Account) are displayed
        Assert.assertTrue(headersection.isHomeDisplayed(), "Home navbar link is not displayed.");
        Assert.assertTrue(headersection.isPopulerDisplayed(), "Popular navbar link is not displayed.");
        Assert.assertTrue(headersection.isAccountDisplayed(), "Account navbar link is not displayed.");
    }

    @Test
    public void testWebsiteLogoDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        Assert.assertTrue(logo.isDisplayed(), "Website logo is not displayed.");
    }
    @Test
    public void testNavigateToPopularPage() {
        // Locate and click on the Popular link in the header using CSS Selector
        WebElement popularLink = driver.findElement(By.xpath("//*[text()='Popular']"));
        popularLink.click();

        // Wait for the page to load and assert that the URL is correct (Popular page)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("popular"));

        // Assert the page URL to confirm navigation
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("popular"), "Not on the Popular page. Current URL: " + currentUrl);
    }

    @Test
    public void testNavigateToAccountPage() {
        // Locate and click on the Account link in the header using XPath
        WebElement accountLink = driver.findElement(By.className("avatar-button"));
        accountLink.click();

        // Wait for the page to load and assert that the URL is correct (Account page)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("account"));

        // Assert the page URL to confirm navigation
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("account"), "Not on the Account page. Current URL: " + currentUrl);
    }
    @AfterClass
    public void tearDown() {
        // Close the browser window
        if (driver != null) {
            driver.quit();
        }
    }




}