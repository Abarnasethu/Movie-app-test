package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountPage {
    WebDriver driver;

    By navElementAccount = By.className("avatar-button");
    By userName = By.className("membership-username");
    By passWord =By.className("membership-password");
    By myPlan =By.className("plan-paragraph");
    By logout = By.className("logout-button");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navAccountPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Duration instead of an int
        WebElement firstMoviee = wait.until(ExpectedConditions.elementToBeClickable(navElementAccount));

        // Click the movie
        firstMoviee.click();
    }

    public String AccountUi() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for the title element to be visible
        WebElement un = wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
        WebElement pw = wait.until(ExpectedConditions.visibilityOfElementLocated(passWord));
        WebElement pl = wait.until(ExpectedConditions.visibilityOfElementLocated(myPlan));

        return  un.getText()+ "\n"+  pw.getText() +"\n" +  pl.getText() + "\n";

    }


    public void logoutPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement logoutBtn = driver.findElement(logout);
        logoutBtn.click();


    }

}

