package cn.swu.edu.javaweb.manager.factory;

import java.util.HashMap;
import java.util.Map;


import cn.swu.edu.javaweb.manager.dao.PersonDAO;
import cn.swu.edu.javaweb.manager.service.PersonDAOJdbcImpl;

public class PersonDAOFactory {
	
	private Map<String,PersonDAO> daos = new HashMap<String, PersonDAO>();
	
	private PersonDAOFactory() {
		daos.put("jdbc", new PersonDAOJdbcImpl());
		//daos.put("xml", new PersonDAOXmlImpl());
	}
	
	
	private static PersonDAOFactory instance = new PersonDAOFactory();
	
	public static PersonDAOFactory getInstance() {
		return instance;
	}
	
	private String type = null;
	
	public void setType(String type) {
		this.type = type;
	}
	
	public PersonDAO getPersonDAO() {
		return daos.get(type);
		
	}
}
