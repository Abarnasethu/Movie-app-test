package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopularPage {

    private WebDriver driver;
    private By movieList = By.className("search-movies-container");
    public PopularPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public boolean areMoviesDisplayed() {
        return driver.findElements(movieList).size() > 0;  // Check if there are any movie items in the list
    }
}
