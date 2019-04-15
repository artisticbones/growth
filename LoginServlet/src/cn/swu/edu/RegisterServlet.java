package cn.swu.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RegisterServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatPassword");

		if(password.equals(repeatPassword)){		

			PrintWriter out = response.getWriter();
			Connection connection = null;
			PreparedStatement statement = null;

		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql:///test";
				String user = "root";
				String password2 = "happy1314!";

				String sql = "insert into test_users(name,password) " + "values('"+username+"','"+password+"')";
				connection = DriverManager.getConnection(url,user,password2);			
				connection.createStatement().execute(sql);

				response.sendRedirect("login.html");
				//out.print("hello" + username);

				//out.print("sorry" + username);


			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
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
			}
		}else{
			PrintWriter out = response.getWriter();
			out.println("对不起，密码不匹配！");
		}
	}

}
