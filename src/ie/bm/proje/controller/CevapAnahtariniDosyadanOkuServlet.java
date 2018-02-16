package ie.bm.proje.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ie.bm.proje.database.Database;
import ie.bm.proje.model.Dosya;
import ie.bm.proje.model.Optik;

@WebServlet("/CevapAnahtariniDosyadanOkuServlet")
public class CevapAnahtariniDosyadanOkuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Optik kirp = new Optik();
		//kirp.hizala("cevapanahtari", "cevapanahtarikirp", 120, 1);
		kirp.egriligiDuzelt("cevapanahtari", "cevapanahtarikirp", 200);
		kirp.optikKirp("cevapanahtarikirp", "cevapanahtarikirp", 120);
		Database database = new Database();
		database.tumKayitCevaplariniGetir();

		Dosya dosya = new Dosya();
		File cevapanahtari[] = dosya.dosyalariGetir("cevapanahtari");
		for (File file : cevapanahtari) {
			file.delete();
		}

		File cevapanahtarikirp[] = dosya.dosyalariGetir("cevapanahtarikirp");
		for (File file : cevapanahtarikirp) {
			file.delete();
		}
		response.sendRedirect("kullanicisayfasi.jsp");

	}

}
