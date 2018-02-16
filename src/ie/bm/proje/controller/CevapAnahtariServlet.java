package ie.bm.proje.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ie.bm.proje.database.Database;
import ie.bm.proje.model.CevapAnahtari;

@WebServlet("/CevapAnahtariServlet")
public class CevapAnahtariServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CevapAnahtari cevapAnahtari = new CevapAnahtari(1);

		cevapAnahtari.ingilizcecevapanahtari.clear();
		cevapAnahtari.inkilapcevapanahtari.clear();
		cevapAnahtari.turkdilicevapanahtari.clear();
		cevapAnahtari.temelbiltekcevapanahtari.clear();

		for (int i = 1; i < 26; i++)
			cevapAnahtari.ingilizcecevapanahtari.add(request.getParameter("ingilizce" + i));

		for (int i = 1; i < 26; i++)
			cevapAnahtari.inkilapcevapanahtari.add(request.getParameter("inkilap" + i));

		for (int i = 1; i < 26; i++)
			cevapAnahtari.turkdilicevapanahtari.add(request.getParameter("turkdili" + i));

		for (int i = 1; i < 26; i++)
			cevapAnahtari.temelbiltekcevapanahtari.add(request.getParameter("temelbiltek" + i));

		Database database = new Database();
		database.tumKayitCevaplariniGetir(cevapAnahtari);
		
		String islemlertamamlandi = "Sýnav sonuçlarý oluþturuldu...";
		request.setAttribute("islemlertamamlandi", islemlertamamlandi);
		request.getRequestDispatcher("kullanicisayfasi.jsp").forward(request, response);

	}

}
