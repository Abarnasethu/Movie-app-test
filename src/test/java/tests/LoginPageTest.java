package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;


public class LoginPageTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);

    }

    @Test
    public void testLoginPageUI() {
        assert loginPage.getLogo().isDisplayed();
        assert loginPage.getHeading().getText().equals("Login");
        assert loginPage.getUsernameLabel().getText().equals("USERNAME");
        assert loginPage.getPasswordLabel().getText().equals("PASSWORD");
        assert loginPage.getLoginButton().isDisplayed();
    }

    @Test
    public void testLoginWithEmptyFields() {
        loginPage.login("", "");
        // Assert error message or page behavior after login
    }

    @Test
    public void testLoginWithValidCredentials() {
        loginPage.login("rahul", "rahul@2021");
        // Assert successful login
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
