package starter.login;

import net.thucydides.core.steps.StepEventBus;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import starter.DetailsDoesNotMatch;
import starter.SerenityPage;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage extends SerenityPage {
    private WebDriver driverInstance;

    public LoginPage(WebDriver driver) {
        super(driver);
        driverInstance = driver;
    }
    private By signInOption = By.cssSelector(".section-option__title");
    private By signInButton = By.xpath("//div[@id='authApp']//button[@class='button button--stretch auth-form__sign-in-btn']/span");
    private By accountName = By.xpath(".//span[@id='accountHeaderId']/span");

    @FindBy(xpath = "//div[@id='authApp']//a[@href='#/login']")
    private WebElement signInLink_Mobile;

    @FindBy(xpath = "//div[@id='authApp']//a[@href='#/register']//div[@class='section-option__arrow']")
    private WebElement createAccountLink;

    private By userInput = By.id("username");
    private By pswdInput = By.id("password");
    public void clickOnSignIn() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        if (isElementVisible(By.cssSelector("button[aria-label='Open Menu']"))) {
//            find(By.cssSelector("button[aria-label='Open Menu']")).click();
//            find(By.xpath("//span[text()='Login']"));
//
//        } else
            find(By.cssSelector("a.nav__account-label--signin")).click();
    }

    public void clickOnSignInLink() {
        signInLink_Mobile.click();
    }

    public void clickOnCreateAccountLink() {
        waitForElement(createAccountLink);
        createAccountLink.click();

    }
    public void clickOnSignInOpt(){
        WaitForVisible(signInOption,30);
        WaitForClickable(signInOption).click();
    }

    public WebElement WaitForVisible(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(getWait(), SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Waiting for element to be visible " + locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private long getWait() {
        return 1;
    }

    public WebElement WaitForClickable(By locator) {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(getWait(), SECONDS)
                .pollingEvery(500, MILLISECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Waiting for element to be clickable " + locator);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public WebElement WaitForVisible(By locator, int timeoutInSecs) {
        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(timeoutInSecs, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Waiting for element to be visible " + locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void submitLoginDetails(String user, String pswd) {
        find(userInput).sendKeys(user);
        find(pswdInput).sendKeys(pswd);

    }

    public void clickOnsignInButton() {
        waitForElement(find(signInButton));
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("arguments[0].click();", find(signInButton));
//        WaitForClickable(signInButton).click();
    }

    public void verifyAccountName() {
        try {
        assertThat(find(accountName).getText()).
                withFailMessage("Unable to login").isNotEmpty();
        }
        catch (Exception e) {
           // StepEventBus.
            throw new DetailsDoesNotMatch("Unable to login", e.getCause());
        }


    }
}
