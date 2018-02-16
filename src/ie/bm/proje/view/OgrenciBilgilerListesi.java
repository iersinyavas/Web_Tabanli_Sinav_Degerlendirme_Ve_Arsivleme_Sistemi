package ie.bm.proje.view;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ie.bm.proje.database.Database;
import ie.bm.proje.view.OgrenciBilgilerListesi;

public class OgrenciBilgilerListesi {

	public int kayitid;
	public String dersadi;
	public String yil;
	public String donem;
	public String ogrno;
	public String oturumbilgisi;
	public String sinavturu;
	public String kitapcikturu;
	public int dogrusayisi;
	public int yanlissayisi;
	public int puan;

	public int getPuan() {
		return puan;
	}

	public void setPuan(int puan) {
		this.puan = puan;
	}

	public int getYanlissayisi() {
		return yanlissayisi;
	}

	public void setYanlissayisi(int yanlissayisi) {
		this.yanlissayisi = yanlissayisi;
	}

	public String getYil() {
		return yil;
	}

	public void setYil(String yil) {
		this.yil = yil;
	}

	public String getDonem() {
		return donem;
	}

	public void setDonem(String donem) {
		this.donem = donem;
	}

	public String getOgrno() {
		return ogrno;
	}

	public void setOgrno(String ogrno) {
		this.ogrno = ogrno;
	}

	public String getOturumbilgisi() {
		return oturumbilgisi;
	}

	public void setOturumbilgisi(String oturumbilgisi) {
		this.oturumbilgisi = oturumbilgisi;
	}

	public String getSinavturu() {
		return sinavturu;
	}

	public void setSinavturu(String sinavturu) {
		this.sinavturu = sinavturu;
	}

	public String getKitapcikturu() {
		return kitapcikturu;
	}

	public void setKitapcikturu(String kitapcikturu) {
		this.kitapcikturu = kitapcikturu;
	}

	public int getDogrusayisi() {
		return dogrusayisi;
	}

	public void setDogrusayisi(int dogrusayisi) {
		this.dogrusayisi = dogrusayisi;
	}

	public int getKayitid() {
		return kayitid;
	}

	public void setKayitid(int kayitid) {
		this.kayitid = kayitid;
	}

	public String getDersadi() {
		return dersadi;
	}

	public void setDersadi(String dersadi) {
		this.dersadi = dersadi;
	}

	public ArrayList<OgrenciBilgilerListesi> kayitlariGetir(String yil, String donem, String sinavturu) {
		ArrayList<OgrenciBilgilerListesi> sinavsonuclari = new ArrayList<OgrenciBilgilerListesi>();

		try {
			Database.baglantiAc();
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			String sql = "select KayitId, OgrenciTCNo, Yil, Donem, Kitapcik, Ders.DersAdi, Oturum, SinavTuru, DogruSayisi, YanlisSayisi, Puan from Ogrenci_Ders inner join Ders on Ogrenci_Ders.DersId = Ders.DersId where Yil=? and Donem=? and SinavTuru=?";
			preparedStatement = Database.connection.prepareStatement(sql);
			preparedStatement.setString(1, yil);
			preparedStatement.setString(2, donem);
			preparedStatement.setString(3, sinavturu);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				OgrenciBilgilerListesi ogrenciBilgilerListesi = new OgrenciBilgilerListesi();
				ogrenciBilgilerListesi.setKayitid(resultSet.getInt("KayitId"));
				;
				ogrenciBilgilerListesi.setOgrno(resultSet.getString("OgrenciTCNo"));
				ogrenciBilgilerListesi.setYil(resultSet.getString("Yil"));
				ogrenciBilgilerListesi.setDonem(resultSet.getString("Donem"));
				ogrenciBilgilerListesi.setDersadi(resultSet.getString("DersAdi"));
				ogrenciBilgilerListesi.setOturumbilgisi(resultSet.getString("Oturum"));
				ogrenciBilgilerListesi.setSinavturu(resultSet.getString("SinavTuru"));
				ogrenciBilgilerListesi.setKitapcikturu(resultSet.getString("Kitapcik"));
				ogrenciBilgilerListesi.setDogrusayisi(resultSet.getInt("DogruSayisi"));
				ogrenciBilgilerListesi.setYanlissayisi(resultSet.getInt("YanlisSayisi"));
				ogrenciBilgilerListesi.setPuan(resultSet.getInt("Puan"));

				sinavsonuclari.add(ogrenciBilgilerListesi);
			}

			Database.baglantiKapat();
			preparedStatement.close();
			resultSet.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sinavsonuclari;
	}

}
