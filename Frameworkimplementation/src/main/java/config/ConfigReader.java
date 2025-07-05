package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static  Properties prop;
	
	public static void initProperties ()
	{
		
		prop = new Properties();
		
		try {
			FileInputStream input =	new FileInputStream ("src/main/java/config.properties");
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static String get(String key)
	{
		if (prop == null) {
	        initProperties();
	    }

		
		return prop.getProperty(key);
	}
	
	
	public static void set(String key, String value) {
	    if (prop == null) {
	        initProperties();
	    }
	    try {
	        FileOutputStream output = new FileOutputStream("src/main/java/config.properties");
	        prop.setProperty(key, value);
	        prop.store(output, "Updated property");
	        output.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	
	

}
