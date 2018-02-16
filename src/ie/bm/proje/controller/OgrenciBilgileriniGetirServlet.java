package ie.bm.proje.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import ie.bm.proje.database.Database;

@WebServlet("/OgrenciBilgileriniGetirServlet")
public class OgrenciBilgileriniGetirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * System.loadLibrary(Core.NATIVE_LIBRARY_NAME); String ogrno =
	 * request.getParameter("ogrencinumarasi1"); String yil =
	 * request.getParameter("yil1"); String donem =
	 * request.getParameter("donem1"); String sinavturu =
	 * request.getParameter("sinavturu1");
	 * 
	 * Database.ogrencibilgileri(ogrno, "Ýngilizce", yil, donem, sinavturu);
	 * OgrenciBilgileri.setIngilizceds(OgrenciBilgileri.getDogrusayisi());
	 * OgrenciBilgileri.setIngilizceys(OgrenciBilgileri.getYanlissayisi());
	 * OgrenciBilgileri.setPuaningilizce(OgrenciBilgileri.getPuan());
	 * 
	 * Database.ogrencibilgileri(ogrno, "Atatürk Ýlkeleri ve Ýnkýlap Tarihi",
	 * yil, donem, sinavturu);
	 * OgrenciBilgileri.setInkilapds(OgrenciBilgileri.getDogrusayisi());
	 * OgrenciBilgileri.setInkilapys(OgrenciBilgileri.getYanlissayisi());
	 * OgrenciBilgileri.setPuaninkilap(OgrenciBilgileri.getPuan());
	 * 
	 * Database.ogrencibilgileri(ogrno, "Türk Dili", yil, donem, sinavturu);
	 * OgrenciBilgileri.setTurkdilids(OgrenciBilgileri.getDogrusayisi());
	 * OgrenciBilgileri.setTurkdiliys(OgrenciBilgileri.getYanlissayisi());
	 * OgrenciBilgileri.setPuanturkdili(OgrenciBilgileri.getPuan());
	 * 
	 * Database.ogrencibilgileri(ogrno, "Temel Bilgi Teknolojisi Kullanýmý",
	 * yil, donem, sinavturu);
	 * OgrenciBilgileri.setTemelbiltekds(OgrenciBilgileri.getDogrusayisi());
	 * OgrenciBilgileri.setTemelbiltekys(OgrenciBilgileri.getYanlissayisi());
	 * OgrenciBilgileri.setPuantemelbiltek(OgrenciBilgileri.getPuan());
	 * 
	 * request.setAttribute("ogrtcno", OgrenciBilgileri.getOgrno());
	 * request.setAttribute("yil", OgrenciBilgileri.getYil());
	 * request.setAttribute("donem", OgrenciBilgileri.getDonem());
	 * request.setAttribute("kitapcikturu", OgrenciBilgileri.getKitapcikturu());
	 * request.setAttribute("oturum", OgrenciBilgileri.getOturumbilgisi());
	 * request.setAttribute("sinavturu", OgrenciBilgileri.getSinavturu());
	 * request.setAttribute("ingilizceds", OgrenciBilgileri.getIngilizceds());
	 * request.setAttribute("inkilapds", OgrenciBilgileri.getInkilapds());
	 * request.setAttribute("turkdilids", OgrenciBilgileri.getTurkdilids());
	 * request.setAttribute("temelbiltekds",
	 * OgrenciBilgileri.getTemelbiltekds()); request.setAttribute("ingilizceys",
	 * OgrenciBilgileri.getIngilizceys()); request.setAttribute("inkilapys",
	 * OgrenciBilgileri.getInkilapys()); request.setAttribute("turkdiliys",
	 * OgrenciBilgileri.getTurkdiliys()); request.setAttribute("temelbiltekys",
	 * OgrenciBilgileri.getTemelbiltekys());
	 * request.setAttribute("puaningilizce",
	 * OgrenciBilgileri.getPuaningilizce()); request.setAttribute("puaninkilap",
	 * OgrenciBilgileri.getPuaninkilap()); request.setAttribute("puanturkdili",
	 * OgrenciBilgileri.getPuanturkdili());
	 * request.setAttribute("puantemelbiltek",
	 * OgrenciBilgileri.getPuantemelbiltek());
	 * 
	 * /* String okunacakresminklasoru = OgrenciBilgileri.getYil() + "_" +
	 * OgrenciBilgileri.getDonem() + "_" + OgrenciBilgileri.getSinavturu(); Mat
	 * mat = Imgcodecs.imread("E:\\OptikOkumaProjesi\\OptikOkuma\\okunanlar\\" +
	 * okunacakresminklasoru + "\\" + ogrno + ".jpg"); Imgcodecs.imwrite(
	 * "E:\\OptikOkumaProjesi\\OptikOkuma\\WebContent\\images\\optik.jpg", mat);
	 * request.setAttribute("optik", okunacakresminklasoru + "/" + ogrno +
	 * ".jpg");
	 * 
	 * request.getRequestDispatcher("ogrencibilgileri.jsp").forward(request,
	 * response);
	 * 
	 * }
	 */
	String sql = "select OgrenciTCNo, Yil, Donem, SinavTuru, Kitapcik, Oturum, Ders.DersAdi, DogruSayisi, YanlisSayisi, Puan "
			+ "from Ogrenci_Ders inner join Ders on Ogrenci_Ders.DersId = Ders.DersId "
			+ "where OgrenciTCNo= ? and Ders.DersAdi= ? and Yil=? and Donem= ? and SinavTuru= ?";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		String ogrno = request.getParameter("ogrencinumarasi1");
		String yil = request.getParameter("yil1");
		String donem = request.getParameter("donem1");
		String sinavturu = request.getParameter("sinavturu1");

		String ingilizce = "Ýngilizce";
		String inkilap = "Atatürk Ýlkeleri ve Ýnkýlap Tarihi";
		String turkdili = "Türk Dili";
		String temelbiltek = "Temel Bilgi Teknolojisi Kullanýmý";

		Database.baglantiAc();
		try {
			PreparedStatement preparedStatement = Database.connection.prepareStatement(sql);
			preparedStatement.setString(1, ogrno);
			preparedStatement.setString(2, ingilizce);
			preparedStatement.setString(3, yil);
			preparedStatement.setString(4, donem);
			preparedStatement.setString(5, sinavturu);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				request.setAttribute("ogrtcno", resultSet.getString("OgrenciTCNo"));
				request.setAttribute("yil", resultSet.getString("Yil"));
				request.setAttribute("donem", resultSet.getString("Donem"));
				request.setAttribute("kitapcikturu", resultSet.getString("Kitapcik"));
				request.setAttribute("oturum", resultSet.getString("Oturum"));
				request.setAttribute("sinavturu", resultSet.getString("SinavTuru"));
				request.setAttribute("ingilizceds", resultSet.getInt("DogruSayisi"));
				request.setAttribute("ingilizceys", resultSet.getInt("YanlisSayisi"));
				request.setAttribute("puaningilizce", resultSet.getInt("Puan"));
			}

			preparedStatement.setString(1, ogrno);
			preparedStatement.setString(2, inkilap);
			preparedStatement.setString(3, yil);
			preparedStatement.setString(4, donem);
			preparedStatement.setString(5, sinavturu);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				request.setAttribute("inkilapds", resultSet.getInt("DogruSayisi"));
				request.setAttribute("inkilapys", resultSet.getInt("YanlisSayisi"));
				request.setAttribute("puaninkilap", resultSet.getInt("Puan"));
			}

			preparedStatement.setString(1, ogrno);
			preparedStatement.setString(2, turkdili);
			preparedStatement.setString(3, yil);
			preparedStatement.setString(4, donem);
			preparedStatement.setString(5, sinavturu);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				request.setAttribute("turkdilids", resultSet.getInt("DogruSayisi"));
				request.setAttribute("turkdiliys", resultSet.getInt("YanlisSayisi"));
				request.setAttribute("puanturkdili", resultSet.getInt("Puan"));
			}

			preparedStatement.setString(1, ogrno);
			preparedStatement.setString(2, temelbiltek);
			preparedStatement.setString(3, yil);
			preparedStatement.setString(4, donem);
			preparedStatement.setString(5, sinavturu);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				request.setAttribute("temelbiltekds", resultSet.getInt("DogruSayisi"));
				request.setAttribute("temelbiltekys", resultSet.getInt("YanlisSayisi"));
				request.setAttribute("puantemelbiltek", resultSet.getInt("Puan"));
			}
			
			
			
			
			String okunacakresminklasoru = yil + "_" + donem + "_" + sinavturu;
			Mat mat = Imgcodecs.imread("E:\\OptikOkumaProjesi\\OptikOkuma\\okunanlar\\" + okunacakresminklasoru + "\\" + ogrno + ".jpg");
			Imgcodecs.imwrite("E:\\OptikOkumaProjesi\\OptikOkuma\\WebContent\\images\\optik\\optik.jpg", mat);
			request.setAttribute("optik", okunacakresminklasoru + "/" + ogrno + ".jpg");
			Database.baglantiKapat();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("ogrenci.jsp").forward(request, response);
	}
}
