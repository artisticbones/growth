package cn.swu.edu.javaweb.fileupload.utils;

import java.util.HashMap;
import java.util.Map;

public class FileUploadProperties {
	
	private Map<String, String> properties = new HashMap<>();
	
	private FileUploadProperties() {
		// TODO Auto-generated constructor stub
	}
	
	private static FileUploadProperties instance = new FileUploadProperties();
	
	public static FileUploadProperties getInstance() {
		return instance;
	}
	
	public void addProperty(String propertyName,String propertyValue) {
		// TODO Auto-generated method stub
		properties.put(propertyName, propertyName);
	}
	
	public String getProperty(String propertyName) {
		System.out.println(properties.get(propertyName));
		return properties.get(propertyName);
	}
}
