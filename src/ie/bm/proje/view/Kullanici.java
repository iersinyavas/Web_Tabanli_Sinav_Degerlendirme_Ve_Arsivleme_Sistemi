package ie.bm.proje.view;

public class Kullanici {

	public String id, kullaniciadi, sifre, ad, soyad;
	public static String sid, skullaniciadi, ssifre, sad, ssoyad;
	public static boolean sdurum;
	
	
	public static boolean isSdurum() {
		return sdurum;
	}
	public static void setSdurum(boolean sdurum) {
		Kullanici.sdurum = sdurum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKullaniciadi() {
		return kullaniciadi;
	}
	public void setKullaniciadi(String kullaniciadi) {
		this.kullaniciadi = kullaniciadi;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public static String getSid() {
		return sid;
	}
	public static void setSid(String sid) {
		Kullanici.sid = sid;
	}
	public static String getSkullaniciadi() {
		return skullaniciadi;
	}
	public static void setSkullaniciadi(String skullaniciadi) {
		Kullanici.skullaniciadi = skullaniciadi;
	}
	public static String getSsifre() {
		return ssifre;
	}
	public static void setSsifre(String ssifre) {
		Kullanici.ssifre = ssifre;
	}
	public static String getSad() {
		return sad;
	}
	public static void setSad(String sad) {
		Kullanici.sad = sad;
	}
	public static String getSsoyad() {
		return ssoyad;
	}
	public static void setSsoyad(String ssoyad) {
		Kullanici.ssoyad = ssoyad;
	}

	
}
