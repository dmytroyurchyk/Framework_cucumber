package gov.cms.utilities;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * 
 * 
 * @author ib3356
 */
public class ConfigurationReader {
	
	private static Properties configFile;

	static {

		try {
			String path = "configuration.properties";
			FileInputStream input = new FileInputStream(path);

			configFile = new Properties();
			configFile.load(input);

			input.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static String getProperty(String keyName) {
		return configFile.getProperty(keyName);
	}
	
	
}
