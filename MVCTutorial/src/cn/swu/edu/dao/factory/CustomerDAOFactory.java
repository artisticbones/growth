package cn.swu.edu.dao.factory;

import java.util.HashMap;
import java.util.Map;

import cn.swu.edu.CustomerDAO;
import cn.swu.edu.dao.impl.CustomerDAOJdbcImpl;
import cn.swu.edu.dao.impl.CustomerDAOXmlImpl;

public class CustomerDAOFactory {
	
	private Map<String,CustomerDAO> daos = new HashMap<String, CustomerDAO>();
	
	private CustomerDAOFactory() {
		daos.put("jdbc", new CustomerDAOJdbcImpl());
		daos.put("xml", new CustomerDAOXmlImpl());
	}
	
	
	private static CustomerDAOFactory instance = new CustomerDAOFactory();
	
	public static CustomerDAOFactory getInstance() {
		return instance;
	}
	
	private String type = null;
	
	public void setType(String type) {
		this.type = type;
	}
	
	public CustomerDAO getCustomerDAO() {
		return daos.get(type);
		
	}
}
