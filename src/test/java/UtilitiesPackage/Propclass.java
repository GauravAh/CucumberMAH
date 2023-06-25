package UtilitiesPackage;

import java.io.FileInputStream;
import java.util.Properties;

public class Propclass {
	Properties properties;
	
	public Propclass(){
	try {
		FileInputStream fileInputStream = new FileInputStream("./ExternalFiles/Prop.properties");
		properties = new Properties();
		properties.load(fileInputStream);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String getUrl() {
		return properties.getProperty("url");
	}
	
	public String getEmailid() {
		return properties.getProperty("emailid");
	}
	
	public String getSubject() {
		return properties.getProperty("subject");
	}
	
	
}
