package cn.swu.edu.javaweb.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.swu.edu.javaweb.pojo.Authority;
import cn.swu.edu.javaweb.pojo.User;

public class UserDao {
	private static Map<String, User> users;
	
	private static List<Authority> authorities = null;
	
	static {
		authorities = new ArrayList<>();
		authorities.add(new Authority("Article-1", "/article-1.jsp"));
		authorities.add(new Authority("Article-2", "/article-2.jsp"));
		authorities.add(new Authority("Article-3", "/article-3.jsp"));
		authorities.add(new Authority("Article-4", "/article-4.jsp"));
	
		users = new HashMap<String, User>();
		
		User user1 = new User("AAA", authorities);
		users.put("AAA", user1);
	}
	
	User get(String username) {
		return null;
	}
	
	void update(String username,List<Authority> authorities) {
		
	}
}
