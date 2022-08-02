package com.demo.utils;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	static Properties prop;
	public ReadConfig() {
		//Configuration_Orange\Config.properties
		File file= new File("./Configuration_Orange//Config.properties");
		
		try {
			FileInputStream fs= new FileInputStream(file);
			prop = new Properties();
			prop.load(fs);
		}
		catch(Exception e) {
			System.out.println("Exception is: "+ e.getMessage());
		}
	}
	// create separate method to get and read values from config.properties file 
	public String getAppURL() {
		String url= prop.getProperty("base_URL") ;
		return url;
	}
	public String getChromePath() {
		String chromePath= prop.getProperty("chromepath") ;
		return chromePath;
	}
	public String getEdgepath() 
	{ // same for getting other browser path
		String edgePath= prop.getProperty("edgepath") ;
		return edgePath;
	}
	public String getOperaPath() 
	{ // same for getting other browser path
		String operapath= prop.getProperty("operapath") ;
		return operapath;
	}
	public String getFirefoxPath() 
	{ // same for getting other browser path
		String firefoxPath= prop.getProperty("firefoxpath") ;
		return firefoxPath;
	}
	public String getUsername() 
	{ // same for getting other browser path
		String username= prop.getProperty("username") ;
		return username;
	}
	public String getPassword() 
	{ // same for getting other browser path
		String password= prop.getProperty("password") ;
		return password;
	}
	public String getExp_Title() {
		String exp_Title= prop.getProperty("exp_Title");
		return exp_Title;
	}
}
