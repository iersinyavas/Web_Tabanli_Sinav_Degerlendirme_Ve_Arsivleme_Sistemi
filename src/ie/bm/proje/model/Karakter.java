package ie.bm.proje.model;

import ie.bm.proje.model.Karakter;

public class Karakter {

	public String knc = " ";
	public int sayac = 0;

	public Karakter() {

	}

	public Karakter(String knc) {
		this.knc = knc;
	}

	public Karakter enBuyukCevap(Karakter dizi[]) {
		Karakter enbuyuk = new Karakter();
		for (int i = 0; i < dizi.length; i++) {                //50
			if (enbuyuk.sayac < dizi[i].sayac && dizi[i].sayac > 30 && dizi[i].sayac < 2000 && enbuyuk.kontrol(dizi, i))
				enbuyuk = dizi[i];
		}
		return enbuyuk;
	}

	public Karakter enBuyukTCNo(Karakter dizi[]) {
		Karakter enbuyuk = new Karakter();
		for (int i = 0; i < dizi.length; i++) {                 //30
			if (enbuyuk.sayac < dizi[i].sayac && dizi[i].sayac > 25 && dizi[i].sayac < 2000 && enbuyuk.kontrol(dizi, i))
				enbuyuk = dizi[i];
		}
		return enbuyuk;
	}

	public Karakter enBuyukKitapcik(Karakter dizi[]) {
		Karakter enbuyuk = new Karakter();
		for (int i = 0; i < dizi.length; i++) {                 //50
			if (enbuyuk.sayac < dizi[i].sayac && dizi[i].sayac > 50 && dizi[i].sayac < 2000 && enbuyuk.kontrol(dizi, i))
				enbuyuk = dizi[i];
		}
		return enbuyuk;
	}

	public Karakter enBuyukOturum(Karakter dizi[]) {
		Karakter enbuyuk = new Karakter();
		for (int i = 0; i < dizi.length; i++) {                 //50
			if (enbuyuk.sayac < dizi[i].sayac && dizi[i].sayac > 50 && dizi[i].sayac < 2000 && enbuyuk.kontrol(dizi, i))
				enbuyuk = dizi[i];
		}
		return enbuyuk;
	}

	/*public Karakter enBuyukSinavTuru(Karakter dizi[]) {
		Karakter enbuyuk = new Karakter();
		for (int i = 0; i < dizi.length; i++) {
			if (enbuyuk.sayac < dizi[i].sayac && dizi[i].sayac > 50 && dizi[i].sayac < 2000 && enbuyuk.kontrol(dizi, i))
				enbuyuk = dizi[i];
		}
		return enbuyuk;
	}*/

	public boolean kontrol(Karakter dizi[], int index) {
		for (int i = 0; i < dizi.length; i++)
			if (dizi[i].sayac > 130 && i != index) {
				return false;
			} else
				continue;
		return true;
	}

}
