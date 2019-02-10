package starter.login;

import com.google.common.base.Function;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import starter.SerenityPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@DefaultUrl("https://www.fitflop.com/uk/en/login/auth#/")
public class HomePage extends SerenityPage {

    @FindBy(css = "button[value='Search']")
    WebElementFacade searchButton;

    private final static String SHOP_SUGGESTION = "//div[@class='as-suggestion' and contains(.,'%s')]";

    public void enterSearchTerms(String keyword) {
        $("#features-query").type(keyword);
        withTimeoutOf(10, TimeUnit.SECONDS).waitForPresenceOf(By.xpath(String.format(SHOP_SUGGESTION, keyword.toLowerCase())));
        waitForKeywordToBeUpdatedTo(keyword);
    }

    private void waitForKeywordToBeUpdatedTo(String keyword) {
        waitForCondition()
                .withTimeout(5, TimeUnit.SECONDS)
                .pollingEvery(250, TimeUnit.MILLISECONDS)
                .until(keywordFieldIsUpdatedTo(keyword));
    }

    private Function<? super WebDriver, Boolean> keywordFieldIsUpdatedTo(String keyword) {
        return webDriver -> $("#features-query").getValue().equalsIgnoreCase(keyword);
    }

    public void search() {
        searchButton.click();
    }

    public void searchForShopCalled(String shopName) {
        enterSearchTerms(shopName);
        $(String.format(SHOP_SUGGESTION, shopName)).click();
    }

    public void dismissLocationMessage() {
        if (!findAll(By.cssSelector("input[value='Okay']")).isEmpty()) {
            find(By.cssSelector("input[value='Okay']")).click();
        }
    }

    @FindBy(xpath = ".//div[@id='UmaThurmanBarComponent']")
    private WebElement header;

    @FindBy(xpath = "//div[@class='menu']/ul/li")
    private WebElement menuBar;

    @FindBy(className = "product-list__slider-image")
    private List<WebElement> products;

    @FindBy(xpath = "//ul[@class='menu-level-three']/li")
    List<WebElement> umaCategary;
    private List<WebElementFacade> webElementFacades;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(css = "span.form-checkbox__checkbox")
    WebElement choiceWomen;

    @FindBy(css = "button.button--stretch")
    WebElement btnContinue;

    public void getAllTabs(List<String> categories) {
        List<String> categaries = new ArrayList<>();
        webElementFacades = findAll(By.cssSelector("ul.menu-level-one>li>a"));
        webElementFacades.forEach(
                webElementFacade -> {
                    System.out.println("cate" + webElementFacade.getText());
                    categaries.add(webElementFacade.getText());
                }
        );

    }

    public void clickOnCategory(String category) {
        find(By.cssSelector("a[data-titleen='" + category + "']")).click();
    }

    public void clickOnSubCategory(String subcat) {
        find(By.cssSelector("data-titleen='" + subcat + "']")).click();
        //umaCategary.get(0).click();
    }

    public void clickOnProduct() {
        clickOn(products.get(1));
        List<WebElementFacade> all = findAll(By.cssSelector("a[title='Black']"));
    }

    public void selectColorAndSizeAndAddProduct(String color, String size) {
        WebElement webElementColor = find(By.cssSelector("a[title='" + color + "']"));
        webElementColor.click();
        List<WebElementFacade> sizes = findAll(By.cssSelector("li.pdp__size-selector-item"));
        for (WebElementFacade webElementFacadeSize : sizes
        ) {
            if (webElementFacadeSize.getText().equalsIgnoreCase(size)) {
                webElementFacadeSize.click();
                break;
            }
        }
        clickOn(find(By.cssSelector("span.pdp__add-to-bag-button-text")));
    }

    public void goToCart() throws InterruptedException {
        WebElementFacade button = find(By.xpath("//button[@class='nav-btn nav-btn__bag ']"));
        // WebElementFacade webElementFacades = find(By.xpath("//span[@class='nav-btn__label-inner']/span[text()='Bag']"));
        button.click();
        button.click();
        Thread.sleep(2000);
    }

    public void goToCheckout() {
        find(By.cssSelector("button.cart-order-summary__cta-btn")).click();
    }

    public void selectGuestCheckout() {
        find(By.cssSelector("div.section-option__content")).click();
    }

    public void enterDetailsAndContinue() throws InterruptedException {
        email.sendKeys("tejal.dud88@gmail.com");
        choiceWomen.click();
        btnContinue.click();

    }
}
