package cn.swu.edu.javaweb.login.dao;

import java.util.List;

import cn.swu.edu.javaweb.login.pojo.LoginUser;

public interface LoginUserDAO {
	public List<LoginUser> getAll();
	
    public void save(LoginUser loginUser);

    public LoginUser get(Integer id);

    public void update(LoginUser loginUser);

    public LoginUser findUser(String username, String password);

	public long getCountWithName(String name);
}
