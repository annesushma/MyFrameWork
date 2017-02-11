package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigDataProvider {
	
	Properties pro;
	public ConfigDataProvider(){
		
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("The Exception is "+e.getMessage());
		}
	}
	
	public String getApplicationUrl(){
		String url=pro.getProperty("url");
		return url;
	}
	
	public String getChromePath(){
		String chrome=pro.getProperty("chromePath");
		return chrome;
		}
	public String getIEpath(){
		String IE=pro.getProperty("IEPath");
		return IE;
		
	}

}
