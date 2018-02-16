package ie.bm.proje.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ie.bm.proje.database.Database;
import ie.bm.proje.view.Kullanici;

@WebServlet("/KayitKontrolServlet")
public class KayitKontrolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ad = request.getParameter("ad");
		String soyad = request.getParameter("soyad");
		String kullaniciadi = request.getParameter("kullaniciadi");
		String sifre = request.getParameter("sifre");

		Kullanici kayit = Database.kayitliKullanici(kullaniciadi);

		if (kayit.getKullaniciadi() == null) {
			String kayitkontrolmesaji = "Kayýt baþarýlý...";
			request.setAttribute("kayitkontrolmesaji", kayitkontrolmesaji);
			Database.kayitEkle(ad, soyad, kullaniciadi, sifre);

			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			String kullanicivarmesaji = "Kullanýcý adý zaten mevcut!!!";
			request.setAttribute("kullanicivarmesaji", kullanicivarmesaji);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
