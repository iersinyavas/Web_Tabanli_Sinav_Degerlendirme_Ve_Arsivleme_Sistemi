package ie.bm.proje.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ie.bm.proje.view.OgrenciBilgileri;

@WebServlet("/SinavOlusturServlet")
public class SinavOlusturServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String yil = request.getParameter("yil");
		String donem = request.getParameter("donem");
		String sinavturu = request.getParameter("sinavturu");
		OgrenciBilgileri.setYil(yil);
		OgrenciBilgileri.setDonem(donem);
		OgrenciBilgileri.setSinavturu(sinavturu);
		response.sendRedirect("kullanicisayfasi.jsp");

	}

}
