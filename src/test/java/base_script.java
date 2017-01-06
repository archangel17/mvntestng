import java.util.Date;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import lib.Logger;
import lib.WebController;

public abstract class base_script {

	protected static Logger log;
	protected static WebController browser;

	public void init(String filename) {
		long timestamp = System.currentTimeMillis();
		// TODO Auto-generated method stub
		String filepath = System.getProperty("user.dir") + "\\logs\\"+ filename + "_" + String.valueOf(timestamp) + ".txt";
		System.out.println (filepath);
		log = new Logger(filepath, true);
		//log = new Logger(logpath, true);
		browser = new WebController(log);
	}

	public void cleanup() {
		// TODO Auto-generated method stub
		browser.close();
	    log.close();
		
	}
}
