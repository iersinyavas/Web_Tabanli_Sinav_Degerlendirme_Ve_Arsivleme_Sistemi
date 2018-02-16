package ie.bm.proje.model;

import java.io.File;
import java.util.ArrayList;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import ie.bm.proje.model.Dersler;
import ie.bm.proje.model.Dosya;
import ie.bm.proje.model.Karakter;

public class CevapAnahtari {

	public ArrayList<String> ingilizcecevapanahtari = new ArrayList<String>();
	public ArrayList<String> inkilapcevapanahtari = new ArrayList<String>();
	public ArrayList<String> turkdilicevapanahtari = new ArrayList<String>();
	public ArrayList<String> temelbiltekcevapanahtari = new ArrayList<String>();

	public CevapAnahtari(int i) {

	}

	public CevapAnahtari() {
		this.ingilizcecevapanahtari = cevapAnahtariOku(Dersler.ingilizce);
		this.inkilapcevapanahtari = cevapAnahtariOku(Dersler.inkilap);
		this.turkdilicevapanahtari = cevapAnahtariOku(Dersler.turkdili);
		this.temelbiltekcevapanahtari = cevapAnahtariOku(Dersler.temelbiltek);
	}

	public ArrayList<String> cevapAnahtariOku(int dersno) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Dosya dosya = new Dosya();
		File cevapanahtarlari[] = dosya.dosyalariGetir("cevapanahtarikirp");

		Karakter cevapA = new Karakter("A");
		Karakter cevapB = new Karakter("B");
		Karakter cevapC = new Karakter("C");
		Karakter cevapD = new Karakter("D");
		Karakter karakter = new Karakter();
		ArrayList<String> cevapanahtari = new ArrayList<String>();
		for (File file : cevapanahtarlari) {
			Mat optik = Imgcodecs
					.imread("E:\\OptikOkumaProjesi\\OptikOkuma\\cevapanahtarikirp\\" + file.getName());
			for (int j = 0; j < 25; j++) {
				cevapA.sayac = 0;
				cevapB.sayac = 0;
				cevapC.sayac = 0;
				cevapD.sayac = 0;

				for (int i = 0; i < 4; i++) {
					Rect rect = new Rect((i + dersno) * 50, (j + 32) * 50, 50, 50);
					Mat mat = new Mat(optik, rect);
					int satir = mat.rows();
					int sutun = mat.cols();
					for (int a = 0; a < satir; a++)
						for (int b = 0; b < sutun; b++) {
							double dizi[] = mat.get(a, b);

							if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 0)
								cevapA.sayac++;
							if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 1)
								cevapB.sayac++;
							if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 2)
								cevapC.sayac++;
							if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 3)
								cevapD.sayac++;
						}
				}
				Karakter enbuyukcevapanahtari[] = { cevapA, cevapB, cevapC, cevapD };
				// Sayaçlarýn en büyük olanýný buluyoruz.
				cevapanahtari.add(karakter.enBuyukCevap(enbuyukcevapanahtari).knc);
			}
		}

		return cevapanahtari;
	}

}
