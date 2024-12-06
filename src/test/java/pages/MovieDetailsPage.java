package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MovieDetailsPage {
    WebDriver driver;


    // Locators for the Movie Details Page
    private By firstMovie = By.xpath("(//img)[4]");
    private By movieTitle = By.className("movie-title");
    private By movieDiscription = By.className("movie-overview");
    private By popMovie = By.xpath("(//img)[3]");


    // Constructor
    public MovieDetailsPage(WebDriver driver) {

        this.driver = driver;
    }

    public void homePageMovie() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Duration instead of an int
        WebElement firstMoviee = wait.until(ExpectedConditions.elementToBeClickable(firstMovie));

        // Click the movie
        firstMoviee.click();
    }

    public String getHomeMovieTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(movieTitle));
        return titleElement.getText();

    }
    public String getHomeMovieDetails(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement disElement = wait.until(ExpectedConditions.visibilityOfElementLocated(movieDiscription));
        return disElement.getText();
    }
    public void populerPageMovie() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Duration instead of an int
        WebElement PopulerMoviee = wait.until(ExpectedConditions.elementToBeClickable(popMovie));

        PopulerMoviee.click();
    }
    public String getPopulerMovieTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement titlElement = wait.until(ExpectedConditions.visibilityOfElementLocated(movieTitle));

        return titlElement.getText() ;

    }
    public String getPopulerMovieDetails(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dislement = wait.until(ExpectedConditions.visibilityOfElementLocated(movieDiscription));
        return dislement.getText();
    }
}