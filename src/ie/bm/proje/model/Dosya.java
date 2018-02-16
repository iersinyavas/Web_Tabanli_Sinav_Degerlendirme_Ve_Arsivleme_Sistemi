package ie.bm.proje.model;

import java.io.File;
import java.util.ArrayList;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import ie.bm.proje.model.Dosya;

public class Dosya {

	public void dosyaAdiOgrNo(ArrayList<String> ogrnolar, String okunanklasor, String yazilanklasor) {
		Dosya dosya = new Dosya();

		File dosyalar[] = dosya.dosyalariGetir(okunanklasor);
		int index = 0;
		for (File file : dosyalar) {
			Mat optik = Imgcodecs.imread("E:\\OptikOkumaProjesi\\OptikOkuma\\" + okunanklasor + "\\" + file.getName());
			Imgcodecs.imwrite("E:\\OptikOkumaProjesi\\OptikOkuma\\okunanlar\\" + yazilanklasor + "\\"
					+ ogrnolar.get(index) + ".jpg", optik);
			index++;
		}
	}

	public void dosyaAdiOgrNo(File dosyaadi, String ogrno, String okunanklasor, String yazilanklasor) {
		Dosya dosya = new Dosya();

		Mat mat = Imgcodecs.imread("E:\\OptikOkumaProjesi\\OptikOkuma\\" + okunanklasor + "\\"
				+ dosya.dosyaGetir(okunanklasor, dosyaadi).getName());
		Imgcodecs.imwrite("E:\\OptikOkumaProjesi\\OptikOkuma\\okunanlar\\" + yazilanklasor + "\\" + ogrno + ".jpg",
				mat);

	}

	public File dosyaGetir(String klasor, File dosyaadi) {
		File file = new File("E:\\OptikOkumaProjesi\\OptikOkuma\\" + klasor + "\\" + dosyaadi.getName());
		return file;
	}

	public File[] optikDosyasiniGetir() {
		File file = new File("E:\\OptikOkumaProjesi\\OptikOkuma\\WebContent\\images\\optik");
		File dosyaListesi[] = file.listFiles();
		return dosyaListesi;
	}
	
	public File[] dosyalariGetir(String klasor) {
		File file = new File("E:\\OptikOkumaProjesi\\OptikOkuma\\" + klasor);
		File dosyaListesi[] = file.listFiles();
		return dosyaListesi;
	}
	
	public static void klasorOlusturHataliDosyalar(String klasoradi) {
		File klasor = new File("E:\\OptikOkumaProjesi\\OptikOkuma\\hatalidosyalar\\hatali_" + klasoradi);
		klasor.mkdir(); // Klasör oluþturuluyor
	}

	public static void klasorOlustur(String klasoradi) {
		File klasor = new File("E:\\OptikOkumaProjesi\\OptikOkuma\\okunanlar\\" + klasoradi);
		klasor.mkdir(); // Klasör oluþturuluyor
	}

}
