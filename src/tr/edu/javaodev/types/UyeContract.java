package tr.edu.javaodev.types;

public class UyeContract {
	private int id;
	private String adiSoyadi;
	private String ogrno;
	private String fakulte;
	private String bolum;
	private int sinif;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdiSoyadi() {
		return adiSoyadi;
	}

	public void setAdiSoyadi(String adiSoyadi) {
		this.adiSoyadi = adiSoyadi;
	}

	public String getOgrno() {
		return ogrno;
	}

	public void setOgrno(String ogrno) {
		this.ogrno = ogrno;
	}

	public String getFakulte() {
		return fakulte;
	}

	public void setFakulte(String fakulte) {
		this.fakulte = fakulte;
	}

	public String getBolum() {
		return bolum;
	}

	public void setBolum(String bolum) {
		this.bolum = bolum;
	}

	public int getSinif() {
		return sinif;
	}

	public void setSinif(int sinif) {
		this.sinif = sinif;
	}

	public String toString() {
		return adiSoyadi + " " + ogrno;
	}
}
