package lib;
import java.io.*;

public class Logger {
	private boolean debug = false;
	private final String INFO = "INFO-";
	private final String ERR = "ERROR";
	private final String WARN = "WARN-";
	private final String defaultFilename = System.getProperty("user.dir") + "/log.txt";
	private String setFilename = "";
	private String messageFormat = "[%s] - %s";

	private File logfile;
	private FileWriter fw;
	private BufferedWriter bw;
	private PrintWriter out;

	public Logger() {
		//file_init(defaultFilename);
		//logfile = new File(defaultFilename);
	}
	
	public Logger(boolean debug) {
		//file_init(defaultFilename);
		//logfile = new File(defaultFilename);
		this.debug = debug;
	}

	public Logger(String filename, boolean debug) {
		setFilename = filename;
		file_init();
		//logfile = new File(filename);
		this.debug = debug;
	}

	public void file_init() {
		logfile = new File(setFilename);
		try {
			if (!logfile.exists()) {
				logfile.createNewFile();
			}
				fw = new FileWriter(setFilename, true);
				bw = new BufferedWriter(fw);
				out = new PrintWriter(bw);
		} catch (IOException e) {
			System.out.println(msgGen(ERR, "Directory Access is Denied"));
		}
	}

	private String msgGen(String msgType, String message) {
		return String.format(messageFormat, msgType, message);
	}

	public void writetoFile(String msgType, String message) {
		file_init();
		out.println(msgGen(msgType, message));
		close();
		if (debug) {
			System.out.println(msgGen(msgType, message));
		}
	}
	
	public void error(String message) {
		writetoFile(ERR, message);
	}
	
	public void info(String message) {
		writetoFile(INFO, message);
	}
	
	public void warn(String message) {
		writetoFile(WARN, message);
	}
	
	public void close() {
		try {
			out.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
