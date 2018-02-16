package ie.bm.proje.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ie.bm.proje.model.Dosya;
import ie.bm.proje.model.Optik;

@WebServlet("/OptikleriOkuServlet")
public class OptikleriOkuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Optik kirp = new Optik();
		System.out.println("Optikler hizalanýyor...");
		kirp.egriligiDuzelt("images2", "hizalanmis", 200);
		//kirp.hizala("images2", "hizalanmis", 150);
		System.out.println("Kýrpma iþlemleri gerçekleþiyor...");
		kirp.optikKirp("hizalanmis", "kirpilmis", 130);
		Optik optik = new Optik();
		optik.optikOku();

		Dosya dosya = new Dosya();
		File hizalanmis[] = dosya.dosyalariGetir("hizalanmis");
		for (File file : hizalanmis) {
			file.delete();
		}

		File images2[] = dosya.dosyalariGetir("images2");
		for (File file : images2) {
			file.delete();
		}

		File kirpilmis[] = dosya.dosyalariGetir("kirpilmis");
		for (File file : kirpilmis) {
			file.delete();
		}
		
		File evreler[] = dosya.dosyalariGetir("evreler");
		for (File file : evreler) {
			file.delete();
		}
		System.out.println("Ýþlemler Tamamlandý!!!");
		
		String optiklerokutuldu = "Optikler okutuldu...";
		request.setAttribute("optiklerokutuldu", optiklerokutuldu);
		request.getRequestDispatcher("kullanicisayfasi.jsp").forward(request, response);
	}
}
