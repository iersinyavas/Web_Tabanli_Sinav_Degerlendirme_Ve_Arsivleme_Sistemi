package ie.bm.proje.model;

import java.io.File;

import org.opencv.core.Mat;
import org.opencv.core.Rect;

import ie.bm.proje.model.Karakter;

public class Kitapcik {
	public static int basamak = 50;
	public static int baslangicnoktasi = 0;
	public String kitapcikTuru(Mat optik, File file){
		Karakter kitapcikA = new Karakter("A");
		Karakter kitapcikB = new Karakter("B");
		Karakter kitapcikC = new Karakter("C");
		Karakter kitapcikD = new Karakter("D");
		Karakter karakter = new Karakter();
		kitapcikA.sayac = 0;
		kitapcikB.sayac = 0;
		kitapcikC.sayac = 0;
		kitapcikD.sayac = 0;
		
		for (int i = baslangicnoktasi+2; i < 9; i += 2) {
			Rect rect = new Rect(i * basamak, 0, basamak, basamak);
			Mat mat = new Mat(optik, rect);
			int satir = mat.rows();
			int sutun = mat.cols();
			for (int a = 0; a < satir; a++)
				for (int b = 0; b < sutun; b++) {
					double dizi[] = mat.get(a, b);

					if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 2)
						kitapcikA.sayac++;
					if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 4)
						kitapcikB.sayac++;
					if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 6)
						kitapcikC.sayac++;
					if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 8)
						kitapcikD.sayac++;
				}
		}
		Karakter enbuyukkitapcik[] = { kitapcikA, kitapcikB, kitapcikC, kitapcikD };
		// Sayaçlarýn en büyük olanýný buluyoruz.
		System.out.println(file.getName() + " ------> Kitapçýk : " + karakter.enBuyukKitapcik(enbuyukkitapcik).knc);
		
		return karakter.enBuyukKitapcik(enbuyukkitapcik).knc;
	}
}
