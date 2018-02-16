/*package ie.bm.proje.model;

import java.io.File;

import org.opencv.core.Mat;
import org.opencv.core.Rect;

import ie.bm.proje.model.Karakter;

public class SinavTuru {

	public String sinavTuru(Mat optik, File file) {
		Karakter sinavturu1 = new Karakter("Ara Sınav");
		Karakter sinavturu2 = new Karakter("Final");
		Karakter sinavturu3 = new Karakter("Bütünleme");
		Karakter sinavturu4 = new Karakter("Mazeret");
		Karakter sinavturu5 = new Karakter("Seviye Tespit");
		Karakter karakter = new Karakter();
		sinavturu1.sayac = 0;
		sinavturu2.sayac = 0;
		sinavturu3.sayac = 0;
		sinavturu4.sayac = 0;
		sinavturu5.sayac = 0;
		for (int i = 0; i < 5; i++) {
			Rect rect = new Rect(0, (i + 17) * 50, 50, 50);
			Mat mat = new Mat(optik, rect);
			int satir = mat.rows();
			int sutun = mat.cols();
			for (int a = 0; a < satir; a++)
				for (int b = 0; b < sutun; b++) {
					double dizi[] = mat.get(a, b);
					if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 0)
						sinavturu1.sayac++;
					if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 1)
						sinavturu2.sayac++;
					if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 2)
						sinavturu3.sayac++;
					if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 3)
						sinavturu4.sayac++;
					if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 4)
						sinavturu5.sayac++;

				}
		}
		Karakter enbuyuksinavturu[] = { sinavturu1, sinavturu2, sinavturu3, sinavturu4, sinavturu5 };
		// Sayaçların en büyük olanını buluyoruz.
		System.out.println(file.getName() + " ------> Sinav Türü : " + karakter.enBuyukSinavTuru(enbuyuksinavturu).knc);

		return karakter.enBuyukSinavTuru(enbuyuksinavturu).knc;
	}

}*/
