package ie.bm.proje.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ie.bm.proje.database.Database;
import ie.bm.proje.view.Kullanici;

@WebServlet("/KullaniciSayfasiServlet")
public class KullaniciSayfasiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String kullaniciadi = request.getParameter("kullaniciadi1");
		String sifre = request.getParameter("sifre1");
		
		Kullanici kayit = Database.kayitliKullanici(kullaniciadi, sifre);
		
		if(kayit.getKullaniciadi().equals(kullaniciadi) && kayit.getSifre().equals(sifre)){
			Kullanici.setSkullaniciadi(kullaniciadi);
			Database.kullaniciOnline(kullaniciadi);
			//Kullanici.setSdurum(true);
			request.getSession().setAttribute("kullaniciadi", kullaniciadi);
			request.getSession().setAttribute("kullanici", kayit.getAd()+" "+kayit.getSoyad());
			response.sendRedirect("kullanicisayfasi.jsp");
		}else{
			String mesaj = "Kullanýcý adý veya þifre hatalý!!!";
			request.setAttribute("mesaj", mesaj);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}
