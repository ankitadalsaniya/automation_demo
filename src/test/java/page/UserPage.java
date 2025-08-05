package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.TimeoutException;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class UserPage {

    private WebDriver driver;
    WebDriverWait wait;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    // ============================  SIGN UP LOCATORS ============================   
    private By createAnAccountLink = By.linkText("Create an Account");
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By emailField = By.id("email_address");
    private By passwordField = By.id("password");
    private By confirmPasswordField = By.id("password-confirmation");
    private By createAccountButton = By.cssSelector("button[title='Create an Account']");

    // ============================  SIGN UP ASSERTION LOCATORS ============================   
    private By myAccountText = By.cssSelector("div.message-success.success.message");
    
    // ============================  SIGN OUT LOCATORS ============================
    private By dropDownField = By.cssSelector("button[data-action='customer-menu-toggle']");
    private By signOutField = By.linkText("Sign Out");

    // ============================  SIGN IN or LOGIN  LOCATORS ============================   
    private By signInField = By.linkText("Sign In");
    private By signInEmail = By.id("email");
    private By signInPassword = By.id("pass");
    private By signInButton = By.id("send2");
    private By signInAssertion = By.cssSelector("div.panel.header");

    private By dismiss = By.id("dismiss-button");



    public void create_an_account() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(createAnAccountLink));
        link.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));

    }

    public void sign_up_details(String firstName, String lastName, String email, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(firstNameField)).sendKeys(firstName);
        wait.until(ExpectedConditions.elementToBeClickable(lastNameField)).sendKeys(lastName);
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(confirmPasswordField)).sendKeys(password);

    }

    public void sign_up_button() {
        WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        createButton.click();
    }

    public void sign_up_assertion(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountText));
            boolean success = driver.getPageSource().contains("Thank you for registering") ||
                            driver.getPageSource().contains("My Account");
            assert success : " Registration failed!";
            System.out.println(" Successfully registered!");
        } catch (Exception e) {
            e.printStackTrace();
            assert false : " Registration failed due to exception: " + e.getMessage();
        }
    }

    public void log_out(){
        WebElement toggleButton = wait.until(ExpectedConditions.elementToBeClickable(dropDownField));
        toggleButton.click();
        WebElement signOut = wait.until(ExpectedConditions.elementToBeClickable(signOutField));
        signOut.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInField));
    }

    public void sign_in(){
        WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(signInField));
        signIn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInEmail));
    }

    public void sign_in_password(String email, String password){
        driver.findElement(signInEmail).sendKeys(email);
        driver.findElement(signInPassword).sendKeys(password);
    }

    public void sign_in_button(){
         driver.findElement(signInButton).click();
    }

    public void sign_in_assertion(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInAssertion));
        boolean loggedIn = driver.getPageSource().contains("Welcome, Test User!") ||
                           driver.getPageSource().contains("My Account");
        assert loggedIn : "Login failed!";
    }
}