package tr.edu.javaodev.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.edu.javaodev.complex.types.KitapStokContractComplex;
import tr.edu.javaodev.complex.types.KitapStokTotalContractComplex;
import tr.edu.javaodev.core.ObjectHelper;
import tr.edu.javaodev.interfaces.IDALInterfacesExtends;
import tr.edu.javaodev.interfaces.IDALInterfacesUD;
import tr.edu.javaodev.types.KitapStokContract;

public class StokDAL extends ObjectHelper implements IDALInterfacesExtends<KitapStokContract> , IDALInterfacesUD<KitapStokContract>  {

	@Override
	public void Insert(KitapStokContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO stok (PersonelId,KitapId,Adet,Tarih) "
					+ "VALUES("+entity.getPersonelId()+","+entity.getKitapId()+ ","
							+ ""+entity.getAdet()+",'"+entity.getTarih()+"' )");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<KitapStokContractComplex> GetAllStok(){
		List<KitapStokContractComplex> datacontract = new ArrayList<KitapStokContractComplex>();
		Connection connection = getConnection();
		KitapStokContractComplex contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT stok.Id, AdiSoyadi , Adi, Adet , stok.Tarih FROM stok LEFT JOIN kitaplar on stok.KitapId = kitaplar.Id LEFT JOIN personel on stok.PersonelId = personel.Id ORDER BY stok.Id DESC");
			while (resultSet.next()) {
				contract = new KitapStokContractComplex();
				contract.setId(resultSet.getInt("stok.Id"));
				contract.setPersonelAdi(resultSet.getString("AdiSoyadi"));
				contract.setKitapAdi(resultSet.getString("Adi"));
				contract.setAdet(resultSet.getInt("Adet"));
				contract.setTarih(resultSet.getString("stok.Tarih"));
				

				datacontract.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}
	
	public List<KitapStokTotalContractComplex> GetTotalStok(){
		List<KitapStokTotalContractComplex> datacontract = new ArrayList<KitapStokTotalContractComplex>();
		Connection connection = getConnection();
		KitapStokTotalContractComplex contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT SUM(Adet) as toplam, stok.Id , kitaplar.Adi , personel.AdiSoyadi , Adet , stok.Tarih FROM stok LEFT JOIN kitaplar on stok.KitapId = kitaplar.Id LEFT JOIN personel on stok.PersonelId = personel.Id GROUP BY KitapId");
			while (resultSet.next()) {
				contract = new KitapStokTotalContractComplex();
				contract.setToplam(resultSet.getInt("toplam"));
				contract.setId(resultSet.getInt("stok.Id"));
				//contract.setPersonelAdi(resultSet.getString("AdiSoyadi"));
				contract.setKitapAdi(resultSet.getString("Adi"));
				contract.setAdet(resultSet.getInt("Adet"));
				contract.setTarih(resultSet.getString("stok.Tarih"));
				

				datacontract.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}
	@Override
	public List<KitapStokContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Delete(KitapStokContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM stok WHERE KitapId = "+entity.getKitapId()+"");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public void Update(KitapStokContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<KitapStokContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
