package ie.bm.proje.model;

import java.io.File;
import java.util.ArrayList;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import ie.bm.proje.database.Database;
import ie.bm.proje.model.Dersler;
import ie.bm.proje.model.Dosya;
import ie.bm.proje.model.Karakter;
import ie.bm.proje.model.Kitapcik;
import ie.bm.proje.view.OgrenciBilgileri;
import ie.bm.proje.model.Oturum;

public class Optik {

	static int basamak = 50;

	ArrayList<File> resimDosyalari = new ArrayList<File>();
	Mat duzgunresim;
	Point kirpmanoktasi;

	public void optikKirp(String okunanklasor, String yazilanklasor, int esik) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Dosya dosya = new Dosya();
		File resimler[] = dosya.dosyalariGetir(okunanklasor);

		for (File file : resimler) {
			Mat optik = Imgcodecs.imread("E:\\OptikOkumaProjesi\\OptikOkuma\\" + okunanklasor + "\\" + file.getName());
			Mat optik_gray = new Mat();
			Imgproc.cvtColor(optik, optik_gray, Imgproc.COLOR_RGB2GRAY);
			Mat kirp_binary = new Mat();
			Imgproc.threshold(optik_gray, kirp_binary, esik, 255, Imgproc.THRESH_BINARY);
			Imgcodecs.imwrite("E:\\OptikOkumaProjesi\\OptikOkuma\\" + yazilanklasor + "\\" + file.getName(),
					kirp_binary);
		}
	}

	public void hizala(String klasor, String kirpilanklasor, int esik, int sayi) {

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Dosya dosya = new Dosya();
		File resimler[] = dosya.dosyalariGetir(klasor);
		int yatay = 0;
		int dikey = 0;

		for (File file : resimler) {
			try {
				Mat optik = Imgcodecs.imread("E:\\OptikOkumaProjesi\\OptikOkuma\\" + klasor + "\\" + file.getName());
				Mat optik_gray = new Mat();
				Imgproc.cvtColor(optik, optik_gray, Imgproc.COLOR_RGB2GRAY);
				Mat kirp_binary = new Mat();
				Imgproc.threshold(optik_gray, kirp_binary, esik, 255, Imgproc.THRESH_BINARY);

				for (int i = 500; i < 600; i++) {
					double renkler[] = kirp_binary.get(i, 80);

					System.out.print(i + "---" + renkler[0] + "       ");

					if (renkler[0] == 0.0) {
						dikey = i;
						dikey += 10;
						break;
					}
				}

				for (int i = 75; i < 200; i++) {
					double renkler[] = kirp_binary.get(dikey, i);

					System.out.print(i + "---" + renkler[0] + "       ");

					if (renkler[0] == 255.0) {
						yatay = i;
						break;
					}
				}
				Rect dikdortgen = new Rect(new Point(yatay + 40, dikey - 26),
						new Point(kirp_binary.cols(), kirp_binary.rows()));
				Mat hizalanmis = new Mat(kirp_binary, dikdortgen);
				Imgcodecs.imwrite("E:\\OptikOkumaProjesi\\OptikOkuma\\" + kirpilanklasor + "\\" + file.getName(),
						hizalanmis);
			} catch (Exception e) {
				System.out.println(file.getName() + " Dosyasý Hatalý");
			}
		}

	}

	public void hizala(String klasor, String kirpilanklasor, int esik) {

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Dosya dosya = new Dosya();
		File resimler[] = dosya.dosyalariGetir(klasor);
		int yatay = 0;
		int dikey = 0;

		for (File file : resimler) {
			try {
				Mat optik = Imgcodecs.imread("E:\\OptikOkumaProjesi\\OptikOkuma\\" + klasor + "\\" + file.getName());
				Mat optik_gray = new Mat();
				Imgproc.cvtColor(optik, optik_gray, Imgproc.COLOR_RGB2GRAY);
				Mat kirp_binary = new Mat();
				Imgproc.threshold(optik_gray, kirp_binary, esik, 255, Imgproc.THRESH_BINARY);

				for (int i = 500; i < 600; i++) {
					double renkler[] = kirp_binary.get(i, 75);

					System.out.print(i + "---" + renkler[0] + "       ");

					if (renkler[0] == 0.0) {
						dikey = i;
						dikey += 10;
						break;
					}
				}

				for (int i = 75; i < 200; i++) {
					double renkler[] = kirp_binary.get(dikey, i);

					System.out.print(i + "---" + renkler[0] + "       ");

					if (renkler[0] == 255.0) {
						yatay = i;
						break;
					}
				}
				Rect dikdortgen = new Rect(new Point(yatay + 40, dikey - 26),
						new Point(kirp_binary.cols(), kirp_binary.rows()));
				Mat hizalanmis = new Mat(optik, dikdortgen);
				Imgcodecs.imwrite("E:\\OptikOkumaProjesi\\OptikOkuma\\" + kirpilanklasor + "\\" + file.getName(),
						hizalanmis);
			} catch (Exception e) {
				System.out.println(file.getName() + " Dosyasý Hatalý");
			}
		}
	}

	public void optikOku() {

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Dosya dosya = new Dosya();

		Karakter numara0 = new Karakter("0");
		Karakter numara1 = new Karakter("1");
		Karakter numara2 = new Karakter("2");
		Karakter numara3 = new Karakter("3");
		Karakter numara4 = new Karakter("4");
		Karakter numara5 = new Karakter("5");
		Karakter numara6 = new Karakter("6");
		Karakter numara7 = new Karakter("7");
		Karakter numara8 = new Karakter("8");
		Karakter numara9 = new Karakter("9");

		File resimDosyalari[] = dosya.dosyalariGetir("kirpilmis");
		Karakter karakter = new Karakter();

		Database database = new Database();
		Database.sonkayit = database.tumKayitSayisi() + 1;
		System.out.println(Database.sonkayit);

		String yazilanklasor = OgrenciBilgileri.getYil() + "_" + OgrenciBilgileri.getDonem() + "_"
				+ OgrenciBilgileri.getSinavturu();
		Dosya.klasorOlustur(yazilanklasor);

		for (File file : resimDosyalari) {
			try {
				Mat optik = Imgcodecs.imread("E:\\OptikOkumaProjesi\\OptikOkuma\\kirpilmis\\" + file.getName());

				// TC No
				ArrayList<String> tcno = new ArrayList<String>();
				for (int j = 0; j < 11; j++) {
					numara0.sayac = 0;
					numara1.sayac = 0;
					numara2.sayac = 0;
					numara3.sayac = 0;
					numara4.sayac = 0;
					numara5.sayac = 0;
					numara6.sayac = 0;
					numara7.sayac = 0;
					numara8.sayac = 0;
					numara9.sayac = 0;
					for (int i = 0; i < 10; i++) {
						Rect rect = new Rect(j * basamak, (i + 4) * basamak, basamak, basamak);
						Mat mat = new Mat(optik, rect);
						int satir = mat.rows();
						int sutun = mat.cols();
						for (int a = 0; a < satir; a++)
							for (int b = 0; b < sutun; b++) {
								double dizi[] = mat.get(a, b);
								if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 0)
									numara0.sayac++;
								if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 1)
									numara1.sayac++;
								if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 2)
									numara2.sayac++;
								if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 3)
									numara3.sayac++;
								if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 4)
									numara4.sayac++;
								if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 5)
									numara5.sayac++;
								if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 6)
									numara6.sayac++;
								if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 7)
									numara7.sayac++;
								if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 8)
									numara8.sayac++;
								if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 9)
									numara9.sayac++;
							}
					}
					Karakter enbuyuknumara[] = { numara0, numara1, numara2, numara3, numara4, numara5, numara6, numara7,
							numara8, numara9 };
					// Sayaçlarýn en büyük olanýný buluyoruz.
					tcno.add(karakter.enBuyukTCNo(enbuyuknumara).knc);
				}

				String tc = tcno.get(0) + tcno.get(1) + tcno.get(2) + tcno.get(3) + tcno.get(4) + tcno.get(5)
						+ tcno.get(6) + tcno.get(7) + tcno.get(8) + tcno.get(9) + tcno.get(10);

				// tcnolar.add(tc);

				dosya.dosyaAdiOgrNo(file, tc, "images2", yazilanklasor);

				System.out.println(file.getName() + " Öðrenci No : " + tc);

				// Kitapçýk Türü
				Kitapcik kitapcik = new Kitapcik();
				String kitapcik_turu = kitapcik.kitapcikTuru(optik, file);

				// Oturum Bilgisi
				Oturum oturum = new Oturum();
				String oturum_bilgisi = oturum.oturumBilgisi(optik, file);

				// Sýnav Turu
				// SinavTuru sinavTuru = new SinavTuru();
				// String sinav_turu = sinavTuru.sinavTuru(optik, file);

				// Database database = new Database();
				// database.ogrenciKaydet(tc);

				// Cevaplar
				Dersler dersler = new Dersler();
				ArrayList<String> ingilizce = dersler.cevaplariOku(tc, optik, file, Dersler.ingilizce, "Ýngilizce", 25,
						4);
				ArrayList<String> inkilap = dersler.cevaplariOku(tc, optik, file, Dersler.inkilap, "Ýnkýlap", 25, 4);
				ArrayList<String> turkdili = dersler.cevaplariOku(tc, optik, file, Dersler.turkdili, "Türk Dili", 25,
						4);
				ArrayList<String> temelbiltek = dersler.cevaplariOku(tc, optik, file, Dersler.temelbiltek,
						"Temel BilTek", 25, 4);
				System.out.println();

				String dosyayolu = "E:/OptikOkumaProjesi/OptikOkuma/okunanlar/" + yazilanklasor + "/" + tc + ".jpg";
				
				Database.tumBilgileriGir(tc, ingilizce, 1, kitapcik_turu, oturum_bilgisi, OgrenciBilgileri.getSinavturu(),
						OgrenciBilgileri.getYil(), OgrenciBilgileri.getDonem(), OgrenciBilgileri.getPuaningilizce(), dosyayolu, file.getName(), 0);
				Database.tumBilgileriGir(tc, inkilap, 2, kitapcik_turu, oturum_bilgisi, OgrenciBilgileri.getSinavturu(),
						OgrenciBilgileri.getYil(), OgrenciBilgileri.getDonem(), OgrenciBilgileri.getPuaninkilap(), dosyayolu, file.getName(), 0);
				Database.tumBilgileriGir(tc, turkdili, 3, kitapcik_turu, oturum_bilgisi, OgrenciBilgileri.getSinavturu(),
						OgrenciBilgileri.getYil(), OgrenciBilgileri.getDonem(), OgrenciBilgileri.getPuanturkdili(), dosyayolu, file.getName(), 0);
				Database.tumBilgileriGir(tc, temelbiltek, 4, kitapcik_turu, oturum_bilgisi,
						OgrenciBilgileri.getSinavturu(), OgrenciBilgileri.getYil(), OgrenciBilgileri.getDonem(),
						OgrenciBilgileri.getPuantemelbiltek(), dosyayolu, file.getName(), 0);

			} catch (Exception e) {
				System.out.println(file.getName() + " Dosyasý Hatalý!!!");
				Mat mat = new Mat();
				Dosya.klasorOlusturHataliDosyalar(yazilanklasor);
				Imgcodecs.imwrite("E:\\OptikOkumaProjesi\\OptikOkuma\\hatalidosyalar\\hatali_" + yazilanklasor + "\\"
						+ file.getName(), mat);
			}

		}
		/*
		 * String yazilanklasor = OgrenciBilgileri.getYil() + "_" +
		 * OgrenciBilgileri.getDonem() + "_" + OgrenciBilgileri.getSinavturu();
		 * Dosya.klasorOlustur(yazilanklasor);
		 */
		// Renkli optiklerin dosya isimleri öðrenci numarasý oluyor
		System.out.println(
				"Öðrencinin TC nosu dosya adý oluyor. Ardýndan veritabanýnda doðru sayýsý güncellenecektir. Bu iþlem biraz zaman alabilir...");
		// dosya.dosyaAdiOgrNo(tcnolar, "images2", yazilanklasor);

	}

	public void egriligiDuzelt(String klasor, String kirpilanklasor, int esik) {

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Dosya dosya = new Dosya();
		File resimler[] = dosya.dosyalariGetir(klasor);

		for (File file : resimler) {
			Mat resim = Imgcodecs.imread("E:\\OptikOkumaProjesi\\OptikOkuma\\" + klasor + "\\" + file.getName());
			Mat res = new Mat();
			Mat mat = new Mat();
			Imgproc.cvtColor(resim, res, Imgproc.COLOR_RGB2GRAY);
			Imgproc.threshold(res, mat, esik, 255, Imgproc.THRESH_BINARY);
			Imgcodecs.imwrite("E:\\OptikOkumaProjesi\\OptikOkuma\\evreler\\1.jpg", mat);

			int adim = 110;
			int satir = mat.rows() - adim;
			int sutun = mat.cols() - adim;

			double karsi = 3290 - 500;
			double komsu1 = 0, komsu2 = 0;
			double kirp = 0;

			for (int i = 0; i < sutun; i++) {
				double renkler[] = mat.get(500, i + adim);

				System.out.print(i + "---" + renkler[0] + "       ");

				if (renkler[0] == 0.0) {
					komsu1 = i + adim;
					break;
				}
			}
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------------------------");
			for (int i = 0; i < sutun; i++) {
				double renkler[] = mat.get(3290, i + adim);

				System.out.print(i + "---" + renkler[0] + "       ");

				if (renkler[0] == 0.0) {
					komsu2 = i + adim;
					break;
				}
			}
			System.out.println();

			double bolum = (komsu2 - komsu1) / karsi;
			double pozitifaci, negatifaci;
			if (komsu1 > komsu2) {
				pozitifaci = Math.toDegrees(Math.abs(Math.atan(bolum)));
				Mat m = Imgproc.getRotationMatrix2D(new Point(0, komsu1), pozitifaci, 1);
				Mat m2 = new Mat();
				Imgproc.warpAffine(resim, m2, m, resim.size());
				Imgcodecs.imwrite("E:\\OptikOkumaProjesi\\OptikOkuma\\evreler\\2.jpg", m2);
				Rect rect = new Rect(new Point(komsu1 + 5, 0), new Point(m2.cols(), m2.rows()));
				Mat mat2 = new Mat(m2, rect);
				Imgcodecs.imwrite("E:\\OptikOkumaProjesi\\OptikOkuma\\evreler\\3.jpg", mat2);
				Mat gray = new Mat();
				Mat thresh = new Mat();
				Imgproc.cvtColor(mat2, gray, Imgproc.COLOR_RGB2GRAY);
				Imgproc.threshold(gray, thresh, 236, 255, Imgproc.THRESH_BINARY);
				Imgcodecs.imwrite("E:\\OptikOkumaProjesi\\OptikOkuma\\evreler\\4.jpg", thresh);

				for (int i = 500; i < satir; i++) {
					double renkler[] = thresh.get(i, 80);

					System.out.print(i + "---" + renkler[0] + "       ");

					if (renkler[0] == 0.0) {
						kirp = i;
						kirp += 40;
						break;
					}
				}
				Rect kirpilan = new Rect(new Point(0, kirp), new Point(mat2.cols(), mat2.rows()));
				Mat hizalanmis = new Mat(mat2, kirpilan);
				Imgcodecs.imwrite("E:\\OptikOkumaProjesi\\OptikOkuma\\" + kirpilanklasor + "\\" + file.getName(),
						hizalanmis);
			} else {
				negatifaci = -Math.toDegrees(Math.abs(Math.atan(bolum)));
				Mat m = Imgproc.getRotationMatrix2D(new Point(0, komsu1), negatifaci, 1);
				Mat m2 = new Mat();
				Imgproc.warpAffine(resim, m2, m, resim.size());
				Imgcodecs.imwrite("E:\\OptikOkumaProjesi\\OptikOkuma\\evreler\\2.jpg", m2);
				Rect rect = new Rect(new Point(komsu1, 0), new Point(m2.cols(), m2.rows()));
				Mat mat2 = new Mat(m2, rect);
				Imgcodecs.imwrite("E:\\OptikOkumaProjesi\\OptikOkuma\\evreler\\3.jpg", mat2);
				Mat gray = new Mat();
				Mat thresh = new Mat();
				Imgproc.cvtColor(mat2, gray, Imgproc.COLOR_RGB2GRAY);
				Imgproc.threshold(gray, thresh, 236, 255, Imgproc.THRESH_BINARY);
				Imgcodecs.imwrite("E:\\OptikOkumaProjesi\\OptikOkuma\\evreler\\4.jpg", thresh);

				for (int i = 500; i < satir; i++) {
					double renkler[] = thresh.get(i, 80);

					System.out.print(i + "---" + renkler[0] + "       ");

					if (renkler[0] == 0.0) {
						kirp = i;
						kirp += 40;
						break;
					}
				}
				Rect kirpilan = new Rect(new Point(0, kirp), new Point(mat2.cols(), mat2.rows()));
				Mat hizalanmis = new Mat(mat2, kirpilan);
				Imgcodecs.imwrite("E:\\OptikOkumaProjesi\\OptikOkuma\\" + kirpilanklasor + "\\" + file.getName(),
						hizalanmis);
			}
			System.out.println();
			System.out.println("Dosya Adý : " + file.getName());
			System.out.println("Karþý: " + karsi);
			System.out.println("Komþu2 : " + komsu2);
			System.out.println("Komþu1 : " + komsu1);
			System.out.println("Bölüm: " + bolum);
			System.out.println();
			System.out.println(Math.toDegrees(Math.abs(Math.atan(bolum))));
		}
	}
}
