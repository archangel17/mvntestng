package pages;

import lib.Logger;
import lib.WebController;

public abstract class base_page {
	
	String url;
	
	protected static WebController browser;
	protected static Logger log;
	
	public boolean verify_page() {
		log.info("Verify URL to match: " + url);
		try {
		String current_page = browser.getUrl();
		if (current_page.indexOf(url) == 0) {
			return true;
		} else {

			log.warn("Failed to match URL. Expected: " + url + "; Actual: " + current_page);
			return false;
		}
		} catch (NullPointerException e) {
			log.error("Failed to retrieve URL");
			return false;
		}
	}
}
