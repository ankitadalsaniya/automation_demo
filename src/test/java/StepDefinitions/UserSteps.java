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
            driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        // userPage.create_an_account();
    }

    @When("I enter valid signup details")
    public void i_enter_valid_signup_details() {

        // //  email create as convert time stamp into milli seconds
        email = "testuser" + System.currentTimeMillis() + "@example.com";  
        userPage.sign_up_details("Test","User",email,password);
    }

    @When("I submit the registration form")
    public void i_submit_registration_form() {
        userPage.sign_up_button();
    }

    @Then("I should be registered successfully")
    public void i_should_be_registered_successfully() {
        userPage.sign_up_assertion();
    }

    @When("I logout")
    public void i_logout() {
        userPage.log_out();
    }

    @When("I click on Sign In")
    public void i_click_on_sign_in() {
        userPage.sign_in();
    }

    @When("I enter valid login credentials")
    public void i_enter_valid_login_credentials() {
        userPage.sign_in_password(email,password);
    }

    @When("I submit the login form")
    public void i_submit_the_login_form() {
        userPage.sign_in_button();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        userPage.sign_in_assertion();
    }
}
