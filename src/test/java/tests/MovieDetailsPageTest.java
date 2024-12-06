
package tests;

import pages.LoginPage;
import pages.MovieDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MovieDetailsPageTest {

    WebDriver driver;
    MovieDetailsPage movieDetailsPage;

    // Setup method to initialize the WebDriver and MovieDetailsPage
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://qamoviesapp.ccbp.tech"); // Replace with the actual URL
        LoginPage lp = new LoginPage(driver);
        lp.login("rahul", "rahul@2021"); // Perform login
        movieDetailsPage = new MovieDetailsPage(driver); // Initialize the MovieDetailsPage object
    }

    @Test(priority = 1)
    public void testClickFirstMovie() {
        movieDetailsPage.homePageMovie();
    }

    @Test(priority = 2)
    public void testHomeMovieTitleAndDescription() {
        // Fetch the movie title and description
        String movieTitle = movieDetailsPage.getHomeMovieTitle();
        String movieDescription = movieDetailsPage.getHomeMovieDetails();

        // Print movie details
        System.out.println("Home movie title: " + movieTitle);
        System.out.println("Home movie description: " + movieDescription);

        Assert.assertNotNull(movieTitle, "Movie title should not be null");
        Assert.assertNotNull(movieDescription, "Movie description should not be null");
        Assert.assertTrue(movieTitle.length() > 0, "Movie title should not be empty");
        Assert.assertTrue(movieDescription.length() > 0, "Movie description should not be empty");
    }

    @Test(priority = 3)
    public void testPopularPageUI() {
        // Navigate to the Popular Movies page
        driver.findElement(By.xpath("//*[text()='Popular']")).click();

        // Wait for the page to load and select the first popular movie
        movieDetailsPage.populerPageMovie();
    }

    @Test(priority = 4)
    public void testPopularMovieTitle() {
        // Fetch and print the title of the first popular movie
        String movieTitle = movieDetailsPage.getPopulerMovieTitle();
        System.out.println("Popular movie title: " + movieTitle);

        // Assert movie title (You can adjust the assertion based on expected title)
        Assert.assertNotNull(movieTitle, "Popular movie title should not be null");
        Assert.assertTrue(movieTitle.length() > 0, "Popular movie title should not be empty");
    }

    @Test(priority = 5)
    public void testPopularMovieDescription() {
        // Fetch and print the description of the first popular movie
        String movieDescription = movieDetailsPage.getPopulerMovieDetails();
        System.out.println("Popular movie description: " + movieDescription);

        // Assert movie description (You can adjust the assertion based on expected description)
        Assert.assertNotNull(movieDescription, "Popular movie description should not be null");
        Assert.assertTrue(movieDescription.length() > 0, "Popular movie description should not be empty");
    }

    @AfterClass
    public void tearDown() {
        // Quit the browser after the test method execution
        driver.quit();
    }
}
