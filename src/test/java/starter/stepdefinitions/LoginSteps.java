package starter.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import starter.login.LoginPage;

public class LoginSteps {

    LoginPage loginPage;


    @Given("^I navigate to (?:login|Registration) page by clicking on (.+) link$")
    public void iNavigateToLoginPageByClickingOnSignInLink(String link) throws Throwable {
        if (link.equalsIgnoreCase("signIn")) {
            loginPage.clickOnSignInLink();
        } else {
            loginPage.clickOnCreateAccountLink();
        }
    }

    @And("^I click on Sign In$")
    public void iCkickOnSignIn() {
        loginPage.clickOnSignIn();
    }
    @Given("^I enter (.+) and (.+) after clicking signIn option$")
    public void iEnterAndAfterClickingSignInOption(String User, String Pswd) throws Throwable {
        loginPage.clickOnSignInOpt();
        loginPage.submitLoginDetails(User, Pswd);
    }
    @When("^I click on Login Button$")
    public void iClickOnLoginButton() throws Throwable {
        loginPage.clickOnsignInButton();
    }
    @Then("^I should be logged in$")
    public void iShouldBeLoggedIn() throws Throwable {
        loginPage.verifyAccountName();
    }

}