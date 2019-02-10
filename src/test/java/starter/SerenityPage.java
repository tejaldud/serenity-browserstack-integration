package starter;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class SerenityPage extends PageObject {
	private WebDriver driver;
	public SerenityPage()
	{

	}

	protected static final Logger LOG = LoggerFactory.getLogger(SerenityPage.class);
	public SerenityPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	protected void sendTextToElement (WebElement element, String text) {
		element(element).clear();
		element(element).sendKeys(text);
	}

	protected void clickButton (WebElement button) {
		element(button).click();
	}

	protected void isElementInitialized (WebElement element) {
		element(element).isDisplayed();
	}

	protected String getTextFromElement (WebElement element) {
		return element(element).getText();
	}

	protected boolean isElementVisible (WebElement element) {
		return element(element).isVisible();
	}

	protected void waitForElement (WebElement element) {
		element(element).waitUntilVisible();
	}

	protected void waitForElement (WebElement element, int second) {
		element(element).withTimeoutOf(second, TimeUnit.SECONDS).waitUntilVisible();
	}

	protected void openDropDownAndSelectOption (WebElement element, String option) {
		element(element).click();
		element.findElement(By.linkText(option)).click();
	}

	protected boolean scrollToElement (WebElement element) {
		try {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	protected void waitForMill (long mill) {
		try {
			Thread.sleep(mill);
		} catch (InterruptedException e) {
			LOG.error("", e);
			Thread.currentThread().interrupt();
		}
	}

	protected void waitForElementToVanish (WebElement element, int second) {
		this.element(element).withTimeoutOf(second, TimeUnit.SECONDS).waitUntilNotVisible();
	}

	protected void selectValueInDropDown (WebElement dropdown, String value) {
		Select select = new Select(dropdown);
		select.selectByValue(value);
	}

}