package cn.swu.edu.javaweb.fileupload.listener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import cn.swu.edu.javaweb.fileupload.utils.FileUploadProperties;

/**
 * Application Lifecycle Listener implementation class FileUploadListener
 *
 */
public class FileUploadListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public FileUploadListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	InputStream inputStream = getClass().getClassLoader().getResourceAsStream("/upload.properties");
    	Properties properties = new Properties();
    	
    	try {
			properties.load(inputStream);
			
			for(Map.Entry<Object, Object> prop: properties.entrySet()){
				String propertyName = (String) prop.getKey();
				String propertyValue = (String) prop.getValue();
				System.out.println(propertyName);
				System.out.println(propertyValue);
				
				FileUploadProperties.getInstance().addProperty(propertyName, propertyValue);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	
}
