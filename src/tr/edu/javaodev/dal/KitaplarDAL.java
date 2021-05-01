package tr.edu.javaodev.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.edu.javaodev.core.ObjectHelper;
import tr.edu.javaodev.interfaces.IDALInterfacesExtends;
import tr.edu.javaodev.interfaces.IDALInterfacesUD;
import tr.edu.javaodev.types.KitaplarContract;

public class KitaplarDAL extends ObjectHelper
		implements IDALInterfacesExtends<KitaplarContract>, IDALInterfacesUD<KitaplarContract> {

	@Override
	public void Insert(KitaplarContract entity) {
		Connection connection = getConnection();

		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(
					"INSERT INTO kitaplar(adi,kategoriId,tarih,sayfa) " + "VALUES ('" + entity.getKitapAdi() + "',"
							+ entity.getKategoriId() + ",'" + entity.getTarih() + "'," + entity.getSayfa() + ")");
			connection.close();
			statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<KitaplarContract> GetAll() {
		List<KitaplarContract> datacontract = new ArrayList<KitaplarContract>();
		Connection connection = getConnection();
		KitaplarContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM kitaplar");
			while (resultSet.next()) {
				contract = new KitaplarContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setKitapAdi(resultSet.getString("Adi"));
				contract.setKategoriId(resultSet.getInt("KategoriId"));
				contract.setTarih(resultSet.getString("Tarih"));
				contract.setSayfa(resultSet.getInt("Sayfa"));

				datacontract.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}

	@Override
	public void Delete(KitaplarContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM kitaplar WHERE Id = "+entity.getId()+"");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void Update(KitaplarContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("UPDATE kitaplar SET Adi = '" + entity.getKitapAdi() + "',KategoriId = '"
                    + entity.getKategoriId() + "' ,Tarih= '" + entity.getTarih() + "',Sayfa='" + entity.getSayfa()
                    + "'WHERE Id = " + entity.getId() + "");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<KitaplarContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
