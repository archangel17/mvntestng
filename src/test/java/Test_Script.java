import java.io.PrintWriter;
import java.io.StringWriter;

import org.testng.Assert;
import org.testng.annotations.*;

import org.testng.asserts.*;
import lib.*;
import pages.Homepage;

public class Test_Script extends base_script {
	
	@BeforeMethod
	public void init() {
		super.init(this.getClass().getName());
	}
	
	@AfterMethod
	public void cleanup() {
		super.cleanup();
	}
	
	
	@Test()
	public void script() {
			try {
				Homepage page_home = new Homepage(browser, log);
				page_home.gotopage();
				page_home.verify_page();
				page_home.click_on_signin();
			
				Assert.assertTrue(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Assert.assertTrue(false);
			}
	}
}
