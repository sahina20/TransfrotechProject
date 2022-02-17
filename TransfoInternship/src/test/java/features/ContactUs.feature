#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Contact US 
  User should be able to click on Contact Us link, find Transfotech contact information and send message.

 
  Scenario: Contact Us functionality
    Given user loads  Transfotech application
    When  user clicks on Contact Us link
    Then  user should see Contact information
    And   user should see message form box
    And   user should fill out form and send message
    


 