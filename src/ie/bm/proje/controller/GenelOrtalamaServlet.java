package ie.bm.proje.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ie.bm.proje.database.Database;

@WebServlet("/GenelOrtalamaServlet")
public class GenelOrtalamaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int arasinavorani = Integer.parseInt(request.getParameter("arasinavorani"));
		int finalorani = Integer.parseInt(request.getParameter("finalorani"));
		String yil = request.getParameter("yil");
		String donem = request.getParameter("donem");
		ArrayList<Integer> kayitidler = new ArrayList<Integer>();
		
		try {
			Database.baglantiAc();
			String sql = "select KayitId from Ogrenci_Ders inner join Ders on Ders.DersId = Ogrenci_Ders.DersId "
					+ "where Yil=? and Donem=? and SinavTuru in('Ara Sinav','Final') and Ders.DersId in(1,2,3,4)";
			PreparedStatement preparedStatement = Database.connection.prepareStatement(sql);
			preparedStatement.setString(1, yil);
			preparedStatement.setString(2, donem);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				kayitidler.add(resultSet.getInt("KayitId"));
			}
			
			Database.baglantiKapat();
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		int kayitsayisi = Database.kayitSayisi(yil, donem)-1;

		for (int i = 0; i <= kayitsayisi; i += 8) {
			Database.genelOrtalamaHesapla(arasinavorani, finalorani, yil, donem, kayitidler.get(i), 1);
			Database.genelOrtalamaHesapla(arasinavorani, finalorani, yil, donem, kayitidler.get(i), 2);
			Database.genelOrtalamaHesapla(arasinavorani, finalorani, yil, donem, kayitidler.get(i), 3);
			Database.genelOrtalamaHesapla(arasinavorani, finalorani, yil, donem, kayitidler.get(i), 4);
		}
		
		String genelbasari = "Öðrencilerin genel baþarý iþlemleri tamamlandý...";
		request.setAttribute("genelbasari", genelbasari);
		request.getRequestDispatcher("kullanicisayfasi.jsp").forward(request, response);
	}
}
