@fitflop
@version:Release-1
@version:Sprint-1.2
#@issue:ETSY-101
Feature: User Login


  @issue:ETSY-101 @login @chrome
  Scenario Outline: As a resgistered Fitflop customer I can login with valid users
    Given  I am on sign in page for country <country>
    And I enter <userName> and <password> after clicking signIn option
    When I click on Login Button
    Then I should be logged in

    Examples:
      | country | userName                 | password  |
      | UK      | fitflop_user@yopmail.com | Abcd12345 |

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
