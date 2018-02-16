package ie.bm.proje.view;

import java.io.File;

import ie.bm.proje.view.OgrenciBilgileri;

public class OgrenciBilgileri {

	public static String yil;
	public static String donem;
	public static String ogrno;
	public static String oturumbilgisi;
	public static String sinavturu;
	public static String kitapcikturu;
	public static int dogrusayisi;
	public static int yanlissayisi;
	public static int puan;
	public static int ingilizceds;
	public static int inkilapds;
	public static int turkdilids;
	public static int temelbiltekds;
	public static int ingilizceys;
	public static int inkilapys;
	public static int turkdiliys;
	public static int temelbiltekys;
	public static int puaningilizce;
	public static int puaninkilap;
	public static int puanturkdili;
	public static int puantemelbiltek;
	public static String file;

	

	public static String getYil() {
		return yil;
	}



	public static void setYil(String yil) {
		OgrenciBilgileri.yil = yil;
	}



	public static String getDonem() {
		return donem;
	}



	public static void setDonem(String donem) {
		OgrenciBilgileri.donem = donem;
	}



	public static String getOgrno() {
		return ogrno;
	}



	public static void setOgrno(String ogrno) {
		OgrenciBilgileri.ogrno = ogrno;
	}



	public static String getOturumbilgisi() {
		return oturumbilgisi;
	}



	public static void setOturumbilgisi(String oturumbilgisi) {
		OgrenciBilgileri.oturumbilgisi = oturumbilgisi;
	}



	public static String getSinavturu() {
		return sinavturu;
	}



	public static void setSinavturu(String sinavturu) {
		OgrenciBilgileri.sinavturu = sinavturu;
	}



	public static String getKitapcikturu() {
		return kitapcikturu;
	}



	public static void setKitapcikturu(String kitapcikturu) {
		OgrenciBilgileri.kitapcikturu = kitapcikturu;
	}



	public static int getDogrusayisi() {
		return dogrusayisi;
	}



	public static void setDogrusayisi(int dogrusayisi) {
		OgrenciBilgileri.dogrusayisi = dogrusayisi;
	}



	public static int getYanlissayisi() {
		return yanlissayisi;
	}



	public static void setYanlissayisi(int yanlissayisi) {
		OgrenciBilgileri.yanlissayisi = yanlissayisi;
	}



	public static int getPuan() {
		return puan;
	}



	public static void setPuan(int puan) {
		OgrenciBilgileri.puan = puan;
	}



	public static int getIngilizceds() {
		return ingilizceds;
	}



	public static void setIngilizceds(int ingilizceds) {
		OgrenciBilgileri.ingilizceds = ingilizceds;
	}



	public static int getInkilapds() {
		return inkilapds;
	}



	public static void setInkilapds(int inkilapds) {
		OgrenciBilgileri.inkilapds = inkilapds;
	}



	public static int getTurkdilids() {
		return turkdilids;
	}



	public static void setTurkdilids(int turkdilids) {
		OgrenciBilgileri.turkdilids = turkdilids;
	}



	public static int getTemelbiltekds() {
		return temelbiltekds;
	}



	public static void setTemelbiltekds(int temelbiltekds) {
		OgrenciBilgileri.temelbiltekds = temelbiltekds;
	}



	public static int getIngilizceys() {
		return ingilizceys;
	}



	public static void setIngilizceys(int ingilizceys) {
		OgrenciBilgileri.ingilizceys = ingilizceys;
	}



	public static int getInkilapys() {
		return inkilapys;
	}



	public static void setInkilapys(int inkilapys) {
		OgrenciBilgileri.inkilapys = inkilapys;
	}



	public static int getTurkdiliys() {
		return turkdiliys;
	}



	public static void setTurkdiliys(int turkdiliys) {
		OgrenciBilgileri.turkdiliys = turkdiliys;
	}



	public static int getTemelbiltekys() {
		return temelbiltekys;
	}



	public static void setTemelbiltekys(int temelbiltekys) {
		OgrenciBilgileri.temelbiltekys = temelbiltekys;
	}



	public static int getPuaningilizce() {
		return puaningilizce;
	}



	public static void setPuaningilizce(int puaningilizce) {
		OgrenciBilgileri.puaningilizce = puaningilizce;
	}



	public static int getPuaninkilap() {
		return puaninkilap;
	}



	public static void setPuaninkilap(int puaninkilap) {
		OgrenciBilgileri.puaninkilap = puaninkilap;
	}



	public static int getPuanturkdili() {
		return puanturkdili;
	}



	public static void setPuanturkdili(int puanturkdili) {
		OgrenciBilgileri.puanturkdili = puanturkdili;
	}



	public static int getPuantemelbiltek() {
		return puantemelbiltek;
	}



	public static void setPuantemelbiltek(int puantemelbiltek) {
		OgrenciBilgileri.puantemelbiltek = puantemelbiltek;
	}



	public static String getFile() {
		return file;
	}



	public static void setFile(String file) {
		OgrenciBilgileri.file = file;
	}



	public static File resmiGetir(String ogrno) {
		File file = new File("optik.jpg");
		return file;
	}

}
