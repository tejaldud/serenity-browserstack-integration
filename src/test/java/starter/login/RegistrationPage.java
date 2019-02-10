package starter.login;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationPage extends PageObject {

    private By title = By.cssSelector("#titleCode");
    private By firstName = By.cssSelector("#firstName");
    private By lastName = By.cssSelector("#lastName");
    private By emailAdd = By.cssSelector("#username");
    private By password = By.cssSelector("#password");
    private By confirmPassword = By.cssSelector("#password2");
    private By DOB_Year = By.cssSelector("#year");
    private By DOB_Month = By.cssSelector("#month");
    private By DOB_Day = By.cssSelector("#day");
    private By privacyPolicyCheckBox1 = By.cssSelector("input[name='privacyPolicyAgreement']");
    private By privacyPolicyCheckBox2 = By.cssSelector("#partnersPrivacyPolicyAgreement + span");
    private By createAnAccountButton = By.xpath("//button[@class='button']/span[text()='Create an account']");

    private By SuccesMessage = By.cssSelector("#globalMessages .alert-box.success > span");

    public void enterDetails(Map<String, String> datatable) {
        Select select = new Select(find(By.id("titleCode")));
        select.selectByValue(datatable.get("Title").toLowerCase());
        find(firstName).sendKeys(datatable.get("First Name"));
        find(lastName).sendKeys(datatable.get("Last Name"));
        String[] emails = datatable.get("Email").split("@");
        String email=emails[0]+RandomStringUtils.randomAlphabetic(3).toLowerCase()+"@"+emails[1];
        find(emailAdd).sendKeys(email);
        find(password).sendKeys(datatable.get("Password"));
        find(confirmPassword).sendKeys(datatable.get("Confirm password"));
        Select dobDay = new Select(find(By.id("day")));
        dobDay.selectByValue("20");
        new Select(find(By.id("month"))).selectByValue("5");
        new Select(find(By.id("year"))).selectByValue("1999");

    }

    public void clickPrivacyPolicyCheckBoxes() {
        getDriver().manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        WebElementFacade webElementFacade1 = find(privacyPolicyCheckBox1);
        getDriver().manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("scroll(0, 1000)");
        jse.executeScript("arguments[0].click();", webElementFacade1);
        jse.executeScript("arguments[0].click();", find(privacyPolicyCheckBox2));

//        WebElement element = getDriver().findElement(privacyPolicyCheckBox1);
//
//        Actions actions = new Actions(getDriver());
//        actions.moveToElement(element).click().perform();



//
//        WebElementFacade webElementFacade1 = find(privacyPolicyCheckBox1);
//
//        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
//
//        jse.executeScript("arguments[0].scrollIntoView()", webElementFacade1);
//
//        JavascriptExecutor js = (JavascriptExecutor)getDriver();
//        js.executeScript("scroll(0, 500)");
//        js.executeScript("return arguments[0].scrollIntoView(true);", webElementFacade1.getWrappedElement());
       // webElementFacade1.click();

//        WebElementFacade webElementFacade2 = find(privacyPolicyCheckBox2);
//        ((JavascriptExecutor) this.getDriver()).executeScript("return arguments[0].scrollIntoView(true);", webElementFacade2.getWrappedElement());
//        webElementFacade2.click();

//        WebElement element1 = getDriver().findElement(privacyPolicyCheckBox2);
//
//        Actions actions1 = new Actions(getDriver());
//        actions1.moveToElement(element).click().perform();
//        find(privacyPolicyCheckBox1).click();
//        find(privacyPolicyCheckBox2).click();
    }

    public void clickOnCreateAnAccountButton() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("arguments[0].click();", find(createAnAccountButton));

       // find(createAnAccountButton).click();
        Thread.sleep(2000);

    }

    public void verifySuccessMessageDisplayed(String msg) {
        assertThat(find(SuccesMessage).getText()).withFailMessage("Unable to create account").isEqualTo(msg);
    }
}
