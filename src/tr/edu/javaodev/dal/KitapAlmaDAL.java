package tr.edu.javaodev.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.edu.javaodev.complex.types.KitapAlmaContractComplex;
import tr.edu.javaodev.core.ObjectHelper;
import tr.edu.javaodev.interfaces.IDALInterfacesExtends;
import tr.edu.javaodev.interfaces.IDALInterfacesUD;
import tr.edu.javaodev.types.KitaplarContract;

public class KitapAlmaDAL extends ObjectHelper implements IDALInterfacesExtends<KitaplarContract.KitapAlmaContract> , IDALInterfacesUD<KitaplarContract.KitapAlmaContract> {

	@Override
	public void Insert(KitaplarContract.KitapAlmaContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO kitapalma (KitapId,PersonelId,OgrId,Tarih,Adet,TeslimTarihi) " + "VALUES("
					+ entity.getKitapId() + "," + entity.getPersonelId() + "," + "" + entity.getOgrId() + ",'"
					+ entity.getTarih() + "'," + entity.getAdet() +",'"+entity.getTeslimTarihi()+"')");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<KitapAlmaContractComplex> GetAllVerilen() {
		List<KitapAlmaContractComplex> dataContract = new ArrayList<KitapAlmaContractComplex>();

		Connection conn = getConnection();
		KitapAlmaContractComplex contract;

		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(
					"SELECT kitapalma.Id, personel.AdiSoyadi , uye.OgrNo, kitaplar.Adi, kitapalma.Tarih , kitapalma.Adet , kitapalma.TeslimTarihi FROM kitapalma LEFT JOIN uye ON kitapalma.OgrId = uye.Id LEFT JOIN kitaplar on kitapalma.KitapId = kitaplar.Id LEFT JOIN personel on kitapalma.PersonelId = personel.Id ORDER BY kitapalma.Id DESC");
			while(rs.next()) {
				contract = new KitapAlmaContractComplex();
				
				contract.setId(rs.getInt("kitapalma.Id"));
				contract.setOgrAdi(rs.getString("uye.OgrNo"));
				contract.setPersonelAdi(rs.getString("personel.AdiSoyadi"));
				contract.setKitapAdi(rs.getString("kitaplar.Adi"));
				contract.setTarih(rs.getString("kitapalma.Tarih"));
				contract.setAdet(rs.getInt("kitapalma.Adet"));
				contract.setTeslimTarihi(rs.getString("kitapalma.TeslimTarihi"));
				dataContract.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dataContract;
	}

	public List<KitaplarContract.KitapAlmaContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Delete(KitaplarContract.KitapAlmaContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(KitaplarContract.KitapAlmaContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<KitaplarContract.KitapAlmaContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
