package starter.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import starter.login.HomePage;

import java.util.List;

public class HomePageSteps {

    HomePage homePage;

    @Given("^I am on sign in page for country (.*)$")
    public void initWebPage(String country) {
//        homePage.setDefaultBaseUrl(country);
        homePage.open();
//        homePage.getDriver().manage().window().maximize();
      //  anna.is_on_fit_flop_page();
     //   homePage.isInitialized();
    }


    @And("^I verify the categories displayed on page$")
    public void iVerifyTheCategoriesDisplayedOnPage(List<String> categories) {
        homePage.getAllTabs(categories);
    }

    @And("^I select (.*) category$")
    public void iSelectUMATHURMANCategory(String cat) throws Throwable {
        homePage.clickOnCategory(cat);

    }

    @And("^I want to buy shoes of sub category (.*)$")
    public void iWantToBuyShoesOfSubCategorySneakers(String subcat)  {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickOnSubCategory(subcat);

    }

    @And("^I select product to view$")
    public void iSelectProductToView() throws Throwable {
        homePage.clickOnProduct();

    }

    @And("^I select color \"([^\"]*)\" and size as \"([^\"]*)\" and add product to cart$")
    public void iSelectColorAndSizeAs(String color, String size) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage.selectColorAndSizeAndAddProduct(color,size);
    }

    @And("^I go to cart$")
    public void iGoToCart() throws InterruptedException {
      homePage.goToCart();
    }

    @And("^I click on checkout$")
    public void iClickOnCheckout() throws InterruptedException {

        homePage.goToCheckout();

    }

    @And("^I select guest checkout$")
    public void iSelectGuestCheckout() throws Throwable {
        homePage.selectGuestCheckout();

    }

    @And("^I enter my details and click on continue$")
    public void iEnterMyDetailsAndClickOnContinue() throws Throwable {
        homePage.enterDetailsAndContinue();
    }
}
