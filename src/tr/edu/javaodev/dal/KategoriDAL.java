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
import tr.edu.javaodev.types.KategoriContract;

public class KategoriDAL extends ObjectHelper
		implements IDALInterfacesExtends<KategoriContract>, IDALInterfacesUD<KategoriContract> {

	public void Insert(KategoriContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO kategori (Adi,ParentId) VALUES('" + entity.getAdi() + "',"
					+ entity.getParentId() + ")");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<KategoriContract> GetAll() {
		List<KategoriContract> datacontract = new ArrayList<KategoriContract>();
		Connection connection = getConnection();
		KategoriContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM kategori");
			while (resultSet.next()) {
				contract = new KategoriContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdi(resultSet.getString("Adi"));
				contract.setParentId(resultSet.getInt("ParentId"));

				datacontract.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}

	public List<KategoriContract> GetAllParentId() {
		List<KategoriContract> datacontract = new ArrayList<KategoriContract>();
		Connection connection = getConnection();
		KategoriContract contract;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM kategori");
			while (resultSet.next()) {
				contract = new KategoriContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setAdi(resultSet.getString("Adi"));
				contract.setParentId(resultSet.getInt("ParentId"));

				datacontract.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return datacontract;
	}

	@Override
	public void Delete(KategoriContract entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update(KategoriContract entity) {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("UPDATE kategori SET Adi = '" + entity.getAdi() + "',ParentId = "
					+ entity.getParentId() + " WHERE Id = " + entity.getId() + "");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<KategoriContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<KategoriContract> GetSearchKategori(String kategoriAdi) {
		List<KategoriContract> dataContract = new ArrayList<KategoriContract>();
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT * FROM kategori WHERE Adi LIKE '" + "%" + kategoriAdi + "%" + "'");
			while (rs.next()) {
				KategoriContract contract = new KategoriContract();

				contract.setAdi(rs.getString("Adi"));
				contract.setParentId(rs.getInt("ParentId"));

				dataContract.add(contract);

			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dataContract;
	}

}
