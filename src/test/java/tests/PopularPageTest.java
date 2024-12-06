package tests;


import pages.LoginPage;
import pages.PopularPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PopularPageTest {

    WebDriver driver;
    PopularPage popularPage;

    @BeforeClass
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();  // You can replace with WebDriverManager for easier driver management
        driver.get("https://qamoviesapp.ccbp.tech/");  // URL of the Popular page
        popularPage = new PopularPage(driver);
        LoginPage lp =new LoginPage (driver);
        lp.login("rahul","rahul@2021");
        Thread.sleep(4000);
    }

    @Test
    public void testPopularPageUI() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Popular']")).click();
        Thread.sleep(4000);
        // Verify if movies are displayed on the Popular page
        Assert.assertTrue(popularPage.areMoviesDisplayed(), "Movies should be displayed on the Popular page.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
