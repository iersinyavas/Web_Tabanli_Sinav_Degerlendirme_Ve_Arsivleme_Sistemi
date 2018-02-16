package ie.bm.proje.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/DosyalariYukleServlet")
public class DosyalariYukleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> fileItems = servletFileUpload.parseRequest(request);
			for (FileItem item : fileItems) {
				item.write(new File("E:\\OptikOkumaProjesi\\OptikOkuma\\images2\\" + item.getName()));
			}
			request.getRequestDispatcher("optikoku.jsp").forward(request, response);
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

}
