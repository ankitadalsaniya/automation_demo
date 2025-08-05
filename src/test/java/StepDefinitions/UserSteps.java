package steps;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import page.UserPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

public class UserSteps extends Base {
    WebDriver driver;
    WebDriverWait wait;

    private UserPage userPage;

    String email;
    String password = "Test@1234";

    @Before
    public void init() {
        setup();
        driver = Base.driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        userPage = new UserPage(driver);
    }

    @After
    public void cleanup() {
        teardown();
    }

    @Given("I launch the Magento application")
    public void i_launch_the_magento_application() {
        // Already handled by setup()
        driver.get("https://magento.softwaretestingboard.com/");
        wait.until(ExpectedConditions.titleContains("Home Page"));
    }

    @When("I click on Create an Account")
    public void i_click_on_create_account() {
        // WebElement createAccountLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Create an Account")));
        // createAccountLink.click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
        userPage.create_an_account();
    }

    @When("I enter valid signup details")
    public void i_enter_valid_signup_details() {

        // //  email create as convert time stamp into milli seconds
        email = "testuser" + System.currentTimeMillis() + "@example.com";  
        userPage.sign_up_details("Test","User",email,password);
        
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname"))).sendKeys("Test");
        // driver.findElement(By.id("lastname")).sendKeys("User");


        // driver.findElement(By.id("email_address")).sendKeys(email);
        // driver.findElement(By.id("password")).sendKeys(password);
        // driver.findElement(By.id("password-confirmation")).sendKeys(password);
    }

    @When("I submit the registration form")
    public void i_submit_registration_form() {
        userPage.sign_up_button();
        // WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Create an Account']")));
        // createButton.click();
    }

    @Then("I should be registered successfully")
    public void i_should_be_registered_successfully() {
        userPage.sign_up_assertion();
        // try {
        //     wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.message-success.success.message")));
        //     boolean success = driver.getPageSource().contains("Thank you for registering") ||
        //                     driver.getPageSource().contains("My Account");
        //     assert success : " Registration failed!";
        //     System.out.println("✅ Successfully registered!");
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     assert false : " Registration failed due to exception: " + e.getMessage();
        // }
    }

    @When("I logout")
    public void i_logout() {
        userPage.log_out();
        // WebElement toggleButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-action='customer-menu-toggle']")));
        // toggleButton.click();
        // WebElement signOut = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Out")));
        // signOut.click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign In")));
    }

    @When("I click on Sign In")
    public void i_click_on_sign_in() {
        userPage.sign_in();
        // WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign In")));
        // signIn.click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
    }

    @When("I enter valid login credentials")
    public void i_enter_valid_login_credentials() {
        userPage.sign_in_password(email,password);
        // driver.findElement(By.id("email")).sendKeys(email);
        // driver.findElement(By.id("pass")).sendKeys(password);
    }

    @When("I submit the login form")
    public void i_submit_the_login_form() {
        userPage.sign_in_button();
        // driver.findElement(By.id("send2")).click();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.panel.header")));
        // boolean loggedIn = driver.getPageSource().contains("Welcome, Test User!") ||
        //                    driver.getPageSource().contains("My Account");
        // assert loggedIn : "Login failed!";
        userPage.sign_in_assertion();
    }
}


//  DONOT REMOVE BELOW CODE

// package steps;

// import base.Base;
// import io.cucumber.java.After;
// import io.cucumber.java.Before;
// import io.cucumber.java.en.*;
// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;

// import java.time.Duration;
// import java.util.UUID;

// public class UserSteps extends Base {
//     WebDriver driver;
//     WebDriverWait wait;
//     String email;
//     String password = "Test@1234";

//     @Before
//     public void init() {
//         setup();
//         driver = Base.driver;
//         wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//     }

//     @After
//     public void cleanup() {
//         teardown();
//     }

//     @Given("I launch the Magento application")
//     public void i_launch_the_magento_application() {
//         // Already handled by setup()
//         driver.get("https://magento.softwaretestingboard.com/");
//         wait.until(ExpectedConditions.titleContains("Home Page"));
//     }

//     @When("I click on Create an Account")
//     public void i_click_on_create_account() {
//         WebElement createAccountLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Create an Account")));
//         createAccountLink.click();
//         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
//     }

//     @When("I enter valid signup details")
//     public void i_enter_valid_signup_details() {
//         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname"))).sendKeys("Test");
//         driver.findElement(By.id("lastname")).sendKeys("User");

//         //  email create as convert time stamp into milli seconds
//         email = "testuser" + System.currentTimeMillis() + "@example.com";  
//         driver.findElement(By.id("email_address")).sendKeys(email);
//         driver.findElement(By.id("password")).sendKeys(password);
//         driver.findElement(By.id("password-confirmation")).sendKeys(password);
//     }

//     @When("I submit the registration form")
//     public void i_submit_registration_form() {
//         WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Create an Account']")));
//         createButton.click();
//     }

//     // @Then("I should be registered successfully")
//     // public void i_should_be_registered_successfully() {
//     //     wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My Account")));
//     //     boolean success = driver.getPageSource().contains("Thank you for registering") ||
//     //                       driver.getPageSource().contains("My Account");
//     //     assert success : " Registration failed!";
//     // }
//     @Then("I should be registered successfully")
//     public void i_should_be_registered_successfully() {
//         try {
//             wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.message-success.success.message")));
//             boolean success = driver.getPageSource().contains("Thank you for registering") ||
//                             driver.getPageSource().contains("My Account");
//             assert success : " Registration failed!";
//             System.out.println(" Successfully registered!");
//         } catch (Exception e) {
//             e.printStackTrace();
//             assert false : " Registration failed due to exception: " + e.getMessage();
//         }
//     }

//     @When("I logout")
//     public void i_logout() {
//         WebElement toggleButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-action='customer-menu-toggle']")));
//         toggleButton.click();
//         WebElement signOut = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign Out")));
//         signOut.click();
//         wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign In")));
//     }

//     @When("I click on Sign In")
//     public void i_click_on_sign_in() {
//         WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign In")));
//         signIn.click();
//         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
//     }

//     @When("I enter valid login credentials")
//     public void i_enter_valid_login_credentials() {
//         driver.findElement(By.id("email")).sendKeys(email);
//         driver.findElement(By.id("pass")).sendKeys(password);
//     }

//     @When("I submit the login form")
//     public void i_submit_the_login_form() {
//         driver.findElement(By.id("send2")).click();
//     }

//     @Then("I should be logged in successfully")
//     public void i_should_be_logged_in_successfully() {
//         wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.panel.header")));
//         boolean loggedIn = driver.getPageSource().contains("Welcome, Test User!") ||
//                            driver.getPageSource().contains("My Account");
//         assert loggedIn : " Login failed!";
//     }
// }
