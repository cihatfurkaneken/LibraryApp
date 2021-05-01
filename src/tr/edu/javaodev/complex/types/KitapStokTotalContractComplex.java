package tr.edu.javaodev.complex.types;

public class KitapStokTotalContractComplex {

	private int id;
	private String kitapAdi;
	private String personelAdi;
	private int adet;
	private int toplam;
	private String tarih;

	public int getToplam() {
		return toplam;
	}

	public void setToplam(int toplam) {
		this.toplam = toplam;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKitapAdi() {
		return kitapAdi;
	}

	public void setKitapAdi(String kitapAdi) {
		this.kitapAdi = kitapAdi;
	}

	public String getPersonelAdi() {
		return personelAdi;
	}

	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}

	public int getAdet() {
		return adet;
	}

	public void setAdet(int adet) {
		this.adet = adet;
	}

	public Object[] getVeriler() {
		Object[] veriler = { id, kitapAdi, personelAdi, toplam, tarih };
		return veriler;
	}

	public String toString() {
		return personelAdi + " " + kitapAdi;
	}
}
