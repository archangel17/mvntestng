package pages;

import lib.Logger;
import lib.WebController;

public class Homepage extends base_page {
	
	String url = "http://www.rbc.com";
	
	String signin = "//*[@id='layout-column-left']/div[1]/div/p[1]/span/span/a";
	
	
	public Homepage(WebController browser, Logger log) {
		super.browser = browser;
		super.log = log;
		super.url = this.url;
	}
	
	public boolean gotopage() {
		try {
			browser.navigateToPage(url);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean click_on_signin() {
		try {
			log.info("Click on signin");
			browser.click(signin);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		return true;
	}
}
