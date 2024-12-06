package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    // Locators
    By logo = By.className("login-website-logo");
    By heading = By.xpath("//h1[text()='Login']");
    By usernameLabel = By.xpath("//label[text()='USERNAME']");
    By passwordLabel = By.xpath("//label[text()='PASSWORD']");
    By loginButton = By.className("login-button");
    By usernameInput = By.id("usernameInput");
    By passwordInput = By.id("passwordInput");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogo() {

        return driver.findElement(logo);
    }

    public WebElement getHeading()
    {

        return driver.findElement(heading);
    }

    public WebElement getUsernameLabel() {

        return driver.findElement(usernameLabel);
    }

    public WebElement getPasswordLabel() {

        return driver.findElement(passwordLabel);
    }

    public WebElement getLoginButton()
    {

        return driver.findElement(loginButton);
    }

    public WebElement getUsernameInput()
    {
        return driver.findElement(usernameInput);
    }

    public WebElement getPasswordInput() {

        return driver.findElement(passwordInput);
    }

    public void login(String username, String password) {
        getUsernameInput().sendKeys(username);
        getPasswordInput().sendKeys(password);
        getLoginButton().click();
    }


}
