package lib;
import org.openqa.selenium.WebDriverException;

public class WebController {
	SeleniumDriver driver;
	Logger log;
	public WebController(Logger log) {
		driver = new SeleniumDriver();
		this.log = log;
		log.info("Driver Initialization");
	}
	
	public boolean navigateToPage(String url) throws Exception {
		if (driver.navigateToURL(url)) {
			log.info("Navigate to URL: " + url);
			return true;
		} else {
			log.error("Failed to navigate to URL: " + url);
			throw new WebDriverException();
		}
	}
	
	public String getUrl() {
		try {
			return driver.getPageUrl();
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean click(String element) throws Exception {
		
		if (driver.click(element)) {
			log.info("Element Clicked");
			return true;
		} else {
			log.error("Failed to click element: " + element);
			throw new WebDriverException();
		}
	}
	
	
	public boolean SendText(String element, String text) {
		if (driver.setText(element, text)) {
			log.info("Text Injected to :" + element);
			log.info("Text value:" + text);
			return true;
		} else {
			log.error("Failed to inject text to  " + element);
			return false;
		}
	}
	
	public String getText(String element) throws Exception {
		String tempValue = driver.getText(element);
		
		if (tempValue != null) {
			log.info("Retrieved Text:  " + tempValue);
		} else {
			log.error("Fail to get Text from " + element);
			throw new Exception();
		} 

		return tempValue;
	}
	
	public boolean close() {
		if (driver.close()) {
			log.info("WebDriver Closed");
		} else {
			log.warn("WebDriver already closed or not instantiated");
		}
		
		return true;
	}
	
}
