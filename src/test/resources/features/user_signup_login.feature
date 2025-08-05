Feature: Magento User Signup and Login
@client

  Scenario: User signs up, logs out and logs in again
    Given I launch the Magento application
    When I click on Create an Account
    And I enter valid signup details
    And I submit the registration form
    Then I should be registered successfully
    When I logout
    And I click on Sign In
    And I enter valid login credentials
    And I submit the login form
    Then I should be logged in successfully
