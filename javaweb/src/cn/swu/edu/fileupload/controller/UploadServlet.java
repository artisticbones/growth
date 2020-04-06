package cn.swu.edu.fileupload.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/uploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		int yourMaxMemorySize = 1024 * 500;
		// Set factory constraints
		factory.setSizeThreshold(yourMaxMemorySize);
		File yourTempDirectory = new File("/home/artisticbones/");
		factory.setRepository(yourTempDirectory);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		long yourMaxRequestSize = 1024 * 1024 * 5;
		// Set overall request size constraint
		upload.setSizeMax(yourMaxRequestSize);

		// Parse the request
		try {
			List<FileItem> items = upload.parseRequest(request);
			
			for(FileItem item :items) {
				if(item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString();
					
					System.out.println(name + ": " + value);
				}
				//若是文件域则把文件保存到/home/artisticbones 目录下
				else {
					String fieldName = item.getFieldName();
				    String fileName = item.getName();
				    String contentType = item.getContentType();
				    boolean isInMemory = item.isInMemory();
				    long sizeInBytes = item.getSize();
				    
				    System.out.println(fieldName);
				    System.out.println(fileName);
				    System.out.println(contentType);
				    System.out.println(isInMemory);
				    System.out.println(sizeInBytes);
				
				    InputStream in = item.getInputStream();
				    byte []buffer = new byte[1024];
				    int len = 0;
				    
				    fileName = "/home/artisticbones/" + fileName;
				    System.out.println(fileName);
				    
				    OutputStream out = new FileOutputStream(fileName);
				    
				    while((len = in.read(buffer)) != -1) {
				    	out.write(buffer, 0, len);
				    }
				    out.close();
				    in.close();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
