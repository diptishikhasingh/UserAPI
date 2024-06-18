package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Loggerload {
	
private static Logger log = LogManager.getLogger();
	
	public static void info(String message) {
		log.info(message);
	}
	public static void info(int num) {
		log.info(num);
	}
	public static void warn(String message) {
		log.warn(message);
	}
	public static void error(String message) {
		log.error(message);
	}
	

}
