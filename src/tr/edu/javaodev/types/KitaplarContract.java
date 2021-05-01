package tr.edu.javaodev.types;

public class KitaplarContract {
	private int id;
	private String adi;
	private int kategoriId;
	private String tarih;
	private int sayfa;

	public int getSayfa() {
		return sayfa;
	}

	public void setSayfa(int sayfa) {
		this.sayfa = sayfa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKitapAdi() {
		return adi;
	}

	public void setKitapAdi(String kitapAdi) {
		this.adi = kitapAdi;
	}

	public int getKategoriId() {
		return kategoriId;
	}

	public void setKategoriId(int kategoriId) {
		this.kategoriId = kategoriId;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	

	public String toString() {
		return  adi ;
	}
	public class KitapAlmaContract {
		private int id;
		private int ogrId;
		private int personelId;
		private int kitapId;
		private String kitapAdi;
		private int adet;
		private String tarih;
		private String teslimTarihi;


		public String getTeslimTarihi() {
			return teslimTarihi;
		}

		public void setTeslimTarihi(String teslimTarihi) {
			this.teslimTarihi = teslimTarihi;
		}

		public String getKitapAdi() {
			return kitapAdi;
		}

		public void setKitapAdi(String kitapAdi) {
			this.kitapAdi = kitapAdi;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getOgrId() {
			return ogrId;
		}

		public void setOgrId(int ogrId) {
			this.ogrId = ogrId;
		}

		public int getPersonelId() {
			return personelId;
		}

		public void setPersonelId(int personelId) {
			this.personelId = personelId;
		}

		public int getKitapId() {
			return kitapId;
		}

		public void setKitapId(int kitapId) {
			this.kitapId = kitapId;
		}

		public int getAdet() {
			return adet;
		}

		public void setAdet(int adet) {
			this.adet = adet;
		}

		public String getTarih() {
			return tarih;
		}

		public void setTarih(String tarih) {
			this.tarih = tarih;
		}

		public String toString() {
			return id + " " + ogrId + " " + " " + personelId + " " + kitapId + " " + adet + " " + tarih;
		}

	}

}