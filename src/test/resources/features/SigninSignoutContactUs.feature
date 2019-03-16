Feature: Shopping cart on an e-commerce website

Background: 
    When I open automationpractice website
    
  @SmokeTest 
  Scenario Outline: Sign in and sign out
    And I sign in using "<user>" login details
    Then I sign out
Examples:
 |user|
 |Veeresh|
 
  @RegressionTest
  Scenario: Contact Us
    Then I perform contact us actions
 