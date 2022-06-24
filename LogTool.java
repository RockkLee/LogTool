import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogTool {
	
	/**
	 * @param logfileName
	 * @param loggerName
	 * @param logLevel
	 * @param logString
	 */
	public static void log (String logfileName, String loggerName, Level logLevel, String logString) {  
	    Logger logger = Logger.getLogger(loggerName);  
	    FileHandler fh;  

	    try {  

	        // This block configure the logger with handler and formatter  
	        fh = new FileHandler(logfileName);  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  

	        // the following statement is used to log any messages  
	        logger.log(logLevel, logString);  

	    } catch (SecurityException e) { 
	    	e.printStackTrace();  
	    	Logger.getLogger("LogTool_exception").log(Level.WARNING, "LogTool錯誤",e); 
	    } catch (IOException e) {  
	        e.printStackTrace();  
	        Logger.getLogger("LogTool_exception").log(Level.WARNING, "LogTool錯誤",e); 
	    }  
	}
	
	
	
	
	
	/**
	 * @param logfileName
	 * @param loggerName
	 * @param logLevel
	 * @param logString
	 * @param e
	 * @throws Throwable 
	 */
	public static void log (String logfileName, String loggerName, Level logLevel, String logString, Throwable e_log){  
	    Logger logger = Logger.getLogger(loggerName);  
	    FileHandler fh;  

	    try {  

	        //configure logger with handler and formatter  
	        fh = new FileHandler(logfileName, true);  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  

	        //record this log  
	        logger.log(logLevel, logString, e_log);

	    }
	    catch (SecurityException e) { 
	    	e.printStackTrace();  
	    	Logger.getLogger("LogTool_exception").log(Level.WARNING, "LogTool錯誤",e); 
	    } 
	    catch (IOException e) {  
	        e.printStackTrace();  
	        Logger.getLogger("LogTool_exception").log(Level.WARNING, "LogTool錯誤",e); 
	    }  
	}
}