package ie.bm.proje.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ie.bm.proje.database.Database;
import ie.bm.proje.model.CevapAnahtari;
import ie.bm.proje.view.Kullanici;

public class Database {

	public static int sonkayit;
	public static Connection connection = null;

	public static void baglantiAc() {
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:15000;databasename=OptikOkumaProjesi;user=iersinyavas;password=iersinyavas");

			/*
			 * Class.forName("oracle.jdbc.driver.OracleDriver"); connection =
			 * DriverManager.getConnection(
			 * "jdbc:oracle:thin:@localhost:1521:odatabase", "system",
			 * "iersinyavas+1");
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void baglantiKapat() {
		if (!connection.equals(null))
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public void ogrenciKaydet(String tc) {
		try {
			baglantiAc();
			String ogrenci_sql = "insert into Ogrenci(OgrenciTCNo) values(?)";
			PreparedStatement preparedStatement = connection.prepareStatement(ogrenci_sql);
			preparedStatement.setString(1, tc);
			preparedStatement.executeUpdate();
			baglantiKapat();
			preparedStatement.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	public static void tumBilgileriGir(String tc, ArrayList<String> ders, int dersId, String kitapcikturu,
			String oturumbilgisi, String sinavturu, String yil, String donem, int puan, String dosyayolu,
			String dosyaadi, int genelbasarinotu) {
		try {
			baglantiAc();
			String sql = "insert into Ogrenci_Ders(OgrenciTCNo, DersId, Kitapcik, Oturum, SinavTuru, C1, C2, C3, C4, C5, C6, C7, C8, C9, C10, C11, C12, C13, C14, C15, C16,"
					+ " C17, C18, C19, C20, C21, C22, C23, C24, C25, DogruSayisi, Yil, Donem, Puan, YanlisSayisi) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, tc);
			preparedStatement.setInt(2, dersId);
			preparedStatement.setString(3, kitapcikturu);
			preparedStatement.setString(4, oturumbilgisi);
			preparedStatement.setString(5, sinavturu);
			preparedStatement.setInt(31, 0);
			preparedStatement.setString(32, yil);
			preparedStatement.setString(33, donem);
			preparedStatement.setInt(34, puan);
			preparedStatement.setInt(35, 0);

			int indis = 6;
			for (int i = 0; i < 25; i++) {
				preparedStatement.setString(indis, ders.get(i));
				indis++;
			}
			preparedStatement.executeUpdate();
			baglantiKapat();
			preparedStatement.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public ArrayList<String> kayitlardakiCevaplariGetir(int kayitId) {
		ArrayList<String> cevaplar = new ArrayList<String>();

		try {
			for (int i = 1; i < 26; i++) {
				baglantiAc();
				String sql = "select C" + i + " from Ogrenci_Ders where KayitId = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, kayitId);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					cevaplar.add(resultSet.getString(1));
				}

				baglantiKapat();
				preparedStatement.close();
				resultSet.close();
			}
			for (int i = 0; i < cevaplar.size(); i++) {
				System.out.print(cevaplar.get(i));
			}
			System.out.println();
		} catch (SQLException e) {
			e.getStackTrace();
		}

		return cevaplar;
	}

	public int tumKayitSayisi() {
		int kayitsayisi = 0;
		try {
			baglantiAc();
			String sql = "select COUNT(KayitId) from Ogrenci_Ders;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				kayitsayisi = resultSet.getInt(1);
			}
			baglantiKapat();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}
		return kayitsayisi;
	}

	public void tumKayitCevaplariniGetir(CevapAnahtari cevapAnahtari) {

		System.out.println("Cevap anahtarlarý okunuyor...");

		for (int i = 0; i < cevapAnahtari.ingilizcecevapanahtari.size(); i++) {
			System.out.print(cevapAnahtari.ingilizcecevapanahtari.get(i));
		}
		System.out.println();

		for (int i = 0; i < cevapAnahtari.inkilapcevapanahtari.size(); i++) {
			System.out.print(cevapAnahtari.inkilapcevapanahtari.get(i));
		}
		System.out.println();

		for (int i = 0; i < cevapAnahtari.turkdilicevapanahtari.size(); i++) {
			System.out.print(cevapAnahtari.turkdilicevapanahtari.get(i));
		}
		System.out.println();

		for (int i = 0; i < cevapAnahtari.temelbiltekcevapanahtari.size(); i++) {
			System.out.print(cevapAnahtari.temelbiltekcevapanahtari.get(i));
		}
		System.out.println();
		System.out.println();
		System.out.println();
		int kayitsayisi = tumKayitSayisi();
		System.out.println("Cevaplar yazdýrýlýyor...");

		int ders = 0;
		for (int kayitId = sonkayit; kayitId <= kayitsayisi; kayitId++) {
			ders = kayitId % 4;
			ArrayList<String> cevaplar = kayitlardakiCevaplariGetir(kayitId);
			dogruSayisi(ders, cevapAnahtari, kayitId, cevaplar);
		}

	}

	public void tumKayitCevaplariniGetir() {
		CevapAnahtari cevapAnahtari = new CevapAnahtari();
		System.out.println();
		System.out.println("Cevap anahtarlarý okunuyor...");

		for (int i = 0; i < cevapAnahtari.ingilizcecevapanahtari.size(); i++) {
			System.out.print(cevapAnahtari.ingilizcecevapanahtari.get(i));
		}
		System.out.println();

		for (int i = 0; i < cevapAnahtari.inkilapcevapanahtari.size(); i++) {
			System.out.print(cevapAnahtari.inkilapcevapanahtari.get(i));
		}
		System.out.println();

		for (int i = 0; i < cevapAnahtari.turkdilicevapanahtari.size(); i++) {
			System.out.print(cevapAnahtari.turkdilicevapanahtari.get(i));
		}
		System.out.println();

		for (int i = 0; i < cevapAnahtari.temelbiltekcevapanahtari.size(); i++) {
			System.out.print(cevapAnahtari.temelbiltekcevapanahtari.get(i));
		}
		System.out.println();
		System.out.println();
		System.out.println();
		int kayitsayisi = tumKayitSayisi();
		System.out.println("Cevaplar yazdýrýlýyor...");

		int ders = 0;
		for (int kayitId = sonkayit; kayitId <= kayitsayisi; kayitId++) {
			ders = kayitId % 4;
			ArrayList<String> cevaplar = kayitlardakiCevaplariGetir(kayitId);
			dogruSayisi(ders, cevapAnahtari, kayitId, cevaplar);
		}
	}

	public void dogruSayisi(int ders, CevapAnahtari cevapAnahtari, int kayitId, ArrayList<String> cevaplar) {

		if (ders == 1) {
			int dogrusayisi = 0;
			for (int index = 0; index < 25; index++) {
				if (cevapAnahtari.ingilizcecevapanahtari.get(index).equals(cevaplar.get(index)))
					dogrusayisi++;
			}
			System.out.println("----->Dogru Sayisi : " + dogrusayisi);
			dogruSayisiniGuncelle(dogrusayisi, kayitId);
		}
		if (ders == 2) {
			int dogrusayisi = 0;
			for (int index = 0; index < 25; index++) {
				if (cevapAnahtari.inkilapcevapanahtari.get(index).equals(cevaplar.get(index)))
					dogrusayisi++;
			}
			System.out.println("----->Dogru Sayisi : " + dogrusayisi);
			dogruSayisiniGuncelle(dogrusayisi, kayitId);
		}
		if (ders == 3) {
			int dogrusayisi = 0;
			for (int index = 0; index < 25; index++) {
				if (cevapAnahtari.turkdilicevapanahtari.get(index).equals(cevaplar.get(index)))
					dogrusayisi++;
			}
			System.out.println("----->Dogru Sayisi : " + dogrusayisi);
			dogruSayisiniGuncelle(dogrusayisi, kayitId);
		}
		if (ders == 0) {
			int dogrusayisi = 0;
			for (int index = 0; index < 25; index++) {
				if (cevapAnahtari.temelbiltekcevapanahtari.get(index).equals(cevaplar.get(index)))
					dogrusayisi++;
			}
			System.out.println("----->Dogru Sayisi : " + dogrusayisi);
			dogruSayisiniGuncelle(dogrusayisi, kayitId);
		}
	}

	public void dogruSayisiniGuncelle(int dogrusayisi, int kayitId) {
		try {
			baglantiAc();
			int yanlissayisi = 25 - dogrusayisi;
			int puan = dogrusayisi * 4;
			String sql = "update Ogrenci_Ders set DogruSayisi=?, YanlisSayisi=?, Puan=? where KayitId=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, dogrusayisi);
			preparedStatement.setInt(2, yanlissayisi);
			preparedStatement.setInt(3, puan);
			preparedStatement.setInt(4, kayitId);
			preparedStatement.executeUpdate();
			baglantiKapat();
			preparedStatement.close();
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	public static Kullanici kayitliKullanici(String kullaniciadi, String sifre) {
		Kullanici kullanici = new Kullanici();
		kullanici.setKullaniciadi(" ");
		kullanici.setSifre(" ");

		baglantiAc();
		String sql = "select KullaniciAd, KullaniciSoyad, KullaniciAdi, KullaniciSifre from Kullanici where KullaniciAdi=? and KullaniciSifre=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, kullaniciadi);
			preparedStatement.setString(2, sifre);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				kullanici.setKullaniciadi(resultSet.getString("KullaniciAdi"));
				kullanici.setSifre(resultSet.getString("KullaniciSifre"));
				kullanici.setAd(resultSet.getString("KullaniciAd"));
				kullanici.setSoyad(resultSet.getString("KullaniciSoyad"));
			}

			baglantiKapat();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return kullanici;
	}
	
	public static Kullanici kayitliKullanici(String kullaniciadi) {
		Kullanici kullanici = new Kullanici();

		baglantiAc();
		String sql = "select KullaniciAdi, KullaniciSifre from Kullanici where KullaniciAdi=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, kullaniciadi);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				kullanici.setKullaniciadi(resultSet.getString("KullaniciAdi"));
			}

			baglantiKapat();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return kullanici;
	}

	public static void kayitEkle(String ad, String soyad, String kullaniciadi, String sifre) {
		try {
			baglantiAc();
			String sql = "insert into Kullanici(KullaniciAd, KullaniciSoyad, KullaniciAdi, KullaniciSifre, KullaniciDurum) values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, ad);
			preparedStatement.setString(2, soyad);
			preparedStatement.setString(3, kullaniciadi);
			preparedStatement.setString(4, sifre);
			preparedStatement.setBoolean(5, false);

			preparedStatement.executeUpdate();

			baglantiKapat();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void kullaniciOnline(String kullaniciadi){
		try {
			baglantiAc();
			
			String sql = "update Kullanici set KullaniciDurum=? where KullaniciAdi=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setBoolean(1, true);
			preparedStatement.setString(2, kullaniciadi);
			preparedStatement.executeUpdate();
			
			baglantiKapat();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void kullaniciOffline(String kullaniciadi){
		try {
			baglantiAc();
			
			String sql = "update Kullanici set KullaniciDurum=? where KullaniciAdi=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setBoolean(1, false);
			preparedStatement.setString(2, kullaniciadi);
			preparedStatement.executeUpdate();

			baglantiKapat();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean kullaniciDurumKontrol(String kullaniciadi){
		boolean durum = false;
		try {
			baglantiAc();
			
			String sql = "select KullaniciDurum from Kullanici where KullaniciAdi=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, kullaniciadi);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				durum = resultSet.getBoolean("KullaniciDurum");
			}
			
			baglantiKapat();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return durum;
	}
	
	public static void genelOrtalamaHesapla(int arasinavorani, int finalorani, String yil, String donem, int kayitid, int dersid){
		int dersarasinav=0, dersfinal=0;
		String ogrencitcno = null;
		try {
			baglantiAc();
			String sqla = "select OgrenciTCNo, Yil, Donem, Ders.DersId, Puan, SinavTuru from Ogrenci_Ders inner join Ders on Ders.DersId = Ogrenci_Ders.DersId "
					+ "where OgrenciTCno=(select OgrenciTCNo "
					+ "from Ogrenci_Ders where KayitId=?) and Yil=? and Donem=? and SinavTuru='Ara Sinav' and Ders.DersId=?";
			
			
			String sqlf = "select OgrenciTCNo, Yil, Donem, Ders.DersId, Puan, SinavTuru from Ogrenci_Ders inner join Ders on Ders.DersId = Ogrenci_Ders.DersId "
					+ "where OgrenciTCno=(select OgrenciTCNo "
					+ "from Ogrenci_Ders where KayitId=?) and Yil=? and Donem=? and SinavTuru='Final' and Ders.DersId=?";
			
			
			PreparedStatement preparedStatementa = connection.prepareStatement(sqla);
			preparedStatementa.setInt(1, kayitid);
			preparedStatementa.setString(2, yil);
			preparedStatementa.setString(3, donem);
			preparedStatementa.setInt(4, dersid);
			
			ResultSet resultSeta = preparedStatementa.executeQuery();
			while(resultSeta.next()){
				dersarasinav = resultSeta.getInt("Puan");
				ogrencitcno = resultSeta.getString("OgrenciTCNo");
				System.out.println(ogrencitcno);
			}
			preparedStatementa.close();
			resultSeta.close();
			
			PreparedStatement preparedStatementf = connection.prepareStatement(sqlf);
			preparedStatementf.setInt(1, kayitid);
			preparedStatementf.setString(2, yil);
			preparedStatementf.setString(3, donem);
			preparedStatementf.setInt(4, dersid);
			ResultSet resultSetf = preparedStatementf.executeQuery();
			while(resultSetf.next()){
				dersfinal = resultSetf.getInt("Puan");
			}
			preparedStatementf.close();
			resultSetf.close();
			
			
			String sql = "insert into GenelBasari(OgrenciTCNo, Yil, Donem, DersId, GenelBasariNotu) values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, ogrencitcno);
			preparedStatement.setString(2, yil);
			preparedStatement.setString(3, donem);
			preparedStatement.setInt(4, dersid);
			preparedStatement.setFloat(5, hesapYap(dersfinal, finalorani, dersarasinav, arasinavorani));
			preparedStatement.executeUpdate();
			
			baglantiKapat();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static float hesapYap(int dersfinal, int finalorani, int dersarasinav, int arasinavorani){
		
		return ((float)dersfinal*finalorani/100)+((float)dersarasinav*arasinavorani/100);
	}
	
	public static int kayitSayisi(String yil, String donem){
		int kayitsayisi = 0;
		try {
			baglantiAc();
			String sql = "select COUNT(KayitId) from Ogrenci_Ders inner join Ders on Ders.DersId = Ogrenci_Ders.DersId "
					+ "where Yil=? and Donem=? and SinavTuru in('Ara Sinav','Final') and Ders.DersId in(1,2,3,4)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, yil);
			preparedStatement.setString(2, donem);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				kayitsayisi = resultSet.getInt(1);
			}
			
			baglantiKapat();
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return kayitsayisi;
	}
}
