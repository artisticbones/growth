package cn.swu.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	
	public void AddRecord(Integer flowId,int type,String idCard,String examCard,String studentName,String location,int grade) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql:///test";
			String user = "root";
			String password = "happy1314!";
			
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url,user,password);
			
			String sql = "insert into examstudent(flow_id,Type,id_card,exam_card,student_name,Location,Grade)"
					+ "values('"+flowId+"','"+type+"','"+idCard+"','"+examCard+"','"+studentName+"','"+location+"','"+grade+"')";
			connection.createStatement().execute(sql);
//			preparedStatement = connection.prepareStatement(sql);
//			
//			preparedStatement.setInt(1,flowId);
//			preparedStatement.setInt(2, type);
//			preparedStatement.setString(3, idCard);
//			preparedStatement.setString(4, examCard);
//			preparedStatement.setString(5, studentName);
//			preparedStatement.setString(6, location);
//			preparedStatement.setInt(7, grade);
//			
			//preparedStatement.executeUpdate();
//			preparedStatement.execute();
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
	
	public void deleteByFlowId(Integer flowId) {
		//List<Student> students = new ArrayList<Student>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			String driverClass = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql:///test";
			String user = "root";
			String password = "happy1314!";
			
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url,user,password);
			
			String sql = "delete from examstudent where flow_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1,flowId);
			
			preparedStatement.executeUpdate();
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
	
	public List<Student> getAll() {
		List<Student> students = new ArrayList<Student>();
		
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
			
			String sql = "select flow_id,Type,id_card,exam_card,student_name,Location,Grade from examstudent";
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int flowId = resultSet.getInt(1);
				int type = resultSet.getInt(2);
				String idCard = resultSet.getString(3);
				String examCard = resultSet.getString(4);
				String studentName = resultSet.getString(5);
				String location = resultSet.getString(6);
				int grade = resultSet.getInt(7);
				
				Student student = new Student(flowId, type, idCard, examCard, studentName, location, grade);
				
				students.add(student);
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
		
		return students;
	}
}
