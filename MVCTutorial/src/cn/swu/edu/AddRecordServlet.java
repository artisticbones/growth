package cn.swu.edu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddRecordServlet
 */
@WebServlet("/addRecord")
public class AddRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer flowId = (Integer.parseInt(request.getParameter("flowId")));
		Integer type = (Integer.parseInt(request.getParameter("type")));
		String idCard = request.getParameter("idCard");
		String examCard = request.getParameter("examCard");
		String studentName = request.getParameter("studentName");
		String location = request.getParameter("location");
		Integer grade = (Integer.parseInt(request.getParameter("grade")));
		
		StudentDao studentDao = new StudentDao();
		
		studentDao.AddRecord(flowId, type, idCard, examCard, studentName, location, grade);
		request.getRequestDispatcher("/success.jsp").forward(request, response);
	}

}
