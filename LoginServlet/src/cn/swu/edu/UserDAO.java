package cn.swu.edu;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;


public class UserDAO {
	public void update(LoginUsers user) {
		String sql = "update test_users set password = '"+user.getPassword()+"' where name = '"+user.getUsername()+"'";
		System.out.println(sql);
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
			//释放所有Driver，防止内存泄漏
			Enumeration<Driver> enumeration = DriverManager.getDrivers();
			while(enumeration.hasMoreElements()) {
				try {
					DriverManager.deregisterDriver(enumeration.nextElement());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public LoginUsers getCountWithName(String name) {
		LoginUsers users = new LoginUsers();
		String sql = "select id,name,password from test_users where name = '"+name+"'";
		System.out.println(sql);
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
			System.out.println(preparedStatement);	
			
			resultSet = preparedStatement.executeQuery();
			System.out.println("5");	
			while(resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String username = resultSet.getString(2);
				String password2 = resultSet.getString(3);
				
				System.out.println(id);
				System.out.println(username);
				System.out.println(password2);

				users = new LoginUsers(id, username, password2);
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
			//释放所有Driver，防止内存泄漏
                        Enumeration<Driver> enumeration = DriverManager.getDrivers();
                        while(enumeration.hasMoreElements()) {
                                try {
                                        DriverManager.deregisterDriver(enumeration.nextElement());
                                } catch (SQLException e) {
                                        e.printStackTrace();
                                }
                        }

		}
		
		return users;
	}
}
