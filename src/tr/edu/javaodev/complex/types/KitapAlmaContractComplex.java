package tr.edu.javaodev.complex.types;

public class KitapAlmaContractComplex {
	private int id;
	private String ogrAdi;
	private String personelAdi;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOgrAdi() {
		return ogrAdi;
	}

	public void setOgrAdi(String ogrAdi) {
		this.ogrAdi = ogrAdi;
	}

	public String getPersonelAdi() {
		return personelAdi;
	}

	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}

	public String getKitapAdi() {
		return kitapAdi;
	}

	public void setKitapAdi(String kitapAdi) {
		this.kitapAdi = kitapAdi;
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
	
	public Object[] getVeriler() {
		Object[] veriler = {id,personelAdi,ogrAdi,kitapAdi,adet,tarih,teslimTarihi};
		return veriler;
	}
	public String toString() {
		return ogrAdi + " " + personelAdi + " " + kitapAdi;
	}
}
