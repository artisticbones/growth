package cn.edu.swu.readfromdoc.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.swu.readfromdoc.dao.DAO;

/**
 * Servlet implementation class write2Docx
 */
@WebServlet("/write2Docx")
public class write2Docx extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getParameter("path");
		System.out.println(path);
		try {
			File file = new File(path);
			DAO write2Docx = new DAO(file);
			write2Docx.createDocx(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
