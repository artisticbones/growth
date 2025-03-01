package cn.swu.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginServlet3 extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String sql = "select count(id) from test_users where name = ?" 
		+ "and password = ?";
		
		PrintWriter out = response.getWriter();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql:///test";
			String user = "root";
			String password2 = "happy1314!";
			connection = DriverManager.getConnection(url,user,password2);
			
			statement = connection.prepareStatement(sql);
			statement.setString(1,username);
			statement.setString(2,password);
			
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				int count = resultSet.getInt(1);
				
				if(count > 0) {
					response.sendRedirect("index.html");
					//out.print("hello" + username);
				}else {
					out.print("sorry" + username);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
			}try {
				if(statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//释放所有Driver，防止内存泄漏
/*			Enumeration<Driver> enumeration = DriverManager.getDrivers();
			while(enumeration.hasMoreElements()) {
				try {
					DriverManager.deregisterDriver(enumeration.nextElement());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}*/
		}
	}

}
