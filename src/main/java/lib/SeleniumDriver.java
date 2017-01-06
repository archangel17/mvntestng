package lib;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriver {
	// Error Code
	private final String ERR000 = "WebElement Not Found";

	private static WebDriver driver;

	public SeleniumDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/extlib/chromedriver.exe");
		driver = new ChromeDriver();
	}

	public boolean navigateToURL(String url) {
		try {
			driver.get(url);
		} catch (WebDriverException e) {
			return false;
		}
		return true;
	}

	public boolean click(String xpath) {
		try {
			element(xpath).click();
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean setText(String xpath, String text) {
		try {
			element(xpath).sendKeys(text);
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}

	public String getText(String xpath) {
		try {
			return element(xpath).getText();
		} catch (NullPointerException e) {
			return null;
		}
	}

	private WebElement element(String xpath) {
		try {
			return driver.findElement(By.xpath(xpath));
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public boolean close() {
		try {
			driver.close();
			return true;
		} catch (WebDriverException e) {
			return false;
		}
	}
}
