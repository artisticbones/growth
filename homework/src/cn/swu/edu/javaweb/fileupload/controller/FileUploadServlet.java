package cn.swu.edu.javaweb.fileupload.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import cn.swu.edu.javaweb.fileupload.pojo.FileUploadBean;
import cn.swu.edu.javaweb.fileupload.utils.FileUploadProperties;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/fileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TEMP_DIR = null;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletFileUpload upload = getServletFileUpload();
	
String path;
try {
			
			//把需要上传的 FileItem 都放入到该 Map 中
			//键: 文件的待存放的路径, 值: 对应的 FileItem 对象
			Map<String, FileItem> uploadFiles = new HashMap<String, FileItem>();
			
			//解析请求, 得到 FileItem 的集合.
			List<FileItem> items = upload.parseRequest(request);
			
			//1. 构建 FileUploadBean 的集合, 同时填充 uploadFiles
			List<FileUploadBean> beans = buildFileUploadBeans(items, uploadFiles);
			
			//2. 校验扩展名:
			vaidateExtName(beans);

			//3. 校验文件的大小: 在解析时, 已经校验了, 我们只需要通过异常得到结果. 
			
			//4. 进行文件的上传操作.
			upload(uploadFiles);
			
			//5. 把上传的信息保存到数据库中
			saveBeans(beans);
			
			//6. 删除临时文件夹的临时文件
			FileUtils.delAllFile(TEMP_DIR);
			
			path = "/webpages/fileupload/success.jsp";
			
		} catch (Exception e) {
			e.printStackTrace();
			path = "/app/upload.jsp";
			request.setAttribute("message", e.getMessage());
		}
	}

	private void saveBeans(List<FileUploadBean> beans) {
		// TODO Auto-generated method stub
		
	}

	private void upload(Map<String, FileItem> uploadFiles) {
		// TODO Auto-generated method stub
		
	}

	private void vaidateExtName(List<FileUploadBean> beans) {
		// TODO Auto-generated method stub
		
	}

	private List<FileUploadBean> buildFileUploadBeans(List<FileItem> items, Map<String, FileItem> uploadFiles) {
		// TODO Auto-generated method stub
		return null;
	}

	private ServletFileUpload getServletFileUpload() {
		//String exts = FileUploadProperties.getInstance().getProperty("exts");
		String fileMaxSize = FileUploadProperties.getInstance().getProperty("fileMaxSize");
		String totalFileMaxSize =FileUploadProperties.getInstance().getProperty("total.file.max.size");
	
		DiskFileItemFactory factory = new DiskFileItemFactory();
	
		int yourMaxMemorySize = 1024 * 500;
		// Set factory constraints
		factory.setSizeThreshold(yourMaxMemorySize);
		File yourTempDirectory = new File("/home/artisticbones/");
		factory.setRepository(yourTempDirectory);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

//		long yourMaxRequestSize = 1024 * 1024 * 5;
		// Set overall request size constraint
		upload.setSizeMax(Integer.parseInt(totalFileMaxSize));
		upload.setFileSizeMax(Integer.parseInt(fileMaxSize));
		return upload;
	}

}
