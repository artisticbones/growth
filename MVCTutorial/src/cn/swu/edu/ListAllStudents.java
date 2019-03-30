package cn.swu.edu;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListAllStudents
 */
@WebServlet("/listAllStudents")
public class ListAllStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		StudentDao studentDao = new StudentDao();
		List<Student> students = studentDao.getAll();
		
		request.setAttribute("students", students);
		
		request.getRequestDispatcher("/student.jsp").forward(request, response);
	}

}
