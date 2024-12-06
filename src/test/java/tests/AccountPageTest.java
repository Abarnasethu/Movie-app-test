package tests;

import pages.AccountPage;
import pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class   AccountPageTest {
    WebDriver driver;
    AccountPage Acc;

    @BeforeClass
    public void setup()  {
        driver = new ChromeDriver();  // You can replace with WebDriverManager for easier driver management
        driver.get("https://qamoviesapp.ccbp.tech/");  // URL of the Popular page
        LoginPage lp = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Acc = new AccountPage(driver);
        lp.login("rahul", "rahul@2021");

    }

    @Test(priority = 1)
    public void testClickFirstMovie() {

        Acc.navAccountPage();

    }

    @Test(priority = 2)
    public void testNavbarElements() {
        String accountText = Acc.AccountUi();
        System.out.println(accountText);
    }


    @Test(priority = 3)
    public void testLogout() {
        Acc.logoutPage();


    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}


