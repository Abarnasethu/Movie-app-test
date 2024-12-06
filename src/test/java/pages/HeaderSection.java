package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HeaderSection {
    WebDriver driver;

    By websiteLogo = By.className("website-logo");
    By navElementHome = By.xpath("//*[text()='Home']");
    By navElementPopular = By.xpath("//*[text()='Popular']");
    By navElementAccount = By.className("avatar-button");


    public HeaderSection(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isHomeDisplayed() {
        return driver.findElement(navElementHome).isDisplayed();
    }

    public boolean isPopulerDisplayed() {
        return driver.findElement(navElementPopular).isDisplayed();
    }

    public boolean isAccountDisplayed() {
        return driver.findElement(navElementAccount).isDisplayed();
    }


    }



