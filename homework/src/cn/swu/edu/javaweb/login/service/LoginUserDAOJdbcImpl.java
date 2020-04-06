package cn.swu.edu.javaweb.login.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.swu.edu.javaweb.dao.DAO;
import cn.swu.edu.javaweb.db.JdbcUtils;
import cn.swu.edu.javaweb.login.dao.LoginUserDAO;
import cn.swu.edu.javaweb.login.pojo.LoginUser;

public class LoginUserDAOJdbcImpl extends DAO<LoginUser> implements LoginUserDAO {
    @Override
    public void save(LoginUser loginUser) {
        String sql = "insert into login(name,password,realname) values(?,?,?)";
        update(sql,loginUser.getUsername(),loginUser.getPassword(),loginUser.getRealName());
    }

    @Override
    public LoginUser get(Integer id) {
        String sql = "select * from login where id = ?";
        return get(sql,id);
    }

    @Override
    public void update(LoginUser loginUser) {
        String sql = "update login set name = ?,password = ?,realname = ?,phone = ?,address = ? where id = ?";
        update(sql,loginUser.getUsername(),loginUser.getPassword(),loginUser.getRealName(),loginUser.getPhone(),loginUser.getAddress(),loginUser.getId());
    }

    @Override
    public LoginUser findUser(String username, String password) {
        int id = 0;
    	Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        LoginUser loginUser = null;

        try {
            connection = JdbcUtils.getConnection();
            String sql = "select * from login where name = ? and password = ?";
            preparedStatement = connection.prepareStatement(sql);
//            int id = 0;
//            preparedStatement.setInt(1, id);
//            System.out.println("preparedStatement字段值" + id);
            preparedStatement.setString(1,username);
            System.out.println("preparedStatement字段值" + username);
            preparedStatement.setString(2,password);
            System.out.println("preparedStatement字段值" + password);
//            String realName = null;
//			preparedStatement.setString(3, realName);


            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                loginUser = new LoginUser(id,username,password);
                String s = resultSet.getString(2);
                System.out.println("字段值" + s);
                loginUser.setId(resultSet.getInt(1));
                loginUser.setUsername(resultSet.getString(2));
                loginUser.setPassword(resultSet.getString(3));
                loginUser.setRealName(resultSet.getString(4));
                loginUser.setPhone(resultSet.getString(5));
                loginUser.setAddress(resultSet.getString(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeAll(resultSet,preparedStatement,connection);
        }
        System.out.println(loginUser);
        return loginUser;
    }

	@Override
	public long getCountWithName(String name) {
		// TODO Auto-generated method stub
		String sql = "select count(id) from login where name = ?";
		return getForValue(sql, name);
	}

	@Override
	public List<LoginUser> getAll() {
		// TODO Auto-generated method stub
		String sql = "select * from login";
		return getForList(sql);
	}
}
