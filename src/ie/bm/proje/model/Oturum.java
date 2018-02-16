package ie.bm.proje.model;

import java.io.File;

import org.opencv.core.Mat;
import org.opencv.core.Rect;

import ie.bm.proje.model.Karakter;

public class Oturum {

	public String oturumBilgisi(Mat optik, File file) {
		Karakter oturum1 = new Karakter("1");
		Karakter oturum2 = new Karakter("2");
		Karakter karakter = new Karakter();
		for (int i = 12; i < 17; i += 4) {
			Rect rect = new Rect(i * 50, 0, 50, 50);
			Mat mat = new Mat(optik, rect);
			int satir = mat.rows();
			int sutun = mat.cols();
			for (int a = 0; a < satir; a++)
				for (int b = 0; b < sutun; b++) {
					double dizi[] = mat.get(a, b);

					if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 12)
						oturum1.sayac++;
					if (dizi[0] == 0 && dizi[1] == 0 && dizi[2] == 0 && i == 16)
						oturum2.sayac++;
				}
		}
		Karakter enbuyukoturum[] = { oturum1, oturum2 };
		// Sayaçlarýn en büyük olanýný buluyoruz.
		System.out.println(file.getName() + " ------> Oturum : " + karakter.enBuyukOturum(enbuyukoturum).knc);

		return karakter.enBuyukOturum(enbuyukoturum).knc;
	}

}
