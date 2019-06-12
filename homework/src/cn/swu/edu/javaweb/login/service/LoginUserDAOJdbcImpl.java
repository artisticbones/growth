package cn.swu.edu.javaweb.login.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.swu.edu.javaweb.dao.DAO;
import cn.swu.edu.javaweb.db.JdbcUtils;
import cn.swu.edu.javaweb.login.dao.LoginUserDAO;
import cn.swu.edu.javaweb.login.pojo.LoginUser;

public class LoginUserDAOJdbcImpl extends DAO<LoginUser> implements LoginUserDAO {
    @Override
    public void save(LoginUser loginUser) {
        String sql = "insert into test_users(name,password) values(?,?)";
        update(sql,loginUser.getUsername(),loginUser.getPassword());
    }

    @Override
    public LoginUser get(Integer id) {
        String sql = "select * from test_users where id = ?";
        return get(sql,id);
    }

    @Override
    public void update(LoginUser loginUser) {
        String sql = "update test_users set name = ?,password = ? where id = ?";
        update(sql,loginUser.getUsername(),loginUser.getPassword(),loginUser.getId());
    }

    @Override
    public LoginUser findUser(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        LoginUser loginUser = null;

        try {
            connection = JdbcUtils.getConnection();
            String sql = "select * from test_users where name = ? and password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            System.out.println("preparedStatement字段值" + username);
            preparedStatement.setString(2,password);
            System.out.println("preparedStatement字段值" + password);


            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                loginUser = new LoginUser(username,password);
                String s = resultSet.getString(2);
                System.out.println("字段值" + s);
                loginUser.setUsername(resultSet.getString(2));
                loginUser.setPassword(resultSet.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeAll(resultSet,preparedStatement,connection);
        }
        System.out.println(loginUser);
        return loginUser;
    }
}
