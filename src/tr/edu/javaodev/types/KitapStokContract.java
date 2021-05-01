package tr.edu.javaodev.types;

public class KitapStokContract {
	private int id;
	private int personelId;
	private int kitapId;
	private int adet;
	private String tarih;
	
	public KitapStokContract() {
	}
	public KitapStokContract(int a) {
		adet = a;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTarih() {
		return tarih;
	}

	public void setTarih(String tarih) {
		this.tarih = tarih;
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

	public String toString() {
		return id + " " + " " + personelId + " " + kitapId + " " + adet;
	}
}
