package starter.stepdefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import starter.login.RegistrationPage;

import java.util.Map;

public class RegistrationSteps {

    RegistrationPage registrationPage;

    @And("^I enter the following details on registration Page$")
    public void ienterTheFollowingDetailsOnRegistrationPage(Map<String, String> datatable){
        registrationPage.enterDetails(datatable);
    }
    @And("^I select the privacy policy check boxes$")
    public void iSelectThePrivacyPolicyCheckBoxes(){

        registrationPage.clickPrivacyPolicyCheckBoxes();
    }

    @And("^I click on create an account button$")
    public void iClickOnCreateAnAccountButton() throws InterruptedException {

        registrationPage.clickOnCreateAnAccountButton();
    }

    @Then("^I verify that (.+) message displayed$")
    public void iVerifyThatMyAccountIsCreated(String msg){
        registrationPage.verifySuccessMessageDisplayed(msg);
    }

}