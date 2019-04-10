package cn.swu.edu.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import cn.swu.edu.dao.factory.CustomerDAOFactory;

/**
 * Servlet implementation class InitServlet
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public void init() throws ServletException {
    	CustomerDAOFactory.getInstance().setType("jdbc");
    	
    	//读取该路径下switch.properties文件内容获取type数值
    	InputStream in = getServletContext().getResourceAsStream("/WEB-INF/classes/switch.properties");
    	Properties properties = new Properties();
    	try {
    		//在switch.properties中获取属性值
			properties.load(in);
			String type = properties.getProperty("type");
			//给具体CustomerDAOFactotypery的type设置属性值
			CustomerDAOFactory.getInstance().setType(type);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
