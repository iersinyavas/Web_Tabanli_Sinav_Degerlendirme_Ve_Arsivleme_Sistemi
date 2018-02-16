package ie.bm.proje.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ie.bm.proje.view.OgrenciBilgilerListesi;
import ie.bm.proje.view.OgrenciBilgileri;

@WebServlet("/OgrenciBilgileriListesiServlet")
public class OgrenciBilgileriListesiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String yil = request.getParameter("yil");
		String donem = request.getParameter("donem");
		String sinavturu = request.getParameter("sinavturu");
		OgrenciBilgileri.setYil(yil);
		OgrenciBilgileri.setDonem(donem);
		OgrenciBilgileri.setSinavturu(sinavturu);

		ArrayList<OgrenciBilgilerListesi> kayitlar = new OgrenciBilgilerListesi().kayitlariGetir(
				OgrenciBilgileri.getYil(), OgrenciBilgileri.getDonem(), OgrenciBilgileri.getSinavturu());
		request.setAttribute("kayitlar", kayitlar);
		request.getRequestDispatcher("sinavsonuclari2.jsp").forward(request, response);

	}

}
