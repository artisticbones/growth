package cn.swu.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	public void update(LoginUsers user) {
		String sql = "update customers set password = '"+user.getPassword()+"' where name = '"+user.getUsername()+"'";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql:///test";
			String username = "root";
			String password = "happy1314!";
			
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url,username,password);
			connection.createStatement().execute(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public List<LoginUsers> getCountWithName(String name) {
		List<LoginUsers> users = new ArrayList<LoginUsers>();
		String sql = "select * from test_users where name = ?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		try {
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql:///test";
			String user = "root";
			String password = "happy1314!";
			
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url,user,password);
			
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String username = resultSet.getString(2);
				String password2 = resultSet.getString(3);
				
				LoginUsers user2 = new LoginUsers(id, username, password2);
				users.add(user2);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return users;
	}
}
