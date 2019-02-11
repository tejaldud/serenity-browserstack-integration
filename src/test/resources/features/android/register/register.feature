@fitflop
@version:Release-1
@version:Sprint-1.2
#@issue:ETSY-101
Feature:Android User Registration

  @AccountCreation @uk @android
  Scenario Outline: As a new Customer I can Create an Account on Fitflop UK Site
    Given  I am on sign in page for country <country>
#    And I click on Sign In
    And I navigate to Registration page by clicking on Register link
    And I enter the following details on registration Page
      | Title            | Mr                       |
      | First Name       | Test                     |
      | Last Name        | User                     |
      | Email            | tejalatfitflop@yopmail.com |
      | Password         | Abcd12345                |
      | Confirm password | Abcd12345                |
      | Date of Birth    | 1999May20                |
    And I select the privacy policy check boxes
    When I click on create an account button
    Then I verify that You've successfully created an account! message displayed
    Examples:
      | country |
      | UK      |


#
#  @AccountCreation @uk @w-chrome
#  Scenario Outline: As a new Customer I can Create an Account on Fitflop UK Site
#    Given  I am on home page for country <country>
#    And I click on Sign In
#    And I navigate to Registration page by clicking on Register link
#    And I enter the following details on registration Page
#      | Title            | Mr                          |
#      | First Name       | Test                        |
#      | Last Name        | User                        |
#      | Email            | user_fitflop2@yopmail.com |
#      | Password         | Abcd12345                   |
#      | Confirm password | Abcd12345                   |
#      | Date of Birth    | 1999May20                   |
#    And I select the privacy policy check boxes
#    When I click on create an account button
#    Then I verify that You've successfully created an account! message displayed
#    Examples:
#      | country |
#      | UK      |
