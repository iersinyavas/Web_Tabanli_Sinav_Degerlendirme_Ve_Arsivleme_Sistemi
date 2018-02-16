package ie.bm.proje.model;

import java.io.File;
import java.util.ArrayList;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import ie.bm.proje.model.Karakter;

public class Dersler {

	public static int ingilizce = 1;
	public static int inkilap = 6;
	public static int turkdili = 11;
	public static int temelbiltek = 16;
	public static int dikeykoordinat = 32;
	public static int basamak = 50;

	public ArrayList<String> cevaplariOku(String ogr_tcno, Mat optik, File file, int dersno, String dersinadi,
			int sorusayisi, int yanitsayisi) {
		Karakter cevapA = new Karakter("A");
		Karakter cevapB = new Karakter("B");
		Karakter cevapC = new Karakter("C");
		Karakter cevapD = new Karakter("D");
		Karakter karakter = new Karakter();
		ArrayList<String> cevaplar = new ArrayList<String>();
		for (int j = 0; j < sorusayisi; j++) {
			cevapA.sayac = 0;
			cevapB.sayac = 0;
			cevapC.sayac = 0;
			cevapD.sayac = 0;

			for (int i = 0; i < yanitsayisi; i++) {
				Rect rect = new Rect((i + dersno) * basamak, (j + dikeykoordinat) * basamak, basamak, basamak);
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
			Karakter enbuyukcevap[] = { cevapA, cevapB, cevapC, cevapD };
			// Sayaçlarýn en büyük olanýný buluyoruz.
			cevaplar.add(karakter.enBuyukCevap(enbuyukcevap).knc);
		}

		System.out.print(file.getName() + " ------> " + dersinadi + " : ");
		for (int k = 0; k < cevaplar.size(); k++) {
			System.out.print(cevaplar.get(k));
		}
		System.out.println();

		return cevaplar;
	}

}
