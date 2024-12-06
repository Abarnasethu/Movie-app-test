package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HomePage {
    WebDriver driver;

    // Locators for home page elements
    By headingSection1 = By.xpath("(//h1)[2]");
    By headingSection2 = By.xpath("(//h1)[3]");
    By playButton = By.xpath("//*[text()='Play']"); // Play button
    By trendingMovieItems = By.xpath("//*[text()='Trending Now']");
    By contactUsSection = By.className("contact-us-paragraph");
    By moviesSection =By.cssSelector("a.link-item");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement getHeadingSection1() {
        return driver.findElement(headingSection1);
    }

    public WebElement getHeadingSection2() {
        return driver.findElement(headingSection2);
    }

    public WebElement getMoviesSection() {
        return driver.findElement(moviesSection);
    }
    public boolean areMoviesDisplayed() {
        return getMoviesSection().isDisplayed();
    }
    public WebElement getPlayButton() {
        return driver.findElement(playButton);
    }

    public boolean areMoviesInTrendingSectionDisplayed() {
        List<WebElement> movies = driver.findElements(trendingMovieItems);
        return !movies.isEmpty() && movies.get(0).isDisplayed();  // Check if at least one movie is displayed
    }

    public boolean isContactUsSectionDisplayed() {
        WebElement contactUsElement = driver.findElement(contactUsSection);

        // Scroll into view using JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", contactUsElement);


        // Verify if the Contact Us section is visible
        return contactUsElement.isDisplayed();

    }
}
