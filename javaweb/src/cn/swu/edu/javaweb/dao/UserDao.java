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
		authorities.add(new Authority("Article-1", "/permission/article-1.jsp"));
		authorities.add(new Authority("Article-2", "/permission/article-2.jsp"));
		authorities.add(new Authority("Article-3", "/permission/article-3.jsp"));
		authorities.add(new Authority("Article-4", "/permission/article-4.jsp"));
	
		users = new HashMap<String, User>();
		
//		User user1 = new User("tomcat", authorities.subList(0, 2));
//		users.put("tomcat", user1);
		
		User user1 = new User("AAA", authorities.subList(0, 2));
		users.put("AAA", user1);
		
		user1 = new User("BBB", authorities.subList(2, 4));
		users.put("BBB", user1);
	}
	
	public User get(String username) {
		return users.get(username);
	}
	
	public void update(String username,List<Authority> authorities) {
		users.get(username).setAuthorities(authorities);
	}
	
	public List<Authority> getAuthorities() {
		return authorities;
	}

	public List<Authority> getAuthorities(String[] urls) {
		List<Authority> authorities2 = new ArrayList<Authority>();
		
		for(Authority authority: authorities) {
			if(urls != null) {
				for(String url:urls) {
					if(url.equals(authority.getUrl())) {
						authorities2.add(authority);
					}
				}
			}
		}
		return authorities2;
	}
}
