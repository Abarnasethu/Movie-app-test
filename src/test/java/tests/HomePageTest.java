package tests;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class HomePageTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        // Set up the WebDriver (ChromeDriver in this case)
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech"); // Navigate to the Movies App URL
        homePage = new HomePage(driver);
        LoginPage lp = new LoginPage(driver);
        lp.login("rahul", "rahul@2021");
        Thread.sleep(2000);
        driver.manage().window().maximize();
    }

        @Test
         public void testHomePageUI() {
        Assert.assertTrue(homePage.getHeadingSection1().getText().contains("Trending Now"), "Heading for Section 2 is incorrect");
        Assert.assertTrue(homePage.getHeadingSection2().getText().contains("Originals"), "Heading for Section 3 is incorrect");
        }
        @Test
        public void testPlayButtonDisplayed () {
            Assert.assertTrue(homePage.getPlayButton().isDisplayed(), "Play button is not displayed");
        }

        @Test
        public void testMoviesDisplayed () {
            Assert.assertTrue(homePage.areMoviesDisplayed(), "Movies section is not displayed");
        }
        @Test
        public void testContactUsSection () {
            // Scroll to the Contact Us section and verify it's displayed
            Assert.assertTrue(homePage.isContactUsSectionDisplayed(), "Contact Us section is not displayed.");
        }
        @AfterMethod
        public void tearDown () {
            driver.quit();


}}